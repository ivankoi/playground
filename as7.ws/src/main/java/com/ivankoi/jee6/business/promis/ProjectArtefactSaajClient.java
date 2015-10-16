package com.ivankoi.jee6.business.promis;

import java.util.HashMap;

import javax.inject.Named;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Unmarshaller;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.transform.dom.DOMSource;

import com.ivankoi.jee6.business.controls.SaajClient;

import eu.europa.ec.research.fp.model.project_reportingperiod_submission.v2.ProjectReportingPeriodSubmissionType;
import eu.europa.ec.research.fp.services.project_artefact_submission.interfaces.v2.SearchProjectArtefactSubmissionResponseType;

/**
 * Low Level SAAJ implementation of SOAP communication with ProjectArtefactService. 
 * JBoss 5.1 AS has a problem to invoke this service due to binding issues. We tried a lot of things 
 * but it couldn't work. So as long as we are on JBoss 5.1 this approach should be kept.
 * 
 *  If one day AS is changed normal JAX-WS should be used.
 * 
 * @author ivankiv
 *
 */
@Named
public class ProjectArtefactSaajClient extends SaajClient {
	private static final String PROJECT_ARTEFACT_SOAP_REQUEST_TEMPLATE;
	private static final String ARTEFACT_DETAIL_SOAP_REQUEST_TEMPLATE;
	
	static {
		StringBuilder sb = new StringBuilder();
		sb.append("<?xml version=\"1.0\"  standalone=\"no\"?>");
		sb.append("<S:Envelope xmlns:S=\"http://schemas.xmlsoap.org/soap/envelope/\">");
		sb.append("<S:Header/>");
		sb.append("<S:Body>");
		sb.append("	<ns40:SearchProjectArtefactSubmissionRequest ");
		sb.append("   		xmlns:ns40=\"http://ec.europa.eu/research/fp/services/project-artefact-submission/interfaces/V2\"");
		sb.append(" 		xmlns:ns2=\"http://ec.europa.eu/research/fp/model/code-ref/V2\"");
		sb.append(" 		xmlns:ns3=\"http://ec.europa.eu/research/fp/model/project-ref/V2\">");
		sb.append("		<ProjectId>");
		sb.append("			<ns3:Program>");
		sb.append("				<ns2:Id>10000009</ns2:Id>");
		sb.append("			</ns3:Program>");
		sb.append("			<ns3:Number>##CONTRACT_NUMBER##</ns3:Number>"); // CONTRACT_NUMBER to be introduced with replace
		sb.append("			<ns3:DG>REA</ns3:DG>");
		sb.append("		</ProjectId>");
		sb.append("		<ReportingPeriod>##RP_NUM##</ReportingPeriod>"); // RP_NUM to be introduced with replace
		sb.append("	</ns40:SearchProjectArtefactSubmissionRequest>");
		sb.append("</S:Body>");
		sb.append("</S:Envelope>");
		
		PROJECT_ARTEFACT_SOAP_REQUEST_TEMPLATE = sb.toString();
		
		sb = new StringBuilder();
		sb.append("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:v2=\"http://ec.europa.eu/research/fp/services/project-artefact-submission/interfaces/V2\" xmlns:v1=\"http://ec.europa.eu/research/fp/model/header/V1\">");
		sb.append("   <soapenv:Header/>");
		sb.append("   <soapenv:Body>");
		sb.append("      <v2:GetProjectArtefactSubmissionDetailRequest>");
		sb.append("         <ProjectArtefactSubmissionId>##SUBMISSION_ID##</ProjectArtefactSubmissionId>");
		sb.append("      </v2:GetProjectArtefactSubmissionDetailRequest>");
		sb.append("   </soapenv:Body>");
		sb.append("</soapenv:Envelope>");
		
		ARTEFACT_DETAIL_SOAP_REQUEST_TEMPLATE = sb.toString();
	}
	
	static final String PROJECT_ARTEFACT_SUBMISSION_ENDPOINT = "http://prodsb.fp6.cc.cec.eu.int:6121/formc/projectArtefactSubmission-2.0";
	
	
	public SearchProjectArtefactSubmissionResponseType callArtefactService(final String contractNumber, final String rpNum, String username, String password) throws SOAPException, Exception {
		
		@SuppressWarnings("serial")
		SOAPMessage response = callWithSaaj(buildDocumentWithSecuredHeader(prepareRequestFromTemplate(
							PROJECT_ARTEFACT_SOAP_REQUEST_TEMPLATE,
							new HashMap<String, String>(){{
								put("##CONTRACT_NUMBER##", contractNumber); 
								put("##RP_NUM##", rpNum); 
							}}),
							username,
							password));
		
		DOMSource source = new DOMSource(response.getSOAPBody().getFirstChild());
		
		JAXBContext context = JAXBContext.newInstance(SearchProjectArtefactSubmissionResponseType.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		JAXBElement<SearchProjectArtefactSubmissionResponseType> result = unmarshaller.unmarshal(source, SearchProjectArtefactSubmissionResponseType.class);
		return result.getValue();
	}
	
	public ProjectReportingPeriodSubmissionType callArtefactDetailsService(final String submissionId, String username, String password) throws SOAPException, Exception {
		
		@SuppressWarnings("serial")
		SOAPMessage response = callWithSaaj(buildDocumentWithSecuredHeader(prepareRequestFromTemplate(
							ARTEFACT_DETAIL_SOAP_REQUEST_TEMPLATE,
							new HashMap<String, String>(){{
								put("##SUBMISSION_ID##", submissionId); 
							}}),
							username,
							password));
		
		DOMSource source = new DOMSource(response.getSOAPBody().getFirstChild().getFirstChild());
		
		JAXBContext context = JAXBContext.newInstance(ProjectReportingPeriodSubmissionType.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		JAXBElement<ProjectReportingPeriodSubmissionType> result = unmarshaller.unmarshal(source, ProjectReportingPeriodSubmissionType.class);
		return result.getValue();
	}
	
	@Override
	protected String getWsEndpoint() {
		return PROJECT_ARTEFACT_SUBMISSION_ENDPOINT;
	}

}


