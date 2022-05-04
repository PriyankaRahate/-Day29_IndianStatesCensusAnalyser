package com.Bridgelabz.TestStateAnalyser;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import com.Bridgelabz.Day29_IndianStatesCensusAnalyser.StateAnalyzerException;
import com.Bridgelabz.Day29_IndianStatesCensusAnalyser.StateCensusAnalyzer;

public class StateCensusAnalyzerTest {

	private final String CENSUS_CSV_PATH = "C:\\Users\\RAMDAS\\Desktop.csv";
	private final String INAVLID_CENSUS_CSV_PATH = "IndiaStateCensusData.csv";
	private StateCensusAnalyzer analyser;

	
	@Before
	public void init() {
		analyser = new StateCensusAnalyzer();
	}

	@Test
	
	public void givenCensusCSVFile_ReturnsCorrectNoOfEntries() throws IOException {
		int stateCount = analyser.readCSVData();
		assertEquals(29, stateCount);
	}

	@Test
	
	public void givenIncorrectCSVFilePath_ThrowsCustomExceptionInvalidFilePath() {
		try {
			analyser.readCSVData(INAVLID_CENSUS_CSV_PATH);
		} catch (StateAnalyzerException e) {
			e.printStackTrace();
			assertEquals(StateAnalyzerException.ExceptionType.INVALID_FILE_PATH, e.type);
		}
	}
}
