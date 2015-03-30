package com.packpub.ws.security;

import java.security.acl.Group;

import javax.security.auth.login.LoginException;

import org.jboss.security.SimpleGroup;
import org.jboss.security.auth.spi.UsernamePasswordLoginModule;
import org.jboss.security.auth.spi.UsersRolesLoginModule;
import org.jboss.ws.tools.ant.SysProperty;

public class CustomLoginModule extends UsersRolesLoginModule {

	@Override
	protected String getUsersPassword() {
		String password = super.getUsersPassword();
		System.out.println("Password : " + password);
		return password;
	}

	@Override
	protected Group[] getRoleSets() throws LoginException {
		Group[] groups =  super.getRoleSets();
		System.out.println(groups);
		return groups;
	}

}
