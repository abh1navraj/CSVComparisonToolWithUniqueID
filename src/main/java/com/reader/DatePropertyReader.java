package com.reader;

import java.util.ArrayList;
import java.util.Set;

import com.base.Base;

public class DatePropertyReader extends Base {
	
	public ArrayList<String> readDateProperties(){
		
			
		ArrayList<String> dateProperties = new ArrayList<String>();
		
		Set<Object> propertyFileElements = prop.keySet();

		for (Object propertyFileElement : propertyFileElements) {
			if (propertyFileElement.toString().startsWith("dateProperty.")) {

				dateProperties.add(prop.getProperty(propertyFileElement.toString()));
				
			}
		}
		
		return dateProperties;
	}

}
