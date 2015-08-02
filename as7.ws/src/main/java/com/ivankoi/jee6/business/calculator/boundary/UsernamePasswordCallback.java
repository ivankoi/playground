package com.ivankoi.jee6.business.calculator.boundary;

import java.io.IOException;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import org.apache.ws.security.WSPasswordCallback;

public class UsernamePasswordCallback implements CallbackHandler {
	public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
		WSPasswordCallback pc = (WSPasswordCallback) callbacks[0];
		if ("kermit".equals(pc.getIdentifier())) {
			pc.setPassword("thefrog");
		}
	}
}
