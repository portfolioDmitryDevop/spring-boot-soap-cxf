package com.example.soap;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.test.autoconfigure.webservices.server.WebServiceServerTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.ws.test.server.MockWebServiceClient;
import org.springframework.ws.test.server.RequestCreator;
import org.springframework.ws.test.server.RequestCreators;
import org.springframework.ws.test.server.ResponseMatcher;
import org.springframework.ws.test.server.ResponseMatchers;
import org.springframework.xml.transform.StringSource;

import com.example.soap.service.HelloWorldWSImplService;

@WebServiceServerTest
@AutoConfiguration
class SpringBootSoapCxfIntroApplicationTests {
	
	@Autowired
    ApplicationContext applicationContext;
	
	@Autowired
    private MockWebServiceClient client;
	
	@Autowired
    ResourceLoader resourceLoader;

//	@MockBean
	//private ProductRepository productRepository;

	@Test
	void test() throws IOException {
        final RequestCreator requestCreator; // Creator for the request
        client = MockWebServiceClient.createClient(applicationContext);

        Resource requestPayLoad = resourceLoader.getResource("classpath:com/example/soap/requestPayload.xml");
        System.out.println(requestPayLoad.contentLength());
        requestCreator = RequestCreators.withSoapEnvelope(requestPayLoad);
        client.sendRequest(requestCreator);
        
	}

}
