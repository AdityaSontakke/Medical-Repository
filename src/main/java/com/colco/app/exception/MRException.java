package com.colco.app.exception;

public class MRException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3261697862242568970L;

	public MRException() {
		
	}
	
	public MRException (String msg) {
		super( msg);
	}
	
}
