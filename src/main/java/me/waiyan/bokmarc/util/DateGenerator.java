package me.waiyan.bokmarc.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.springframework.stereotype.Component;

@Component
public class DateGenerator {

	private static SimpleDateFormat formatter;
	
	public static Date getToday(){
		Calendar cal=Calendar.getInstance();
		
		return cal.getTime();
	}
	
	public static String formatToString(Date date){
		formatter=new SimpleDateFormat("dd/MM/yyyyy");
		
		return formatter.format(date);
	}
}
