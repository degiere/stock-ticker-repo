package net.degiere.ticker;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import net.degiere.ticker.finviz.Constants;
import net.degiere.ticker.finviz.Parser;
import net.degiere.ticker.io.FileDownloader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
	
	final static Logger logger = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) {
		try {
			logger.info("fetching file...");
	        new FileDownloader().fetch(Constants.exportUrl, Constants.outputFile);
			logger.info("downloaded.");

			File f = Constants.outputFile;
			logger.info("parsing: " + f);
			Set<Security> securities = new Parser().parse(f);
			logger.info("parsed: {} securities", securities.size());
			int i = 0;
			for (Security s : securities) {
				logger.debug(i++ + ": " + s);
			}
        } catch (IOException e) {
	        e.printStackTrace();
        }
	}
	
}
