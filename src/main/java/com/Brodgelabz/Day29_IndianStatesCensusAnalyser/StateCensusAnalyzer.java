package com.Brodgelabz.Day29_IndianStatesCensusAnalyser;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

import com.Brodgelabz.Day29_IndianStatesCensusAnalyser.StateAnalyzerException.ExceptionType;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class StateCensusAnalyzer {

	
	public int readCSVData(String FilePath) throws StateAnalyzerException {
		int count = 0;

		
		try {
			try {
				Files.newBufferedReader(Paths.get(FilePath));
			} catch (IOException exception) {
				throw new StateAnalyzerException("Inavlid Path Name", ExceptionType.INVALID_FILE_PATH);
			}
			Reader reader = Files.newBufferedReader(Paths.get(FilePath));
			CsvToBean<CSVStateCensus> csvToBean = new CsvToBeanBuilder<CSVStateCensus>(reader)
					.withIgnoreLeadingWhiteSpace(true).withSkipLines(1).withType(CSVStateCensus.class).build();

			
			Iterator<CSVStateCensus> csvIterator = csvToBean.iterator();

			while (csvIterator.hasNext()) {
				count++;
				CSVStateCensus csvData = csvIterator.next();
				System.out.println(csvData);
			}
			return count;

		} catch (IOException exception) {
			exception.printStackTrace();
		}
		return 0;
	}

	public int readCSVData() {
		
		return 0;
	}
}