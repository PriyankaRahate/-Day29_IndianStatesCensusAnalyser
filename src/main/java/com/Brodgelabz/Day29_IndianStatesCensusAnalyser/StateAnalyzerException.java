package com.Brodgelabz.Day29_IndianStatesCensusAnalyser;

public class StateAnalyzerException extends Exception {

	private static final long serialVersionUID = 3369988279518561290L;

	
	public enum ExceptionType {
		INVALID_FILE_PATH
	}

	public ExceptionType type;


	public StateAnalyzerException(String message, ExceptionType type) {
		super(message);
		this.type = type;
	}
}