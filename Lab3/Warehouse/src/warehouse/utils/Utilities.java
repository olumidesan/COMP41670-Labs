package warehouse.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

// Utility class to help with common tasks
public class Utilities {
	
	// Logs message to the console
	public static void logger(String logMessage) {
		System.out.println(logMessage);
	}
	
	// Returns the current day's date
	public static LocalDate getTodaysDate () {
		return LocalDate.now();
	}
	
	// Converts `String` date to `LocalDate`
	public static LocalDate parseDate(String date) {
		LocalDate parsedDate = null;
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		try {
			parsedDate = LocalDate.parse(date, dateFormat);
		} catch (DateTimeParseException e) {
			logger("[Date Error]: Invalid date. Date must follow DD/MM/YYYY pattern. e.g 22/12/2012.");
			throw new IllegalArgumentException();
		}

		return parsedDate;
	}

}
