package utilities.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;

import static utilities.selenium.SeleniumDSL.assertEquals;
import static utilities.selenium.SeleniumDSL.find;


/** 
 * Validates a given page properties based on supplied UIMap class and group.
 * Within the UIMap class any page elements to be checked should be annotated
 * based on the UIAnnot interface.
 * 
 * Each element may have multiple annotation groups (up to 5) and each annotation group
 * contains an array list of properties to be checked.
 * 
 * Currently the checks performed are visibility, enablement, and any given attribute value
 */
public class WireFrame {
	
	
	public static void checkPageProperties(String uiMapPath, String group) throws Throwable {	
		Class<?> c = Class.forName(uiMapPath);
		Object obj =  c.newInstance();
		Field[] fields = c.getFields();
		for (Field f : fields){
			
			String name = f.getName().toString();
			By by = (By) f.get(obj);
			if(by==null){
				by=(By)new PropertyDescriptor(name,c).getReadMethod().invoke(obj);
			}
			
			UIAnnot annot = f.getAnnotation(UIAnnot.class);

			String[] annotlist = null;

			if (annot != null){
				switch (annot.fieldMode()){
					case "View": annotlist = annot.View();break;
					case "Edit": annotlist = annot.Edit();break;	
					case "Dynamic": 					
									switch (group){
										case "View": annotlist = annot.DynamicInView();break;
										case "Edit": annotlist = annot.DynamicInEdit();break;					
									}
					default: 		switch (group){
										case "View": annotlist = annot.View();break;
										case "Edit": annotlist = annot.Edit();break;					
									}
				}	
				if (annotlist.length>0){
					WebElement el = find(by);
					if(el.isDisplayed()){
					
						for (String s : annotlist){
							String property = s.split("=")[0];
							String state = s.split("=")[1];
							if(property.equals("enabled") && !(name.contains("Input")) )
								;
							else
								checkState(el, property, state);
					
						}
					}
			
				}
			}

		}
	}
		
	

	public static void checkState(WebElement el, String property, String state){		
		switch(property){
		case "visible":
			assertEquals(Boolean.parseBoolean(state),el.isDisplayed(),true);break;
		case "enabled":
			assertEquals(Boolean.parseBoolean(state),el.isEnabled(),true);	break;
		default:
			assertEquals(state,el.getAttribute(property),true);break;
		}
		
	}
	
//	public static void checkDisplay(Class uimap, Object objectInstance, String annotationVal){
//	
//Field[] fields = uimap.getDeclaredFields();
//
//for (int j=0; j<fields.length; j++){
//	Field field = fields[j];
//	uiMap annotation = (uiMap) field.getDeclaredAnnotation(uiMap.class);
//	if (annotation instanceof uiMap){	
//		if (annotation.val().equalsIgnoreCase(annotationVal)){
//			try{
//				Object value = field.get(objectInstance);
//				if(isVisible((By) value)){
//					highlight((By) value);
//					ExtentTestManager.logInfo("checking field - "+ field.getName());
//					grabScreenshotForExtentReport(snipScreenshot((By) value));
//				}
//			} catch (IllegalArgumentException e) {
//				e.printStackTrace();
//			} catch (IllegalAccessException e) {
//				e.printStackTrace();
//			}
//		}	
//	}
//}
//grabScreenshotForExtentReport();
//
//}	
}
