package com.packpub.ws.security;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;

import org.jboss.crypto.digest.DigestCallback;
import org.jboss.security.Base64Encoder;
import org.jboss.security.auth.callback.MapCallback;
import org.jboss.ws.WSException;
import org.jboss.ws.extensions.security.auth.callback.UsernameTokenCallbackHandler;
import org.jboss.util.Base64;

public class UsernameTokenCallback implements DigestCallback {
	public static final String NONCE = "nonce";
	   public static final String CREATED = "created";
	   
	   private MapCallback info;

	   @SuppressWarnings("unchecked")
	   public void init(Map options)
	   {
	      // Ask for MapCallback to obtain the digest parameters
	      info = new MapCallback();
	      Callback[] callbacks = { info };
	      options.put("callbacks", callbacks);
	   }

	   public void preDigest(MessageDigest digest)
	   {
	      try
	      {
	         String nonce = (String)info.getInfo(NONCE);
	         if (nonce != null)
//	            digest.update(nonce.getBytes("UTF-8"));
	         	digest.update(Base64.decode(nonce)); // TODO add Base64 encoding type attribute
	         String created = (String)info.getInfo(CREATED);
	         if (created != null)
	            digest.update(created.getBytes("UTF-8"));
	      }
	      catch (UnsupportedEncodingException e)
	      {
	         throw new WSException(e);
	      }
	   }

	   public void postDigest(MessageDigest digest)
	   {
	   }
	  
	   @SuppressWarnings("unchecked")
	   public static void main(String[] args) throws Exception
	   {
//	      if (args.length != 3)
//	      {
//	         System.err.println("Usage: UsernameTokenCallback nonce created password");
//	         System.err.println(" - nonce : the nonce");
//	         System.err.println(" - created : the creation timestamp");
//	         System.err.println(" - password : the plain text password");
//	         System.exit(1);
//	      }
	      String nonce = "iGYGXYTo9ItIdb+5Zx4Wpw==";
//	      String created = "2015-03-30T20:19:13.640Z";
	      String created = null;
	      String password = "password";
	      
	      MessageDigest digest = MessageDigest.getInstance("SHA");
	      UsernameTokenCallback utc = new UsernameTokenCallback();
	      Map options = new HashMap();
	      utc.init(options);
	      CallbackHandler cbh = new UsernameTokenCallbackHandler(nonce, created);
	      cbh.handle((Callback[])options.get("callbacks"));
	      utc.preDigest(digest);
	      byte[] result = digest.digest(password.getBytes("UTF-8"));
	      System.out.println("UsernameToken password digest: " + Base64Encoder.encode(result));
	   }

}
