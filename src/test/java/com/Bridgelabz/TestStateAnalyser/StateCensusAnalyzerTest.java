package com.Bridgelabz.TestStateAnalyser;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import com.Brodgelabz.Day29_IndianStatesCensusAnalyser.StateCensusAnalyzer;

public class StateCensusAnalyzerTest {

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
}
