package testobjects;

import static utilities.reporting.Reporting.create_logs_and_report;

import static utilities.selenium.SeleniumDSL.*;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;

import utilities.general.Property;

public class CommonFunctions {
	
	public static String SpiltWorkitem(String fullworkitemID)
	{
		
			if(fullworkitemID!=null)
			{
			String fullworkitem_sp [] = fullworkitemID.split(" ");
			System.out.println(fullworkitem_sp.length);
			int s = fullworkitem_sp.length;
			return fullworkitem_sp[fullworkitem_sp.length-1];
			}
		else
			return null;
}

	
	
	
	
		
	}
