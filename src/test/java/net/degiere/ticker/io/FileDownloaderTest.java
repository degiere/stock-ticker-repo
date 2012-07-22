package net.degiere.ticker.io;

import java.io.File;
import java.io.IOException;

import junit.framework.Assert;
import net.degiere.ticker.finviz.Constants;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileDownloaderTest {
	
	final static Logger logger = LoggerFactory.getLogger(FileDownloaderTest.class);
	
	File f = new File("tmp");
	
	@Before
	public void before() {
		f.delete();
	}
	
	@After
	public void after() {
		f.delete();
	}
	
	@Test
	public void itDownloadsTheCsvFile() {
		logger.debug("fetching exported csv file...");
		try {
	        new FileDownloader().fetch(Constants.exportUrl, f);
        } catch (IOException e) {
	        e.printStackTrace();
        }
		Assert.assertTrue(f.isFile());
		Assert.assertTrue(f.length() > 0);
		logger.debug("downloaded.");
	}

}
