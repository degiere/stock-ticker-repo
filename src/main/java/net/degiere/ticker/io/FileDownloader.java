package net.degiere.ticker.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class FileDownloader {

	/**
	 * Fetch a URL and write it to a file
	 * 
	 * @throws IOException
	 */
	public void fetch(String url, File out) throws IOException {
		URL u = new URL(url);
		InputStream response = u.openStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(response));
		BufferedWriter writer = new BufferedWriter(new FileWriter(out));
		for (String line; (line = reader.readLine()) != null;) {
			writer.write(line);
			writer.newLine();
		}
		reader.close();
		writer.close();
	}
	
}
