package com.Bridgelabz.TestStateAnalyser;

import static org.junit.Assert.assertEquals;

import java.rmi.ServerException;

import org.junit.Before;
import org.junit.Test;

import com.Bridgelabz.Day29_IndianStatesCensusAnalyser.StateAnalyzerException;
import com.Bridgelabz.Day29_IndianStatesCensusAnalyser.StateCensusAnalyzer;

import moodAnalyserDay21.MoodAnalyser;

public class StateCensusAnalyzerTest {

	private final String CENSUS_CSV_PATH = "C:\\Users\\RAMDAS\\Desktop\'CSV\'IndiaStateCensusData.csv";
	private final String INVALID_CENSUS_CSV_PATH = "IndiaStateCensusData.csv";
	private final String INVALID_CENSUS_CSV_DELIM = "C:\\Users\\RAMDAS\\Desktop\'CSV\'IndiaStateCensusDataDelim.csv";
	private final String INVALID_CENSUS_CSV_HEAD = "C:\\Users\\RAMDAS\\Desktop\'CSV\'IndiaStateCensusDataHead.csv";
	
	
	private final String STATECODE_CSV_PATH="C:\\Users\\RAMDAS\\Desktop\'CSV\'IndianStateCode.csv";
	private final String INVALID_STATECODE_CSV_PATH="IndiaStateCode.csv";
	private StateCensusAnalyzer analyser;

	
	@Before
	public void init() {
		analyser = new StateCensusAnalyzer();
	}

	
		public void givenCensusCSVFileReturnsCorrectNoOfEntries() throws StateAnalyzerException {
			int stateCount = analyser.readStateCensusCSVData(CENSUS_CSV_PATH);
			assertEquals(28, stateCount);
		}

	@Test
	
	public void givenIncorrectCSVFilePath_ThrowsCustomExceptionInvalidFilePath(){
		try {
			analyser.readStateCensusCSVData(INVALID_CENSUS_CSV_PATH);
		} catch (StateAnalyzerException e) {
			e.printStackTrace();
			assertEquals(StateAnalyzerException.ExceptionType.INVALID_FILE_PATH, e.type);
		}
	}

	@Test
	
	public void givenIncorrectDelimiter_ThrowsCustomExceptionInvalidDelimiter(){
		try {
			analyser.readStateCensusCSVData(INVALID_CENSUS_CSV_DELIM);
		} catch (StateAnalyzerException e) {
			e.printStackTrace();
			assertEquals(StateAnalyzerException.ExceptionType.INVALID_DELIM, e.type);
		}
	}

	@Test
	
	public void givenIncorrectHeader_ThrowsCustomExceptionInvalidHeader(){
		try {
			MoodAnalyser.readStateCensusCSVData(INVALID_CENSUS_CSV_HEAD);
		} catch (com.Bridgelabz.Day29_IndianStatesCensusAnalyser.StateAnalyzerException e) {
			e.printStackTrace();
			assertEquals(ServerException.ExceptionType.INVALID_HEAD, e.type);
		}
	}
	
	
		public void givenCodeCSVFileReturnsCorrectNoOfEntries() throws StateAnalyzerException{
			int stateCount = analyser.readStateCodeCSVData(STATECODE_CSV_PATH);
			assertEquals(36, stateCount);
		}
		
		@Test
	
		public void givenIncorrectCSVFilePath_ThrowsCustomExceptionInvalidFilePath2(){
			try {
				analyser.readStateCodeCSVData(INVALID_STATECODE_CSV_PATH);
			} catch (StateAnalyzerException e) {
				e.printStackTrace();
				assertEquals(StateAnalyzerException.ExceptionType.INVALID_FILE_PATH, e.type);
			}
		}
}
