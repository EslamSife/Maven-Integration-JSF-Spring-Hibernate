package com.ldevs.springjsf.model;
import javax.faces.bean.ManagedBean;


@ManagedBean
public class ServiceData {

	private String appxCartServicePath;
	
	private String appxCartServiceClassName;


	private String requestClassName;

	private String reqPath;


	private String requestVars;

	private String resPath;

	private String responseClassName;

	private String responseVars;
	
	private String methodName;
	
	private String param;
	
	private String classContent;
	
	public String getAppxCartServicePath() {
		return appxCartServicePath;
	}


	public void setAppxCartServicePath(String appxCartServicePath) {
		this.appxCartServicePath = appxCartServicePath;
	}

	public String getAppxCartServiceClassName() {
		return appxCartServiceClassName;
	}

	public void setAppxCartServiceClassName(String appxCartServiceClassName) {
		this.appxCartServiceClassName = appxCartServiceClassName;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public String getParam() {
		return param;
	}

	public void setParam(String param) {
		this.param = param;
	}

	
	public String getClassContent() {
		return classContent;
	}
	
	public void setClassContent(String classContent) {
		this.classContent = classContent;
	}


	public String getRequestClassName() {
		return requestClassName;
	}

	public void setRequestClassName(String requestClassName) {
		this.requestClassName = requestClassName;
	}

	public String getResponseClassName() {
		return responseClassName;
	}

	public void setResponseClassName(String responseClassName) {
		this.responseClassName = responseClassName;
	}


	public String getReqPath() {
		return reqPath;
	}

	public void setReqPath(String reqPath) {
		this.reqPath = reqPath;
	}

	public String getResPath() {
		return resPath;
	}

	public void setResPath(String resPath) {
		this.resPath = resPath;
	}

	public String getRequestVars() {
		return requestVars;
	}

	public void setRequestVars(String requestVars) {
		this.requestVars = requestVars;
	}

	public String getResponseVars() {
		return responseVars;
	}

	public void setResponseVars(String responseVars) {
		this.responseVars = responseVars;
	}
}
