package com.ldevs.springjsf.service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.stereotype.Service;

import com.ldevs.springjsf.model.ServiceData;

@Service
@ManagedBean(name = "addNewService")
@SessionScoped
public class AddNewServiceFilesImpl implements AddNewServiceFiles {

    private final String PUBLICMODIFIER = "public";
    private final String CLASSKEWORD = "class";
    private final String WHITESPACE = " ";
    private final String REQUESTPACKAGE = "package sa.com.doit.cart.service.request;";
    private final String RESPONSEPACKAGE = "package sa.com.doit.cart.service.response;";
    private final String appxCartOpenFireServicePackage = "package sa.com.doit.cart.server.openfire.services;";
    private final String SERVICEREQUESTIMPORT = "import sa.com.doit.appx.data.wrappers.ServiceRequest;";
    private final String EXTENDS = "extends";
    private final String UTILMAP = "import java.util.Map;";
    private final String IMPLEMENTS = "implements";
    private final String SERVICERESPONSE = "ServiceResponse";
    private final String SERVICEREQUEST = "ServiceRequest";
    private final String SERVICERESPONSEIMPORT = "import sa.com.doit.appx.data.wrappers.ServiceResponse;";
    private final String serviceExpetion = "import sa.com.doit.appx.service.server.ServiceException;";
    private final String service = "import sa.com.doit.appx.service.server.Service;";
    private final String importRequestForm = "import sa.com.doit.cart.service.request.";
    private final String importResponseForm = "import sa.com.doit.cart.service.response.";
    private final String OPEN = "{";
    private final String CLOSE = "}";

    private ServiceData dataBean;


    public String generateServiceResponse(String className) {
        // insert imports for service response
        StringBuilder builder = new StringBuilder("");
        builder.append(RESPONSEPACKAGE + "\n");
        addTwoLine(builder);
        builder.append(UTILMAP + "\n");
        builder.append(SERVICERESPONSEIMPORT + "\n");
        addTwoLine(builder);
        // need to create java class specification
        builder.append(PUBLICMODIFIER).append(WHITESPACE).
                append(CLASSKEWORD).append(WHITESPACE).
                append(className).append(WHITESPACE).append(IMPLEMENTS).append(WHITESPACE).
                append(SERVICERESPONSE).append(WHITESPACE).append(OPEN + "\n");

        addTwentyLine(builder);
        builder.append(CLOSE);
        return builder.toString();
    }


    private String manipulatedWhiteSpace(String input) {
        String manipulatedWhiteSpace = input.replaceAll("\\s+", "");
        return manipulatedWhiteSpace;
    }

    public String manipulatedClassName(String className) {
        // first trim every white space
        String manipulatedWhiteSpace = manipulatedWhiteSpace(className);
        // convert first char to uppercase to java convention
        char first = Character.toUpperCase(manipulatedWhiteSpace.charAt(0));
        System.out.println("get the first char " + first);
        String manipulatedUpperCaseFirstChar = first + manipulatedWhiteSpace.substring(1);
        return manipulatedUpperCaseFirstChar;
    }

    public String generateServiceRequest(String className) {
        // insert imports for ModelRequest
        StringBuilder builder = new StringBuilder("");
        builder.append(REQUESTPACKAGE + "\n");
        addTwoLine(builder);
        builder.append(UTILMAP + "\n");
        builder.append(SERVICEREQUESTIMPORT + "\n");
        addTwoLine(builder);
        // need to create java class specification
        builder.append(PUBLICMODIFIER).append(WHITESPACE).
                append(CLASSKEWORD).append(WHITESPACE).
                append(className).append(WHITESPACE).append(IMPLEMENTS).append(WHITESPACE).append(SERVICEREQUEST).
                append(WHITESPACE).append(OPEN + "\n");

        addTwentyLine(builder);
        builder.append(CLOSE);
        return builder.toString();
    }

    private String generateAppxCartPluginService(String className) {
        // insert imports for ModelRequest
        StringBuilder builder = new StringBuilder("");
        builder.append(appxCartOpenFireServicePackage + "\n");
        addTwoLine(builder);
        builder.append(UTILMAP + "\n");
        builder.append(service + "\n");
        builder.append(serviceExpetion + "\n");
        builder.append(importRequestForm + this.dataBean.getRequestClassName()+";" + "\n");
        builder.append(importResponseForm + this.dataBean.getResponseClassName()+";" + "\n");

        addTwoLine(builder);
        // need to create java class specification
        builder.append(PUBLICMODIFIER).append(WHITESPACE).
                append(CLASSKEWORD).append(WHITESPACE).
                append(className).append(WHITESPACE).append(IMPLEMENTS).
                append(WHITESPACE).append("Service").
                append("<" + this.dataBean.getRequestClassName()).append(",").append(WHITESPACE).
                append(this.dataBean.getResponseClassName()).append(">").
                append(OPEN + "\n");

        addTwentyLine(builder);
        builder.append(CLOSE);
        return builder.toString();
    }

    private String generateVars(ArrayList<String> methods) {


        return "";
    }
    private String requestVars(String requestVars) {

        String e = "int id, String name, array OrderItem";




        return "";
    }

    @Override
    public void writeUsingFileWriter(ServiceData data) {
        this.dataBean = data;
        String appxCartServiceClass = manipulatedClassName(data.getAppxCartServiceClassName());
        File appxCartOpenFireServiceFile = new File(manipulatedWhiteSpace(data.getAppxCartServicePath()) + "\\" + appxCartServiceClass + ".java");

        String requestServiceClass = manipulatedClassName(data.getRequestClassName());
        File requestFile = new File(manipulatedWhiteSpace(data.getReqPath()) + "\\" + requestServiceClass + ".java");

        String resonseServiceClass = manipulatedClassName(data.getResponseClassName());
        File responseFile = new File(manipulatedWhiteSpace(data.getResPath()) + "\\" + resonseServiceClass + ".java");


        FileWriter writeOpenFireAppxCart = null;
        FileWriter writeRequest = null;
        FileWriter writeResponse = null;
        try {
            // write openfire appxCart service
            writeOpenFireAppxCart = new FileWriter(appxCartOpenFireServiceFile);
            writeOpenFireAppxCart.write(generateAppxCartPluginService(appxCartServiceClass));

            // write writeRequest
            writeRequest = new FileWriter(requestFile);
            writeRequest.write(generateServiceRequest(requestServiceClass));

            // write response
            writeResponse = new FileWriter(responseFile);
            writeResponse.write(generateServiceResponse(resonseServiceClass));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // close resources
            try {
                writeOpenFireAppxCart.close();
                writeRequest.close();
                writeResponse.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    private StringBuilder addFiveLine(StringBuilder builder) {
        for (int i = 0; i < 5; i++) {
            builder.append("\n");
        }
        return builder;
    }

    private StringBuilder addTwoLine(StringBuilder builder) {
        for (int i = 0; i < 2; i++) {
            builder.append("\n");
        }
        return builder;
    }

    private StringBuilder addOneLone(StringBuilder builder) {
        for (int i = 0; i < 1; i++) {
            builder.append("\n");
        }
        return builder;
    }

    private StringBuilder addTwentyLine(StringBuilder builder) {
        for (int i = 0; i < 20; i++) {
            builder.append("\n");
        }
        return builder;
    }

}
