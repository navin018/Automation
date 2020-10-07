package Practice;
import utilities.selenium.Excel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;

import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import net.lightbody.bmp.core.har.HarEntry;
import net.lightbody.bmp.proxy.CaptureType;
public class practice {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws ParseException {
//		SimpleDateFormat format1 = new SimpleDateFormat("mm/dd/yyyy");
//		String d = "5/20/2020";
//		SimpleDateFormat format = new SimpleDateFormat("DD/MMM/yy");
//		Date date = format.parse("08/16/2021");
//		System.out.println(format.format(date));
		
//		SimpleDateFormat dFormat = new SimpleDateFormat("M/d/yyyy");
//		SimpleDateFormat dFormatRequired = new SimpleDateFormat("MM-dd-YYYY");
//		 Date date = dFormat.parse(d);
//		 String ddate = dFormatRequired.format(date);
//		 System.out.println(ddate);
//		 
//		 String a = "mam";
//		 String b = "mam";
//		 if(a==b)
//		 {
//			 System.out.println("hel");
//		 }
//		 
//		 String test = "Hell:There";
//		 String test1 = test.replace("Hell", "There");
//		 System.out.println(test1);
//		 
//		ArrayList<String> ADTJiraEntities = new ArrayList<>(Arrays.asList("Epic", "Feature", "UserStory", "Task", "Bug" , "Impediment", "Issue", "Risk"));
////		ArrayList<String> UI = new ArrayList<>(Arrays.asList("Epic", "Feature", "UserStory", "Task", "Bug" , "Impediment", "Issue"));
//		ArrayList<String> UI = new ArrayList<>();
//		ADTJiraEntities.removeAll(UI);
//		System.out.println(ADTJiraEntities);
//		System.out.println(ADTJiraEntities.size());
		
		
//		Excel.setExcelLocAndSheet("C:\\Users\\sonal.harish.nagda\\Documents\\DefaultIntegartionPerametersValue_ADOP_ADT_TFSAgile.xlsx", "ADT Inbound");
//		System.out.println(utilities.selenium.Excel.getCellData(1, 1));
		
//		HashMap<String, String> hmap = new HashMap<>();
//		hmap.put("a", "apple");
//		hmap.put("b", "ball");
//		System.out.println(hmap.containsKey("a"));
//		System.out.println(hmap.get("a"));
//		ChromeOptions capability = new ChromeOptions();
		
		
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\sonal.harish.nagda\\Documents\\almPT_old\\src\\test\\resources\\drivers\\chromedriver.exe");
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			capabilities.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS,true);
			
			
			BrowserMobProxy proxy = getProxyServer(); //getting browsermob proxy
			proxy.setHarCaptureTypes(CaptureType.getAllContentCaptureTypes());
			Proxy seleniumProxy = getSeleniumProxy(proxy);
			
			capabilities.setCapability(CapabilityType.PROXY, seleniumProxy);
			WebDriver driver = new ChromeDriver(capabilities);
			proxy.newHar(); // creating new HAR
			driver.get("https://stackoverflow.com/");
			List<HarEntry> entries = proxy.getHar().getLog().getEntries();
			for (HarEntry entry : entries) {
			System.out.println(entry.getRequest().getUrl());
			
//			proxy.stop();
//			driver.close();
		}
			}
	public static Proxy getSeleniumProxy(BrowserMobProxy proxyServer) {
		Proxy seleniumProxy = ClientUtil.createSeleniumProxy(proxyServer);
		try {
		String hostIp = Inet4Address.getLocalHost().getHostAddress();
		seleniumProxy.setHttpProxy(hostIp + ":" + proxyServer.getPort());
		seleniumProxy.setSslProxy(hostIp + ":" + proxyServer.getPort());
		} catch (UnknownHostException e) {
		e.printStackTrace();
		Assert.fail("invalid Host Address");
		}
		return seleniumProxy;
		}
		public static BrowserMobProxy getProxyServer() {
		BrowserMobProxy proxy = new BrowserMobProxyServer();
		proxy.setTrustAllServers(true);
		proxy.start();
		return proxy;
		}
}
