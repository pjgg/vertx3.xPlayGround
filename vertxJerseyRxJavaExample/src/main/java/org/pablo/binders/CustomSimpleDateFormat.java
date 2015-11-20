package org.pablo.binders;

import java.text.SimpleDateFormat;
import java.util.TimeZone;

public class CustomSimpleDateFormat extends SimpleDateFormat{
	
	private static final long serialVersionUID = 1L;
	private final static String FORMAT = "yyyy-MM-dd'T'HH\\:mm\\:ss'Z'";
	
	public CustomSimpleDateFormat(){
		super(FORMAT);
		this.setTimeZone(TimeZone.getTimeZone("GMT"));
	}

}
