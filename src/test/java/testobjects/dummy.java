package testobjects;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONObject;

public class dummy {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		String WorkItemEx_FileLoc = System.getProperty("user.dir")
				+ File.separator + "src" + File.separator + "test" + File.separator
				+ "resources" + File.separator + "testdata" + File.separator + "ADTJira" + File.separator + "WorkItemExternalIDs.json";
	  
		JSONObject jsonObject = new JSONObject();
		
	    
	    jsonObject.put("WorkItemExternalId_Task", "BOM-123");
	    jsonObject.put("WorkItemExternalId_Story", "BOM-456");
	    FileWriter file = new FileWriter(WorkItemEx_FileLoc);
        file.write(jsonObject.toJSONString());
        file.close();

	}

}
