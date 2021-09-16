package com.semanticsquare.thrillio.exceptions;

public class APIFormatChangeException extends Exception{
	
	private String response;
	private String elementName;
	private String partner;
	
	
	/*public APIFormatChangeException(String message){
		super(message);
	}*/


	public APIFormatChangeException(String response, String elementName, String partner, Throwable cause) {
		super("Response "+response+" elementName "+elementName+" partner "+partner,cause);
		this.response = response;
		this.elementName = elementName;
		this.partner = partner;
	}


	public String getResponse() {
		return response;
	}


	public String getElementName() {
		return elementName;
	}


	public String getPartner() {
		return partner;
	}
	
	
}
