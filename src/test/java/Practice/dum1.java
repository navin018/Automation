package Practice;
import org.json.JSONObject;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

import org.json.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class dum1 {

	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		// TODO Auto-generated method stub
//		String WorkItemEx_FileLoc = System.getProperty("user.dir")+ File.separator + "src" + File.separator + "test" + File.separator+ "resources" + File.separator + "testdata" + File.separator + "TFS" + File.separator + "JSON" +  File.separator  + "WorkItemExternalIDs.json";
//		JSONParser jsonParser = new JSONParser();
//		
//		JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader(WorkItemEx_FileLoc));
//		String a = (String.valueOf(jsonObject.get("WorkItemExternalId_Task")));
//		System.out.println(a);
		
		
//		String WorkItemEx_FileLoc = System.getProperty("user.dir")+ File.separator + "src" + File.separator + "test" + File.separator+ "resources" + File.separator + "testdata" + File.separator + "TFS" + File.separator + "JSON" +  File.separator  + "WorkItemExternalIDs.json";
		JSONParser jsonParser = new JSONParser();
//		
		JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader("C:\\Users\\sonal.harish.nagda\\Documents\\almPT_old\\src\\test\\resources\\testdata\\TFS\\JSON\\WorkItem.json"));
		Map address = (Map) jsonObject.get("Task_01");
		System.out.println(address);
		
	}

}
