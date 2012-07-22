package net.degiere.ticker.finviz;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import net.degiere.ticker.Security;

import au.com.bytecode.opencsv.CSVReader;

public class Parser {
	
	/**
	 * Parse a FinViz exported CSV file into a set of securities 
	 * 
	 * @param f CSV file with data
	 * @return set of Security objects
	 * @throws IOException
	 */
	public Set<Security> parse(File f) throws IOException {
		Set<Security> securities = new HashSet<Security>();
		CSVReader reader = new CSVReader(new FileReader(f));
	    String [] line;
	    while ((line = reader.readNext()) != null) {
	    	// skip labels
	    	if (line[1].equals("Ticker")) {
	    		continue;
	    	}
	    	Security s = new Security(line[1]);
	    	s.setTicker(line[1]);
	    	s.setCompany(line[2]);
	    	s.setSector(line[3]);
	    	s.setIndustry(line[4]);
	    	s.setCountry(line[5]);
	    	s.setMarketCap(line[6]);
	    	s.setPe(line[7]);
	    	s.setPrice(line[8]);
	    	s.setChange(line[9]);
	    	s.setVolume(line[10]);
	    	securities.add(s);
	    }
	    reader.close();
	    return securities;
	}

}
