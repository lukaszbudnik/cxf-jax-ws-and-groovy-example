package com.blogspot.jee_bpel_soa.cxf_jax_ws_and_groovy_example;

import javax.jws.WebService;

@WebService
public interface HelloWorld {
	String sayHi(String text);

	Greetings sayHiToPerson(Person person);
}