package com.example.soap.config;

import javax.xml.ws.Endpoint;
import javax.xml.ws.Service;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import com.example.soap.service.HelloWorldWS;
import com.example.soap.service.HelloWorldWSImpl;
import com.example.soap.service.HelloWorldWSImplService;

@Configuration
@ComponentScan
@ImportResource({ "classpath:META-INF/cxf/cxf.xml" })
public class CxfWebServiceConfig {
    @Autowired
    private Bus cxfBus;
 
    @Bean
    public ServletRegistrationBean cxfServlet() {
        org.apache.cxf.transport.servlet.CXFServlet cxfServlet = new org.apache.cxf.transport.servlet.CXFServlet();
        ServletRegistrationBean servletDef = new ServletRegistrationBean<>(cxfServlet, "/ws/*");
        servletDef.setLoadOnStartup(1);
        return servletDef;
    }
 
    @Bean
    public Endpoint helloWorldWebService(HelloWorldWS helloWorldWS) {
        EndpointImpl endpoint = new EndpointImpl(cxfBus, helloWorldWS);
        endpoint.setAddress("/helloWorldWS");
        endpoint.publish();
        return endpoint;
    }
    
    @Bean
    public Service getService() {
    	return new HelloWorldWSImplService();
    }
}
