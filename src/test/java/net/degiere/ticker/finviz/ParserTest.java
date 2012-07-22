package net.degiere.ticker.finviz;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import junit.framework.Assert;
import net.degiere.ticker.Security;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParserTest {
	
	final static Logger logger = LoggerFactory.getLogger(ParserTest.class);

	@Test
	public void itParsesSecurities() throws IOException {
		File f = new File("src/test/resources/test-data.csv");
		int i = 0;
		Set<Security> securities = new Parser().parse(f);
		Security aapl = null;
		for (Security s : securities) {
			logger.debug(i++ + ": " + s);
			if (s.getTicker().equals("AAPL")) {
				aapl = s;
			}
		}
		Assert.assertEquals(4, securities.size());
		Assert.assertTrue(securities.contains(new Security("AAPL")));
		Assert.assertNotNull(aapl);
		Assert.assertEquals("Apple Inc.", aapl.getCompany());
		Assert.assertEquals("Technology", aapl.getSector());
	}
}
