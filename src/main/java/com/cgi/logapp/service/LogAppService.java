package com.cgi.logapp.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

/**
 * The Class LogAppService.This is the service class for the Logs App.
 */
@Service
public class LogAppService {

	/**
	 * Gets the logs by type.
	 *
	 * @return the logs by type
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public Map<String, String> getLogsByType(String logLevel) throws IOException {
		
		// Getting a temporary list of all the logs.
		List<String> logList = Arrays.asList(getLogsAsString().split("\n"));
		List<String> sortedList = new ArrayList<>();
		Map<String, String> logMap = new TreeMap<>(Collections.reverseOrder());
		
		// Filtering the logs according to the user required log level.
		if (null != logLevel
				&& logLevel.matches("DEBUG|WARN|ERROR")) {
			sortedList = logList.stream().filter(log -> log.contains(logLevel)).collect(Collectors.toList());
			
			// Filtering the logs according to the description.
			sortedList.sort(new Comparator<String>() {
				int count = 0;
				String log = null;
				@Override
				public int compare(String r1, String r2) {
					if (r1.substring(r1.indexOf("]") + 2).compareTo(r2.substring(r2.indexOf("]") + 2)) == 0) {
						++count;
						log = r1;
					} else {
						logMap.put(Integer.valueOf(count).toString(), log);
						count = 0;
						log = null;
					}
					return r1.substring(r1.indexOf("]") + 2).compareTo(r2.substring(r2.indexOf("]") + 2));
				}
			});
			logMap.remove("0");
			
			// Map of Logs and count.
			return logMap;
		} else {
			return null;
		}
	}

	/**
	 * Gets the logs as string from the file.
	 *
	 * @return the logs as string from the file
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	private static String getLogsAsString() throws IOException {

		// Reading the log file from the classpath resource.
		File logsFile = new ClassPathResource("logFile-2018-09-10.log").getFile();
		InputStream stream = new FileInputStream(logsFile);

		// Converting the log file to a String.
		return IOUtils.toString(stream, StandardCharsets.UTF_8);
	}
}
