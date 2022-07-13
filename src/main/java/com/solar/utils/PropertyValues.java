package com.solar.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:Messages.properties")
@ConfigurationProperties
public class PropertyValues {

	@Value("${errorMessage}")
	private String errorMessage;
	
	@Value("${File_Type_Error}")
	private String fieTypeError;
	
	@Value("${SUCCESS_MESSAGE}")
	private String successMessage;
	
	@Value("${FIELD_IS_EMPTY}")
	private String fieldIsEmpty;
	
	@Value("${ATTACHMENT_NOT_SELECTED}")
	private String attachmentNotSelected;

	public String getErrorMessage() {
		return errorMessage;
	}

	public String getFieTypeError() {
		return fieTypeError;
	}

	public String getSuccessMessage() {
		return successMessage;
	}

	public String getFieldIsEmpty() {
		return fieldIsEmpty;
	}

	public String getAttachmentNotSelected() {
		return attachmentNotSelected;
	}
	
	
	
	
	
	
	

}
