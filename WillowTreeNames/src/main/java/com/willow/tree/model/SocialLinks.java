package com.willow.tree.model;

public class SocialLinks {
//{"type":"linkedin",
	//"callToAction":"Follow Christy Phillips on LinkedIn",
	//"url":"https://www.linkedin.com/in/christyphillips1/"}
	
	private String type;
	private String callToAction;
	private String url;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCallToAction() {
		return callToAction;
	}
	public void setCallToAction(String callToAction) {
		this.callToAction = callToAction;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
}
