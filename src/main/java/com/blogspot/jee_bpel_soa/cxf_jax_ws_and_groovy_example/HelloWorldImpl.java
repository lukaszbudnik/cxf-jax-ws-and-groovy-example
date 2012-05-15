package com.blogspot.jee_bpel_soa.cxf_jax_ws_and_groovy_example;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.servlet.ServletContext;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

@Stateless
@WebService(endpointInterface = "com.blogspot.jee_bpel_soa.cxf_jax_ws_and_groovy_example.HelloWorld")
public class HelloWorldImpl implements HelloWorld {
	
	@Resource
	private WebServiceContext webServiceContext;
	
	public String sayHi(String text) {
		return "Hello " + text;
	}

	public Greetings sayHiToPerson(Person person) {
		Greetings greetings = new Greetings();
		
		ServletContext ctx = (ServletContext) webServiceContext.getMessageContext().get(MessageContext.SERVLET_CONTEXT);
		
		String value = ctx.getInitParameter("param");
		
		greetings.setText("Hello " + value + " " + person.getFirstName());
		return greetings;
	}
}