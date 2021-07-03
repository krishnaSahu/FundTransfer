package com.at.fundTransfer.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

	private static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

	public static String getDateString(Date date) {
		String format = formatter.format(date);
		return format;
	}

	public static Date getDate(String dateStr) {
		Date date = null;
		try {
			date = formatter.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
}
