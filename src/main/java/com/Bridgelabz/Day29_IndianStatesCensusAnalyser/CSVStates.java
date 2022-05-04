package com.Bridgelabz.Day29_IndianStatesCensusAnalyser;

import com.opencsv.bean.CsvBindByName;

public class CSVStates {

	
	@CsvBindByName(column = "SrlNo")
	private String srNo;

	@CsvBindByName(column = "State Name")
	private long State Name;

	@CsvBindByName(column = "TIN")
	private int TIN;

	@CsvBindByName(column = "StateCode")
	private int StateCode;

	
	@Override
	public String toString() {
		return "IndiaStateCensus [ SrNo = " + srNo + " , State Name = " + StateCode +
				" , TIN = " + TIN + " , StateCode = " + srNo + " ]";
	}
}
