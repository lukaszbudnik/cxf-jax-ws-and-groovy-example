package com.blogspot.jee_bpel_soa.cxf_jax_ws_and_groovy_example;

import groovyx.net.ws.WSClient

import org.apache.cxf.interceptor.LoggingInInterceptor
import org.apache.cxf.interceptor.LoggingOutInterceptor

class HelloWorldTestIT extends GroovyTestCase {

	def proxy;
	
	protected void setUp() throws Exception {
		proxy = new WSClient('http://localhost:8080/cxf-jax-ws-and-groovy-example/webservices/HelloWorldImpl?wsdl', this.class.classLoader)
		// magical method
		proxy.initialize()
		// Apache CXF logging interceptors
		proxy.client.getInInterceptors().add(new LoggingInInterceptor())
		proxy.client.getOutInterceptors().add(new LoggingOutInterceptor())
	}
	
	public void testSayHiToPerson() {
		def person = new Person()
		person.setFirstName("Lukasz")
		person.setLastName("Budnik")
		def greetings = proxy.sayHiToPerson(person);
		assertEquals("Hello value Lukasz", greetings.getText())
	}

}
