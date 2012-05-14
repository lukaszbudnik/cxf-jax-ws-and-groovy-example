package com.blogspot.jee_bpel_soa.cxf_jax_ws_and_groovy_example;

import javax.ejb.Stateless;
import javax.jws.WebService;

@Stateless
@WebService(endpointInterface = "com.blogspot.jee_bpel_soa.cxf_jax_ws_and_groovy_example.HelloWorld")
public class HelloWorldImpl implements HelloWorld {
	public String sayHi(String text) {
		return "Hello " + text;
	}

	public Greetings sayHiToPerson(Person person) {
		Greetings greetings = new Greetings();
		greetings.setText("Hello " + person.getFirstName());
		return greetings;
	}
}