package utilities.selenium;

import org.openqa.selenium.By;
import utilities.reporting.ExtentTestManager;

import java.lang.reflect.Field;

import static utilities.selenium.SeleniumDSL.*;

public class CheckPageElements {
	
	public static void checkDisplay(Class uimap, Object objectInstance, String annotationVal){
			
		Field[] fields = uimap.getDeclaredFields();
		
		for (int j=0; j<fields.length; j++){
			Field field = fields[j];
			uiMap annotation = (uiMap) field.getDeclaredAnnotation(uiMap.class);
			if (annotation instanceof uiMap){
				if (annotation.val().equalsIgnoreCase(annotationVal)){
					try{
						Object value = field.get(objectInstance);
						if(isVisible((By) value)){
							highlight((By) value);
							ExtentTestManager.logInfo("checking field - "+ field.getName());
							grabScreenshotForExtentReport(snipScreenshot((By) value));
						}
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					}
				}	
			}
		}
		grabScreenshotForExtentReport();
		
	}	
}
