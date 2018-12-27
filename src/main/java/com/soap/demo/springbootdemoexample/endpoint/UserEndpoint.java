package com.soap.demo.springbootdemoexample.endpoint;

import com.github.marianavorotniak.spring_boot_soap_demo.GetUserRequest;
import com.github.marianavorotniak.spring_boot_soap_demo.GetUserResponse;
import com.github.marianavorotniak.spring_boot_soap_demo.User;
import com.soap.demo.springbootdemoexample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class UserEndpoint {

    @Autowired
    private UserService userService;

    @PayloadRoot(namespace = "http://github.com/MarianaVorotniak/spring-boot-soap-demo", localPart = "getUserRequest")
    @ResponsePayload
    public  GetUserResponse getUserRequest(@RequestPayload GetUserRequest request) {
        GetUserResponse response = new GetUserResponse();
        response.setUser(userService.getUsers(request.getName()));
        return response;
    }
}
