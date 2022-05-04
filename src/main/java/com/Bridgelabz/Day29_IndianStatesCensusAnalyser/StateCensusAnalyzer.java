package com.Bridgelabz.Day29_IndianStatesCensusAnalyser;
/**
 * UC1:-   Ability for the analyser to load the Indian States Census Information from a csv file 
 * TC1.1:- Given the States Census CSV file, Check to ensure the Number of Record matches
 * TC1.2:- Given the State Census CSV File if incorrect Returns a custom Exception
 * TC1.3:- Given the State Census CSV File when correct but type incorrect Returns a custom Exception
 * TC1.4:_ Given the State Census CSV File when correct but delimiter incorrect Returns a custom Exception
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.stream.StreamSupport;

import com.Bridgelabz.Day29_IndianStatesCensusAnalyser.StateAnalyzerException.ExceptionType;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class StateCensusAnalyzer {

	public int readCSVData(String FilePath) throws StateAnalyzerException {

		
		try {
			Files.newBufferedReader(Paths.get(FilePath));
			Reader reader = Files.newBufferedReader(Paths.get(FilePath));
			CsvToBean<CSVStateCensus> csvToBean = new CsvToBeanBuilder<CSVStateCensus>(reader)
					.withIgnoreLeadingWhiteSpace(true).withSkipLines(1).withType(CSVStateCensus.class).build();

			
			final Iterator<CSVStateCensus> csvIterator = csvToBean.iterator();

			Iterable<CSVStateCensus> csvItrable = () -> csvIterator;
			int count = (int) StreamSupport.stream(csvItrable.spliterator(), false).count();

			
			BufferedReader br = new BufferedReader(reader);
			boolean flagCorrectDelim = true;

			
			while (br.readLine() != null) {
				if (!br.readLine().contains(",")) {
					flagCorrectDelim = false;
				}
			}
			if (!flagCorrectDelim) {
				throw new StateAnalyzerException("Invalid Delimitor", ExceptionType.INVALID_DELIM);
			}

			return count;

		} catch (IOException exception) {
			throw new StateAnalyzerException("Inavlid Path Name", ExceptionType.INVALID_FILE_PATH);
		} catch (IllegalStateException exception) {
			throw new StateAnalyzerException("Invalid Class Type.", ExceptionType.INVALID_CLASS_TYPE);
		}
	}

	public int readCSVData() {
		
		return 0;
	}
}