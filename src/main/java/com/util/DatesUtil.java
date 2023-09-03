package com.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

import com.base.Base;

public class DatesUtil extends Base {

	public String compareDateProperty(String sourceDateProperty, String sourceHeaderProperty, String tagetDateProperty,
			String targetHeaderProperty) {

		String result = null;
		DatesUtil datesUtil = new DatesUtil();
		String[] sourceDateCommonFormat = datesUtil.getCommonDateFormat(sourceDateProperty, sourceHeaderProperty);
		String[] targetDateCommonFormat = datesUtil.getCommonDateFormat(tagetDateProperty, targetHeaderProperty);

		
		
		
		
		if (sourceDateCommonFormat[0].equals(targetDateCommonFormat[0])) {
			if (sourceDateCommonFormat[1].equals("invalid") && targetDateCommonFormat[1].equals("invalid")) {
				result = "PassInvalidBoth";
			} else if (sourceDateCommonFormat[1].equals("invalid")) {
				result = "PassInvalidSource";
			} else if (targetDateCommonFormat[1].equals("invalid")) {
				result = "PassInvalidTarget";
			} else {
				result = "Pass";
			}
		} else {
			if (sourceDateCommonFormat[1].equals("invalid") && targetDateCommonFormat[1].equals("invalid")) {
				result = "FailInvalidBoth";
			} else if (sourceDateCommonFormat[1].equals("invalid")) {
				result = "FailInvalidSource";
			} else if (targetDateCommonFormat[1].equals("invalid")) {
				result = "FailInvalidTarget";
			} else {
				result = "Fail";
			}
		}

		return result;

	}

	public String[] getCommonDateFormat(String dateProperty, String headerProperty) {

		
		DatesUtil datesUtil = new DatesUtil();
		String[] commonFormat = new String[2];
		if (dateProperty.equals("")) {
			commonFormat[0] = dateProperty;
			commonFormat[1] = "valid";

			return commonFormat;

		} else {
			try {
				String commonPattern = "yyyy-MM-dd hh:mm:ss";

				String datePropertyPattern = prop.getProperty("dateFormat." + headerProperty);
				
				DateTimeFormatter dtf = new DateTimeFormatterBuilder().appendPattern(datePropertyPattern).parseCaseInsensitive().toFormatter();
//				DateTimeFormatter dtf = DateTimeFormatter.ofPattern(datePropertyPattern);
				LocalDateTime dt = LocalDateTime.parse(dateProperty, dtf);
				DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern(commonPattern);
				
				if(prop.getProperty("timeDifference." + headerProperty)!=null && prop.getProperty("timeDifference." + headerProperty).equals("true"))
				{
					LocalDateTime newDate  = datesUtil.getDatesAfterIgnoringTimeDifference(dt, headerProperty);
					commonFormat[0] = newDate.format(dtf1);
					
				}
				else {
				
				commonFormat[0] = dt.format(dtf1);
				}
				commonFormat[1] = "valid";
				
			
			} catch (Exception e) {
				

				try {
					String commonPattern = "yyyy-MM-dd hh:mm:ss";

					String datePropertyPattern = prop.getProperty("dateFormat." + headerProperty);
					
					DateTimeFormatter dtf = new DateTimeFormatterBuilder().appendPattern(datePropertyPattern).parseCaseInsensitive().toFormatter();
//					DateTimeFormatter dtf = DateTimeFormatter.ofPattern(datePropertyPattern);
					LocalDateTime dt = LocalDate.parse(dateProperty, dtf).atStartOfDay();
					DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern(commonPattern);
					if(prop.getProperty("timeDifference." + headerProperty).equals("true"))
					{
						LocalDateTime newDate  = datesUtil.getDatesAfterIgnoringTimeDifference(dt, headerProperty);
						commonFormat[0] = newDate.format(dtf1);
					}
					else {
					
					commonFormat[0] = dt.format(dtf1);
					}
					commonFormat[1] = "valid";
					
			
				
				}

				catch (Exception ex) {
					commonFormat[0] = dateProperty;
					commonFormat[1] = "invalid";
				}

			}
						return commonFormat;
		}
	}
	
	public LocalDateTime getDatesAfterIgnoringTimeDifference(LocalDateTime date, String headerProperty)
	{
		
		
		LocalDateTime newDate = null;
		int yearDifference =(prop.getProperty("timeDifference." + headerProperty + ".year")!=null) ? Integer.parseInt(prop.getProperty("timeDifference." + headerProperty + ".year")) : 0;
		int monthDifference = (prop.getProperty("timeDifference." + headerProperty + ".month")!=null) ? Integer.parseInt(prop.getProperty("timeDifference." + headerProperty + ".month")) : 0;
		int dayDifference = (prop.getProperty("timeDifference." + headerProperty + ".day")!=null) ? Integer.parseInt(prop.getProperty("timeDifference." + headerProperty + ".day")) : 0;
		
		int hourDifference = (prop.getProperty("timeDifference." + headerProperty + ".Hour")!=null) ? Integer.parseInt(prop.getProperty("timeDifference." + headerProperty + ".Hour")) : 0;
		int minuteDifference = (prop.getProperty("timeDifference." + headerProperty + ".minute")!=null) ? Integer.parseInt(prop.getProperty("timeDifference." + headerProperty + ".minute")) : 0;
		int secondDifference = (prop.getProperty("timeDifference." + headerProperty + ".second")!=null) ? Integer.parseInt(prop.getProperty("timeDifference." + headerProperty + ".second")) : 0;
		
		date = date.plusYears(yearDifference);
		date = date.plusMonths(monthDifference);
		date = date.plusDays(dayDifference);
		
		date = date.plusHours(hourDifference);
		
		date = date.plusMinutes(minuteDifference);
		
		date = date.plusSeconds(secondDifference);
		
		
		
		

		
		
		return date;
	}
			
}
