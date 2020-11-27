package utilities.iris;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.JSONObject;
import java.io.FileInputStream;

/** 
 * provides set of methods for interacting with the IRIS Application via its API
 * including getting the platform/browser combination for execution, updating the
 * execution status and uploading screenshots
 * 
 */
public class APICaller {

	private final String USER_AGENT = "Mozilla/5.0";
	private String HOSTNAME;
	private final String API_VERSION = "v1";
	
	private final String BOUNDARY = "*****";	
	private final String CRLF = "\r\n";
	private final String HYPHENS = "--";
	
	public APICaller(String host) {
		HOSTNAME = host + "api/" + API_VERSION + "/";
	}
	
	public void setExecutionStatus(int exec_id, String status) throws Exception {
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("exec_id", String.valueOf(exec_id));
		params.put("status", status);
		
		System.out.println("Exec status result: " + sendPost(HOSTNAME + "setExecutionStatus.php", params, null));
	}
	
	public JSONObject getExecutionCapabilities(int exec_id) throws Exception {
		return sendGet(HOSTNAME + "getExecutionCapabilities.php", "exec_id=" + exec_id);
	}

	public JSONObject uploadScreenshot(int exec_id, int platform_id, int browser_id, int step_no, String step_desc, String URL, String title, File screenshot) throws Exception {

		HashMap<String, String> params = new HashMap<String, String>();
		params.put("exec_id", String.valueOf(exec_id));
		params.put("platform_id", String.valueOf(platform_id));
		params.put("browser_id", String.valueOf(browser_id));
		params.put("step_no", String.valueOf(step_no));
		params.put("step_desc", step_desc);
		params.put("url", URL);
		params.put("page_title", title);

		return sendPost(HOSTNAME + "uploadScreenshot.php", params, screenshot);
	}

	// HTTP GET request
	private JSONObject sendGet(String url, String urlParameters) throws Exception {
		
		URL obj = new URL(url + "?" + urlParameters);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		//add request header
		con.setRequestProperty("User-Agent", USER_AGENT);

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		//print result
		return new JSONObject(response.toString());
	}
	
	// HTTP POST request
	private JSONObject sendPost(String url, HashMap<String,String> urlParameters, File file) throws Exception {

//		String boundary =  "*****";
		
		String userPassword = "admin123" + ":" + "adminpw123";
		@SuppressWarnings("restriction")
//		String encoding = new sun.misc.BASE64Encoder().encode(userPassword.getBytes());			


		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestProperty("Authorization","Basic"+"encoding");

		// Request header
		con.setUseCaches(false);
		con.setDoOutput(true);
		con.setRequestMethod("POST");
		con.setRequestProperty("Connection", "Keep-Alive");
		con.setRequestProperty("Cache-Control", "no-cache");
		con.setRequestProperty("User-Agent", USER_AGENT);
		con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
		con.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + BOUNDARY);

		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());

		@SuppressWarnings("rawtypes")
		Iterator params = urlParameters.entrySet().iterator();
		while (params.hasNext())
		{
			@SuppressWarnings("rawtypes")
			Map.Entry paramMap = (Map.Entry)params.next();
			String name = (String) paramMap.getKey();
			String value = (String) paramMap.getValue();

			wr.writeBytes(HYPHENS + BOUNDARY + CRLF);
			wr.writeBytes("Content-Disposition: form-data; name=\"" + name + "\"" + CRLF);
			wr.writeBytes("Content-Type: text/plain; charset=UTF-8" + CRLF);
	        wr.writeBytes(CRLF);
	        wr.writeBytes(value);
	        wr.writeBytes(CRLF);
	        wr.flush();
		}
		
		
			    
		if (file != null) {
			
			wr.writeBytes(HYPHENS + BOUNDARY + CRLF);
			wr.writeBytes("Content-Disposition: form-data; name=\"" +
			    "screenshot" + "\";filename=\"" + 
			    "screenshot" + "\"" + CRLF);
			wr.writeBytes(CRLF);
	
			
	        byte[] bFile = new byte[(int) file.length()];
	        
            //convert file into array of bytes
		    FileInputStream fileInputStream = new FileInputStream(file);
		    fileInputStream.read(bFile);
		    fileInputStream.close();
		    wr.write(bFile);

	        wr.writeBytes(CRLF);
	        wr.writeBytes(HYPHENS + BOUNDARY + HYPHENS + CRLF);
	        
			wr.flush();
			wr.close();
		}

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'POST' request to URL : " + url);
		System.out.println("Post parameters : " + urlParameters);
		System.out.println("Response Code : " + responseCode);
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
		
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		//print result
		return new JSONObject();

	}


}