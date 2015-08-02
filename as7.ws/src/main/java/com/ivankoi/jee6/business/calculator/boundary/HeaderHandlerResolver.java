package com.ivankoi.jee6.business.calculator.boundary;

import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.handler.Handler;
import javax.xml.ws.handler.HandlerResolver;
import javax.xml.ws.handler.PortInfo;


/**
 *
 * @author www.javadb.com
 */
public class HeaderHandlerResolver implements HandlerResolver {
    
	String login;
	String password;
	
	public HeaderHandlerResolver(String login, String password) {
		super();
		this.login = login;
		this.password = password;
	}
	
	@SuppressWarnings("all")
	public List<Handler> getHandlerChain(PortInfo portInfo) {
		List<Handler> handlerChain = new ArrayList<Handler>();
		
		HeaderHandler hh = new HeaderHandler(login,password);
		handlerChain.add(hh);
		
		return handlerChain;
	}
}
