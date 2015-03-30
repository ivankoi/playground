package com.packpub.ws.security;

import java.security.acl.Group;

import javax.security.auth.login.LoginException;

import org.jboss.security.SimpleGroup;
import org.jboss.security.auth.spi.UsernamePasswordLoginModule;

public class CustomLoginModule extends UsernamePasswordLoginModule {

	@Override
	protected String getUsersPassword() throws LoginException {
		return "password";
	}

	@Override
	protected Group[] getRoleSets() throws LoginException {
		return new Group[]{new SimpleGroup("JBossAdmin")};
	}

}
