package me.waiyan.bokmarc.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.springframework.stereotype.Component;

@Component
public class DateGenerator {

	private static SimpleDateFormat formatter;
	
	private static Date getToday(){
		Calendar cal=Calendar.getInstance();
		
		return cal.getTime();
	}
	
	//get the date in format 01/02/2014
	public static String getCalendarDate(){
		formatter=new SimpleDateFormat("dd/MM/yyyyy");
		
		return formatter.format(getToday());
	}
	
	//get the date in format February 25, 2014.
	public static String getFormalDate(){
		formatter=new SimpleDateFormat("MMM d, yyyy");
		
		return formatter.format(getToday());
	}
}
