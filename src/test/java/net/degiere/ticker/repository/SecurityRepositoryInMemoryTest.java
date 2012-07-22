package net.degiere.ticker.repository;

import java.util.List;
import java.util.Set;

import junit.framework.Assert;
import net.degiere.ticker.Security;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class SecurityRepositoryInMemoryTest {
	
	final static Logger logger = LoggerFactory.getLogger(SecurityRepositoryInMemoryTest.class);

	static SecurityRepository repo = new SecurityRepositoryInMemory();
	
	@Test
	public void itFindsAll() {
		List<Security> securities = repo.findAll();
		Assert.assertNotNull(securities);
		Assert.assertTrue(securities.size() > 1000);
		Assert.assertTrue(securities.contains(new Security("SPY")));
	}

	@Test
	public void itFindsBySector() {
		List<Security> securities = repo.findBySector("Technology");
		Assert.assertNotNull(securities);
		Assert.assertTrue(securities.size() > 100);
		Assert.assertTrue(securities.contains(new Security("GOOG")));
		for (Security s : securities) {
			logger.debug("security: {}", s);
		}
	}

	@Test
	public void itFindsByIndusty() {
		List<Security> securities = repo.findByIndustry("Gold");
		Assert.assertNotNull(securities);
		for (Security s : securities) {
			logger.debug("security: {}", s);
		}
		Assert.assertTrue(securities.size() > 1);
		Assert.assertTrue(securities.contains(new Security("GOLD")));
	}

	@Test
	public void itFindsByCountry() {
		List<Security> securities = repo.findByCountry("USA");
		Assert.assertNotNull(securities);
		Assert.assertTrue(securities.size() > 1000);
		Assert.assertTrue(securities.contains(new Security("AAPL")));
		for (Security s : securities) {
			logger.debug("security: {}", s);
		}
	}

	@Test
	public void itFindsByTicker() {
		Security s = repo.findByTicker("SPY");
		Assert.assertNotNull(s);
		Assert.assertTrue(s.getTicker().equals("SPY"));
		Assert.assertEquals("SPDR S&P 500", s.getCompany());
		logger.debug("security: {}", s);
	}
	
	@Test
	public void itFindsAllSectors() {
		Set<String> sectors = repo.findAllSectors();
		Assert.assertNotNull(sectors);
		for (String s : sectors) {
			logger.debug(s);
		}
		Assert.assertTrue(sectors.contains("Technology"));
	}

	@Test
	public void itFindsAllndustries() {
		Set<String> industries = repo.findAllIndustries();
		Assert.assertNotNull(industries);
		for (String s : industries) {
			logger.debug(s);
		}
		Assert.assertTrue(industries.contains("Gold"));
	}

	@Test
	public void itFindsAllCountries() {
		Set<String> countries = repo.findAllCountries();
		Assert.assertNotNull(countries);
		for (String s : countries) {
			logger.debug(s);
		}
		Assert.assertTrue(countries.contains("USA"));
	}

}
