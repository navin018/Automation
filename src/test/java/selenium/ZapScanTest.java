/*
 * Copyright (c) 2014 ContinuumSecurity www.continuumsecurity.net
 *
 * The contents of this file are subject to the GNU Affero General Public
 * License version 3 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://www.gnu.org/licenses/agpl-3.0.txt
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 *
 * The Initial Developer of the Original Code is ContinuumSecurity.
 * Portions created by ContinuumSecurity are Copyright (C)
 * ContinuumSecurity SLNE. All Rights Reserved.
 *
 * Contributor(s): Stephen de Vries
 */

package selenium;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.zaproxy.clientapi.core.ApiResponse;
import org.zaproxy.clientapi.core.ApiResponseElement;
import org.zaproxy.clientapi.core.ClientApi;
import org.zaproxy.clientapi.core.ClientApiException;
import utilities.general.Property;

import java.io.*;

public class ZapScanTest {
   // static Logger log = Logger.getLogger(ZapScanTest.class.getName());
	 private final static String ZAP_SESSION_IP="127.0.0.1";
    private final static String ZAP_PROXYHOST = "localhost";
    private final static int ZAP_PROXYPORT = 8090;
    private final static String ZAP_APIKEY = "m6g561l6b953rfkdquhe56ccuv";
    private static String TARGET = "http://rptncluc4802:9090/uc-demolaunchpad/";
    private WebDriver driver;
    int currentScanID;
    private static ClientApi api;
    private static ApiResponse resp;
    private static Process p;
    private static int reportCount=1;
    
    public static void initZapScanner(){
    	api = new ClientApi(ZAP_PROXYHOST, ZAP_PROXYPORT, ZAP_APIKEY);
    }
 
   
    public static void spider(){
    	try {
    		TARGET=Property.getProperty("targetApp");
    	System.out.println("Spider : " + TARGET);
        // It's not necessary to pass the ZAP API key again, already set when creating the ClientApi.
        
		
			resp = api.spider.scan(TARGET, null, null, null, null);
		
        String scanid;
        int progress;

        // The scan now returns a scan id to support concurrent scanning
        scanid = ((ApiResponseElement) resp).getValue();

        // Poll the status until it completes
        while (true) {
            Thread.sleep(1000);
            progress = Integer.parseInt(((ApiResponseElement) api.spider.status(scanid)).getValue());
            System.out.println("Spider progress : " + progress + "%");
            if (progress >= 100) {
                break;
            }
        }
        System.out.println("Spider complete");

        // Give the passive scanner a chance to complete
        Thread.sleep(2000);
		} catch (ClientApiException | InterruptedException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    public static void ActiveScan(){
    	
    	 try {
    		TARGET=Property.getProperty("targetApp");
	    	Thread.sleep(2000);
	
	        System.out.println("Active scan : " + TARGET);
	        resp = api.ascan.scan(TARGET, "True", "False", null, null, null);
	        String scanid;
	        int progress;
	        // The scan now returns a scan id to support concurrent scanning
	        scanid = ((ApiResponseElement) resp).getValue();
	
	        // Poll the status until it completes
	        while (true) {
	           
					Thread.sleep(5000);
				
	            progress = Integer.parseInt(((ApiResponseElement) api.ascan.status(scanid)).getValue());
	            System.out.println("Active Scan progress : " + progress + "%");
	            if (progress >= 100) {
	                break;
	            }
	        }
	        System.out.println("Active Scan complete");
	
	        System.out.println("Alerts:");
	        System.out.println(new String(api.core.xmlreport()));
	        FileUtils.writeByteArrayToFile(new File(Property.getProperty("zap_report"), "ZapReport"+reportCount+".xml"),api.core.xmlreport());
	        reportCount++;
    	 } catch (InterruptedException e) {
				e.printStackTrace();
		} catch (ClientApiException e) {
			e.printStackTrace();
		} catch (IOException e) {
				e.printStackTrace();
			}
    }
    
	 public static boolean startZap(){
		 try{
			 if(p==null){    			
    			 String[] command = {"CMD", "/C", Property.getProperty("zap_location")+"ZAP.exe"};
    			 ProcessBuilder proc = new ProcessBuilder(command);
    			 proc.directory(new File(Property.getProperty("zap_location")));
    			 p = proc.start();
    			 p.waitFor();
    			 BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
    			 OutputStreamWriter oStream = new OutputStreamWriter(p.getOutputStream());
    			 oStream.write("process where name = 'ZAP.exe'");;
    			 oStream.flush();
    			 oStream.close();
    			 String line;
    			 
    			 while((line = input.readLine())!=null){
    				 if(line.contains("INFO")&& line.contains("org.parosproxy.paros.control.Control") && line.contains("New Session")) {
    					 input.close();
    					 break;
    				 }
    			 }
    			 System.out.println("ZAP has started successfully");
			 }
			 return true;
		 }catch(Exception e){
				 System.out.println("ZAP was unable to start");
				 e.printStackTrace();
				 return false;
		 }
		 
		 
	 }
    	 
	 public static void stopZAP(){
		 if(p!=null){
			 p.destroy();
		 }
	 }
}



