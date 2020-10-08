package utilities.selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import static utilities.selenium.SeleniumDSL.sendEsc;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.seleniumhq.jetty9.io.ssl.ALPNProcessor.Server;

import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.*;
import net.lightbody.bmp.client.ClientUtil;
import utilities.general.Property;

/** 
 * Threadlocal instance of WebDriver supporting remote execution via
 * Saucelabs or a Selenium Grid, or local execution.
 * 
 * The use of either saucelabs/grid/local is set in the Context instance for
 * the execution thread (via the TestNG DataProvider). For saucelabs or grid then the address
 * of the target host and any credentials are specified in the project properties file.
 * 
 * For local execution the broswers currently supported are Firefox, Chrome, IE, HTML Unit, and 
 * Phantom JS but this can be extended as needed. The locations of the required drivers/binaries 
 * are specified in the project properties file.
 */
public class DriverFactory {
	
//	public static BrowserMobProxy proxy;
	public static BrowserMobProxyServer proxy;
	private DriverFactory() {
    }
	
	private static DriverFactory instance = new DriverFactory();

    public static DriverFactory getInstance() {
	  return instance;
	}
    
	
	ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>() {
		protected WebDriver initialValue() {	
			return null;	
		}	
	};
	
    public WebDriver getDriver(){
		return getInstance().driver.get();
	}
    
    public void quit() {
		driver.get().quit();
		driver.remove();
    }
    
    public Proxy getSeleniumProxy(BrowserMobProxy proxyServer) {
    	Proxy seleniumProxy = ClientUtil.createSeleniumProxy(proxyServer);
    	try {
    	String hostIp = Inet4Address.getLocalHost().getHostAddress();
//    	seleniumProxy.setHttpProxy(hostIp + ":" + proxyServer.getPort());
//    	seleniumProxy.setSslProxy(hostIp + ":" + proxyServer.getPort());
    	seleniumProxy.setHttpProxy(hostIp + ":" + proxyServer.getPort());
    	seleniumProxy.setSslProxy(hostIp + ":" + proxyServer.getPort());
    	} catch (UnknownHostException e) {
    	e.printStackTrace();
    	System.out.println("invalid Host Address");
    	}
    	return seleniumProxy;
    	}
    
    public BrowserMobProxyServer getProxyServer() {
    	proxy = new BrowserMobProxyServer();
    	proxy.setTrustAllServers(true);
    	proxy.start();
    	return proxy;
    	}
//    
    public void setWebDriver(String checkperformance) throws NumberFormatException, IOException {
    	DesiredCapabilities cap = new DesiredCapabilities();
    	if("1".equals(Property.getProperty("isZapEnabled"))){
	    	Proxy proxy=new Proxy();
	    	proxy.setHttpProxy("localhost:8090");
	    	proxy.setFtpProxy("localhost:8090");
	    	proxy.setSslProxy("localhost:8090");
	    	cap.setCapability(CapabilityType.PROXY, proxy);
    	}
    	cap.setCapability(CapabilityType.BROWSER_NAME, Context.getInstance().getBrowserName());
    	cap.setCapability(CapabilityType.VERSION, Context.getInstance().getBrowserVersion());
    	cap.setCapability(CapabilityType.PLATFORM, Context.getInstance().getPlatform());
    	
    	//five lines related to browsermob
    	if(Property.getProperty("CheckPerformance").equalsIgnoreCase("true"))
    	{
    		 proxy = getProxyServer(); 
    	    	Proxy seleniumProxy = ClientUtil.createSeleniumProxy(proxy);
    	    	cap.setCapability(CapabilityType.PROXY, seleniumProxy);
    	    	cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
    	    	cap.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS,true);
    	}
    	
////    	
//    	cap.setCapability("name", Context.getInstance().getScenario()+" ("+Context.getInstance().getBrowserName()+")");
//    	cap.setCapability("build", System.getenv("JOB_NAME") + "__" + System.getenv("BUILD_NUMBER"));
   	
    	
    	if (!Context.getInstance().getSeleniumServer().equalsIgnoreCase("local")){
    		System.out.println("Server address:"+Context.getInstance().getServerAddress());
    		System.out.println(cap.toString());
    		driver.set(new RemoteWebDriver(new URL(Context.getInstance().getServerAddress()), cap));
    	}else{
    		if(Context.getInstance().getBrowserName().equalsIgnoreCase("chrome")){
    			System.setProperty("webdriver.chrome.driver", Property.getProperty("chromeDriver"));
    			System.setProperty("webdriver.chrome.silentOutput", "true");
    			
    			//code to remember vip symantec
//    			--------------------------------
    			try{
//    			String cmd = "chrome.exe -remote-debugging-port=9014 --user-data-dir=\"C:\\Users\\anirudha.agnihotri\\Downloads\\Selenium\\chrome_Test_Profile\"";
//    				String cmd1 = "taskkill /F /IM chrome.exe /T";
//        			String cmd2 = "taskkill /F /IM chromedriver.exe /T";
//        			Runtime run = Runtime.getRuntime();
//        			Process pr = run.exec(cmd1);
//        			Process pr2 = run.exec(cmd2);
//    				String cmd = "chrome.exe -remote-debugging-port=9014 --user-data-dir=\"C:\\Users\\sonal.harish.nagda\\workspace\\almPT\\src\\test\\resources\\testdata\\chrome_Test_Profile\"";
//    			Runtime run1 = Runtime.getRuntime();
//    			Process pr1 = run1.exec(cmd);
//				Thread.sleep(5000);
    				
    				String cmd1 = "taskkill /F /IM chrome.exe /T";
//        			String cmd2 = "taskkill /F /IM chromedriver.exe /T";
        			String chromeProfile = System.getProperty("user.dir")+"\\src\\test\\resources\\testdata\\chrome_Test_Profile\\";
//        			String cmd3 = "chrome.exe -remote-debugging-port=9014 --user-data-dir=\"C:\\Users\\sonal.harish.nagda\\Downloads\\Selenium\\chrome_Test_Profile\"";
        			String cmd3 = "chrome.exe -remote-debugging-port=9014 --user-data-dir=\""+chromeProfile;
//        			System.out.println(cmd3);
        			Runtime run = Runtime.getRuntime();
        			Process pr = run.exec(cmd1);
//        			Process pr2 = run.exec(cmd2);
        			Thread.sleep(3000);
        			Process pr3 = run.exec(cmd3);
        			Thread.sleep(3000);

    			}
    			catch(Exception e)
    			{
    				e.printStackTrace();
    			}
				
    			ChromeOptions options = new ChromeOptions();
    			options.addArguments("disable-infobars");
    			options.addArguments("start-maximized");
    			 options.addArguments("--disable-extensions");
    			 options.addArguments("--disable-popup-blocking");
    			 options.addArguments("test-type");
     		    options.setExperimentalOption("debuggerAddress", "localhost:9014");
    			
    			options.setBinary(Property.getProperty("chromeBinary"));
    			cap.setCapability(ChromeOptions.CAPABILITY, options);
//    			--------------------------------
    			//code to remember vip symantec
    			driver.set(new ChromeDriver(cap));
    			sendEsc();
    			
    		}else if(Context.getInstance().getBrowserName().equalsIgnoreCase("internet explorer")){
//    	    	cap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);  //Workaround for ie zone settings on laptop
//    	    	cap.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, true);
    			cap.setCapability("ignoreZoomSetting", true);
    			System.setProperty("webdriver.ie.driver", Property.getProperty("internetExplorerDriver"));
//    			System.setProperty("webdriver.ie.driver.silent", "true");
//    			System.setProperty("ie.ensureCleanSession", "true");
//    			driver.set(new InternetExplorerDriver(cap));
    			driver.set(new InternetExplorerDriver(cap));
    		}else if(Context.getInstance().getBrowserName().equalsIgnoreCase("phantomjs")){
    			System.setProperty("phantomjs.binary.path", Property.getProperty("phantomDriver"));		
    			driver.set(new PhantomJSDriver(cap));
    		}else if(Context.getInstance().getBrowserName().equalsIgnoreCase("htmlunit")){
    			driver.set(new HtmlUnitDriver(cap));
    		}else{
    			File pathToBinary = new File(Property.getProperty("firefoxBinary"));
    			FirefoxBinary ffBinary = new FirefoxBinary(pathToBinary);
    			FirefoxProfile firefoxProfile = new FirefoxProfile();   
    			
    			File firebug = new File(Property.getProperty("extensions")+"firebug-2.0.18-fx.xpi");
				File firepath = new File(Property.getProperty("extensions")+"firepath-0.9.7.1-fx.xpi");
				File netexport = new File(Property.getProperty("extensions")+"netExport-0.9b7.xpi");

    			firefoxProfile.addExtension(firebug);
				firefoxProfile.addExtension(firepath);	
				firefoxProfile.addExtension(netexport);	

				firefoxProfile.setPreference("app.update.enabled", false);
    			//Setting Firebug preferences
    			firefoxProfile.setPreference("extensions.firebug.currentVersion", "2.0");
    			firefoxProfile.setPreference("extensions.firebug.addonBarOpened", true);
    			firefoxProfile.setPreference("extensions.firebug.console.enableSites", true);
    			firefoxProfile.setPreference("extensions.firebug.script.enableSites", true);
    			firefoxProfile.setPreference("extensions.firebug.net.enableSites", true);
    			firefoxProfile.setPreference("extensions.firebug.previousPlacement", 1);
    			firefoxProfile.setPreference("extensions.firebug.allPagesActivation", "on");
    			firefoxProfile.setPreference("extensions.firebug.onByDefault", true);
    			firefoxProfile.setPreference("extensions.firebug.defaultPanelName", "net");
    			firefoxProfile.setPreference("extensions.firebug.net.defaultPersist", true);
    			firefoxProfile.setPreference("extensions.firebug.console.defaultPersist", true);
    			// Setting netExport preferences
    			firefoxProfile.setPreference("extensions.firebug.netexport.alwaysEnableAutoExport", true);
    			firefoxProfile.setPreference("extensions.firebug.netexport.autoExportToFile", true);
    			firefoxProfile.setPreference("extensions.firebug.netexport.Automation", true);
    			firefoxProfile.setPreference("extensions.firebug.netexport.showPreview", false);
    			firefoxProfile.setPreference("extensions.firebug.netexport.defaultLogDir", Property.getProperty("har.dir"));

    			//driver.set(new FirefoxDriver(ffBinary,firefoxProfile));
    			firefoxProfile.setAcceptUntrustedCertificates(true);
    			firefoxProfile.setAssumeUntrustedCertificateIssuer(true);
    			firefoxProfile.setPreference("webdriver.load.strategy", "unstable");
    			cap.setCapability("binary", ffBinary);
    	        cap.setCapability(FirefoxDriver.PROFILE, firefoxProfile);
    			driver.set(new FirefoxDriver(cap));
    		}
    	}		
	}
    
    public void setTimeout(int timeout){
		getDriver().manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
	}
} 