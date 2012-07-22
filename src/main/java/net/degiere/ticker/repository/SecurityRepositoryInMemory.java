package net.degiere.ticker.repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.degiere.ticker.Security;
import net.degiere.ticker.finviz.Constants;
import net.degiere.ticker.finviz.Parser;

public class SecurityRepositoryInMemory implements SecurityRepository {
	
	private static List<Security> securities;
	private static Map<String, Integer> indexByTicker;
	private static Map<String, Set<Integer>> indexBySector;
	private static Map<String, Set<Integer>> indexByIndustry;
	private static Map<String, Set<Integer>> indexByCountry;
	
	public SecurityRepositoryInMemory() {
		load();
		mapTickers();
		mapSectors();
		mapIndustries();
		mapCountries();
	}
	
	public List<Security> findAll() {
		return securities;
	}
	
	public List<Security> findBySector(String sector) {
		List<Security> results = new ArrayList<Security>();
		Set<Integer> indexes = indexBySector.get(sector);
		if (indexes == null) return null;
		for (Integer i : indexes) {
			results.add(securities.get(i));
		}
		return results;
	}
	
	public List<Security> findByIndustry(String industry) {
		List<Security> results = new ArrayList<Security>();
		Set<Integer> indexes = indexByIndustry.get(industry);
		if (indexes == null) return null;
		for (Integer i : indexes) {
			results.add(securities.get(i));
		}
		return results;
	}

	public List<Security> findByCountry(String country) {
		List<Security> results = new ArrayList<Security>();
		Set<Integer> indexes = indexByCountry.get(country);
		if (indexes == null) return null;
		for (Integer i : indexes) {
			results.add(securities.get(i));
		}
		return results;
	}

	public Security findByTicker(String ticker) {
		return securities.get(indexByTicker.get(ticker));
	}
	
	public Set<String> findAllSectors() {
		return indexBySector.keySet();
	}
	
	public Set<String> findAllIndustries() {
		return indexByIndustry.keySet();
	}

	public Set<String> findAllCountries() {
		return indexByCountry.keySet();
	}

	private void load() {
		if (securities != null) return;
		File f = Constants.outputFile;
		try {
			securities = new ArrayList<Security>();
			securities.addAll(new Parser().parse(f));
        } catch (IOException e) {
	        e.printStackTrace();
        }
	}
	
	private void mapTickers() {
		indexByTicker = new HashMap<String, Integer>();
		for (Security s : securities) {
			indexByTicker.put(s.getTicker(), securities.indexOf(s));
		}
	}	

	private void mapSectors() {
		indexBySector = new HashMap<String, Set<Integer>>();
		for (Security s : securities) {
			Set<Integer> i = indexBySector.get(s.getSector());
			if (i == null) i = new HashSet<Integer>();
			i.add(securities.indexOf(s));
			indexBySector.put(s.getSector(), i);
		}
	}	
	
	private void mapIndustries() {
		indexByIndustry = new HashMap<String, Set<Integer>>();
		for (Security s : securities) {
			Set<Integer> i = indexByIndustry.get(s.getIndustry());
			if (i == null) i = new HashSet<Integer>();
			i.add(securities.indexOf(s));
			indexByIndustry.put(s.getIndustry(), i);
		}
	}	

	private void mapCountries() {
		indexByCountry = new HashMap<String, Set<Integer>>();
		for (Security s : securities) {
			Set<Integer> i = indexByCountry.get(s.getCountry());
			if (i == null) i = new HashSet<Integer>();
			i.add(securities.indexOf(s));
			indexByCountry.put(s.getCountry(), i);
		}
	}	

}
