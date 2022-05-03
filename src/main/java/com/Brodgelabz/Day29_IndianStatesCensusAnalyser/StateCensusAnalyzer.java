package com.Brodgelabz.Day29_IndianStatesCensusAnalyser;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class StateCensusAnalyzer {

	private final String CENSUS_CSV_PATH = "C:\Users\user\Desktop\CSV\IndiaStateCensusData.csv";

	public void readCSVData() throws IOException {

		/**
		 * taking try and Catch block to handle the catch exceptions
		 */
		try {
			Reader reader = Files.newBufferedReader(Paths.get(CENSUS_CSV_PATH));
			CsvToBean<CSVStateCensus> csvToBean = new CsvToBeanBuilder<CSVStateCensus>(reader)
					.withIgnoreLeadingWhiteSpace(true).withSkipLines(1).withType(CSVStateCensus.class).build();

			/**
			 * An Iterator is an object that can be used to loop through collections, like
			 * ArrayList and HashSet. It is called an "iterator" because "iterating" is the
			 * technical term for looping.
			 */
			Iterator<CSVStateCensus> csvIterator = csvToBean.iterator();

			/**
			 * To loop through a collection, use the hasNext() and next() methods of the
			 * Iterator
			 */
			while (csvIterator.hasNext()) {
				CSVStateCensus csvData = csvIterator.next();
				System.out.println(csvData);
			}

		} catch (IOException exception) {
			exception.printStackTrace();
		}

	}
}