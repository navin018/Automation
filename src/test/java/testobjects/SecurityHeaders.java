package testobjects;

import java.util.Date;

public class SecurityHeaders {
	
	public SecurityHeaders(String Tile, String RequestURL, String BaseURL, String Header,String Findings){
		this.Tile=Tile;
		this.RequestURL=RequestURL;
		this.BaseURL=BaseURL;
		this.Header=Header;
		this.Findings=Findings;
	}
	
	public String Tile;
	public String RequestURL;
	public String BaseURL;
	public String Header;
	
	public String Findings;
	public String getTile() {
		return Tile;
	}
	public void setTile(String tile) {
		Tile = tile;
	}
	public String getRequestURL() {
		return RequestURL;
	}
	public void setRequestURL(String requestURL) {
		RequestURL = requestURL;
	}
	public String getHeader() {
		return Header;
	}
	public void setHeader(String header) {
		Header = header;
	}

	public String getBaseURL() {
		return BaseURL;
	}
	public void setBaseURL(String baseURL) {
		BaseURL = baseURL;
	}
	public String getFindings() {
		return Findings;
	}
	public void setFindings(String findings) {
		Findings = findings;
	}


}
