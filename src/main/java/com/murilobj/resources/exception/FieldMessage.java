package com.murilobj.resources.exception;

import java.io.Serializable;

public class FieldMessage implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String fieldNameString;
	private String message;
	
	public FieldMessage(){
		
	}

	public FieldMessage(String fieldNameString, String message) {
		super();
		this.fieldNameString = fieldNameString;
		this.message = message;
	}

	public String getFieldNameString() {
		return fieldNameString;
	}

	public void setFieldNameString(String fieldNameString) {
		this.fieldNameString = fieldNameString;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
}
