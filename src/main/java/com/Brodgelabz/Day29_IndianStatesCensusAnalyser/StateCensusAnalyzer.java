package com.Brodgelabz.Day29_IndianStatesCensusAnalyser;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class StateCensusAnalyzer {

	private final String CENSUS_CSV_PATH = "C:\\Users\\RAMDAS\\Desktop.csv";

	
	public int readCSVData() throws IOException {
		int count = 0;

		
		try {
			Reader reader = Files.newBufferedReader(Paths.get(CENSUS_CSV_PATH));
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
}