package com.ivankoi.jee6.business.promis;

import static org.junit.Assert.*;

import javax.xml.soap.SOAPException;

import org.junit.Test;

import eu.europa.ec.research.fp.services.project_artefact_submission.interfaces.v2.SearchProjectArtefactSubmissionResponseType;

public class ProjectArtefactSaajClientTest {

	@Test
	public void test() throws SOAPException, Exception {
		ProjectArtefactSaajClient saajClient = new ProjectArtefactSaajClient();
		SearchProjectArtefactSubmissionResponseType projectArtefactSubmissionResponseType = saajClient.callArtefactService("300333", "1", "promis_user", "iMCcR0FH");
		
		assertTrue(projectArtefactSubmissionResponseType.getProjectArtefactSubmissionCoreList().getProjectArtefactSubmissionCore().size() > 0);
	}

}
