package com.ivankoi.jee6.business.calculator;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.inject.Named;
import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Holder;




import javax.xml.ws.Service;

import eu.europa.ec.research.fp.model.code_ref.v2.CodeRefType;
import eu.europa.ec.research.fp.model.project_ref.v2.ProjectRefType;
import eu.europa.ec.research.fp.model.service_context.v2.ResultContextType;
import eu.europa.ec.research.fp.services.project_list.interfaces.v3.GetProjectDetailsResponse.ProjectList;
import eu.europa.ec.research.fp.services.project_list.interfaces.v3.ProjectCoreListType;
import eu.europa.ec.research.fp.services.project_list.interfaces.v3.ProjectDetailsIncludeFilterType;
import eu.europa.ec.research.fp.services.project_list.v3.IResearchProjectsListService;

import com.ivankoi.jee6.business.calculator.boundary.HeaderHandlerResolver;

@Named
public class CpmConsumer {

	public void cpmSecuredInvoker() throws Exception {
		URL wsdlURL = new URL("http://localhost:8888/cpm/researchProjectList-3.3?wsdl");
        QName qname = new QName("http://ec.europa.eu/research/fp/services/project-list/V3", "ResearchProjectsListService");
        
		Service service = Service.create(wsdlURL, qname);
		HeaderHandlerResolver handlerResolver = new HeaderHandlerResolver("promis_user", "iMCcR0FH");
		service.setHandlerResolver(handlerResolver);
		
		IResearchProjectsListService port = service.getPort(IResearchProjectsListService.class);
	
		Map<String, Object> ctx = ((BindingProvider)port).getRequestContext();
        ctx.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, "http://localhost:8888/cpm/researchProjectList-3.3");
        
        Holder<ResultContextType> rctHolder = new Holder<ResultContextType>();
		Holder<ProjectCoreListType> pcltHolder = new Holder<ProjectCoreListType>(); 
		Holder<ProjectList> plHolder = new Holder<ProjectList>();
		
		port.getProjectDetails(getProjectRefTypeList(Arrays.asList(300333l)), getProjectDetailsIncludeFilterTypeList(), null, pcltHolder, plHolder, rctHolder);
		
	}

	private List<ProjectRefType> getProjectRefTypeList(List<Long> contractNumbers) {
		List<ProjectRefType> prtList = new ArrayList<ProjectRefType>(contractNumbers.size());

		for (Long contractNumber : contractNumbers) {
			ProjectRefType prt = new ProjectRefType();
			CodeRefType crt = new CodeRefType();
			crt.setId("10000009");
			prt.setProgram(crt);
			prt.setDG("REA");
			prt.setNumber(contractNumber.toString());		
			
			prtList.add(prt);
		}
		return prtList;
	}
	
	private List<ProjectDetailsIncludeFilterType> getProjectDetailsIncludeFilterTypeList() {
		List<ProjectDetailsIncludeFilterType> pdiftList = new ArrayList<ProjectDetailsIncludeFilterType>();
		pdiftList.add(ProjectDetailsIncludeFilterType.FINANCIAL);
		pdiftList.add(ProjectDetailsIncludeFilterType.SPECIAL_CLAUSES);
		pdiftList.add(ProjectDetailsIncludeFilterType.GENERAL);	
		return pdiftList;
	}
}
