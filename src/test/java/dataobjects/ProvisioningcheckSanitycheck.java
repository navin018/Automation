//package dataobjects;
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.*;
//import org.apache.http.HttpResponse;
//import org.apache.http.ParseException;
//import org.apache.http.util.EntityUtils;
//import io.restassured.response.Response;
//import restassured.Restassured;
//import utilities.general.Property;
//
//import static utilities.reporting.Reporting.*;
//
//
//public class ProvisioningcheckSanitycheck  {
//	
//   
//      
//
//	public static void check_for_standard_forkey() throws IOException {
//		try {
//			int count=0;
//			Response resp = null;
//			//String projectkey = readPreprovsioningData("projectkey");   // fetched from the stored procedure
//			//String projectname = readPreprovsioningData("projectname"); //fetched from the stored procedure
//			String projectkey = "TEST11211"; 
//			String projectname = "Test WWW";
//			Restassured r = new Restassured();
//			 try {
//				 resp = r.GetDetails("/rest/api/2/project/");
//			} catch (Exception e) {
//				create_logs_and_report(" Faliure in fetching the details for /rest/api/2/project/ ", "fail");
//			}
//			 
//			 System.out.println(resp.getBody().asString());
//			 String key = (String) resp.jsonPath().getList("key").get(0); 
//			 
//			 List<String> keys =  resp.jsonPath().getList("key");
//			 
//			 List<String> projectnames =  resp.jsonPath().getList("name");
//			 
//			 for (String string : keys) {
//				
//				 if (string.contains(projectkey)) {
//					System.out.println("The required key "+projectkey+" is present for jira proviosining and it is as per ADT standard");
//					create_logs_and_report("The required key "+projectkey+" is present for jira proviosining", "pass");
//					count++;
//				 }
//			}
//			 if(!(count==1)) {
//					create_logs_and_report("The required key "+projectkey+" is not present for jira proviosining", "fail");
//				}
//			 count =0;
//			 for (String string : projectnames) {
//				 
//				 if (string.contains(projectname)) {
//					System.out.println("The required name "+projectname+" is present for jira provisioning and it is as per ADT standard");
//					create_logs_and_report("The required name "+projectname+" is present for jira provisioning and it is as per ADT standard", "pass");
//					count++;
//				 }
//			}	 
//			 if(!(count==1)) {
//				 create_logs_and_report("The required name "+projectname+" is not present for jira proviosining", "fail");
//				}
//		} catch (Exception e) {
//			 create_logs_and_report("Faliure in fetching the project key and project name", "fail");
//
//		}
//		
//}
//
//	public static void users_associated_in_jira() throws IOException {
//		ArrayList<String> name = new ArrayList<String>();
//		ArrayList<String> displayname= new ArrayList<String>();
//		
//		Response resp1 =null;
//		//String projectkey = readPreprovsioningData("projectkey"); 
//		//String projectrole = readPreprovsioningData("projectroles");
//		
//		String projectkey = "TEST11211"; 
//		String projectrole = "Developers,Dredge,Read only Users,Administrators,Developer,Huddled,Users";
//		
//		String arrprojectrole[]=projectrole.split(",");
//			 Restassured r = new Restassured();
//			 try {
//				 resp1 = r.GetDetails("/rest/api/2/project/"+projectkey+"/role");
//			} catch (Exception e) {
//				create_logs_and_report(" Faliure in fetching the details for /rest/api/2/project/"+projectkey+"/role", "fail");
//			}
//			
//			  
//			 Map<String,String> map=resp1.jsonPath().getMap("$"); 
//			 System.out.println(map.keySet());
//			 int count;
//			 for (String string1 : arrprojectrole) {
//					count = 0;
//				 for (String string : map.keySet()) {
//					 if(string.contains(string1)) {
//						 count++;
//					 }
//					 else {
//						
//					}
//				 }
//				 if(count==0) {
//					 create_logs_and_report("Following role is not available in jira project "+string1, "fail");
//				 }
//				 else {
//					 create_logs_and_report("Following role is available in jira project "+string1, "pass");
//				}
//			 }
//			 System.out.println("Following are the list of roles that have been added for the project "+projectkey+" "+map.keySet());
//			 create_logs_and_report("Following are the list of roles that have been added for the project "+projectkey+" "+map.keySet(), "pass");  /////////From hwere I'm gonna verify user roles
//	 
//		
//		 
//		 ArrayList<String> ar=new ArrayList(); 
//		  for (String string : map.values()) 
//		  {
//			  ar.add(string.split("/role/")[1]); } 
//		  	for (String string : ar) { 
//		  		Response resp2 =r.GetDetails("/rest/api/2/project/"+projectkey+"/role/"+string);
//		  		System.out.println("Role  "+resp2.body().asString());
//		  		List<String> keys =  resp2.jsonPath().getList("actors");
//		  		System.out.println(keys+"test");
//		  		if(((keys.toString()).contains("id"))){
//		  			ArrayList<String> actors1 =new ArrayList<String>();
//		  			for (int i = 0; i <resp2.jsonPath().getList("actors").size(); i++) {
//						actors1.add(resp2.jsonPath().getList("actors").get(i).toString());
//					}
//		  		
//		  			System.out.println(actors1.size());
//		  			for (String string2 : actors1) {
//		  				try {
//							
//		  					System.out.println(((string2.split("name="))[1]).split(",")[0]);
//			  	            name.add(((string2.split("name="))[1]).split(",")[0]);
//			  	            System.out.println(((string2.split("displayName="))[1]).split(",")[0]);
//			  	            displayname.add(((string2.split("displayName="))[1]).split(",")[0]);
//					
//		  						
//						} catch (Exception e) {
//							create_logs_and_report("Faliure in adding actors with name and display name for project "+projectkey+" with userrole "+""+string+"", "fail");
//							
//						}
//		  					}
//		  			
//		  			System.out.println("Following actors have been added with the name for project "+projectkey+" with userrole "+""+string+" [ "+ name+" ]"); 
//		  			create_logs_and_report("Following actors have been added with the name for project "+projectkey+" with userrole "+""+string+" [ "+ name+" ]", "pass"); // verify the name
//		  			System.out.println("Following actors have been added with the displayename for project "+projectkey+" with userrole "+""+string+" [ "+ displayname+" ]");
//		  			create_logs_and_report("Following actors have been added with the displayename for project "+projectkey+" with userrole "+""+string+" [ "+ displayname+" ]", "pass");  //verify the display name
//
//		  			System.out.println(name);
//		  			System.out.println(displayname);
//		  		  		}
//		  		System.out.println("____________________________________"); 
//		  	}
//		
//	}
//
//	public static void custom_fields_should_be_added() throws IOException {
//	//	String projectkey = readPreprovsioningData("projectkey"); 
//	//	String custom_fields = readPreprovsioningData("custom_fields"); 
//		
//		String projectkey = "TEST11211"; 
//		String custom_fields =	"Legal Entity,Level,Plan Template,Shared Plan,Skill";
//		String[] custom__fields=custom_fields.split(",");
//		 Response resp1 = null;
//		try {
//			 Restassured r = new Restassured();
//			 try {
//				 resp1 = r.GetDetails("/rest/projectspecificselectfield/1.0/customfield/"+projectkey);
//
//			} catch (Exception e) {
//				create_logs_and_report(" Faliure in fetching the details for rest/projectspecificselectfield/1.0/customfield/"+projectkey, "fail");
//			}
//			 			 
//			 List<String> customfields =  resp1.jsonPath().getList("name");
//			 List<String> customfieldstype =  resp1.jsonPath().getList("type");
//			 
//			 
//			 int count;
//			 for (String string1 : custom__fields) {
//					count = 0;
//				 for (String string : customfields) {
//					 if(string.contains(string1)) {
//						 count++;
//					 }
//					 else {
//						
//					}
//				 }
//				 if(count==0) {
//					 create_logs_and_report("Following customfield is not available in jira project "+string1, "fail");
//				 }
//				 else {
//					 create_logs_and_report("Following customfield is available in jira project "+string1, "pass");
//				}
//			 }
//			 
//			 
//			 create_logs_and_report("Following custom fields are added "+customfields+" each of type "+customfields+" ", "pass");
//			 
//			 create_logs_and_report("Following custom fields are added of type"+customfields+" each of type "+customfieldstype+" ", "pass");  // custom fields fetch
//
//		} catch (Exception e) {
//			 create_logs_and_report("Not able to add the custom fields", "fail");
//
//		} 
//					
//		 
//	}
//
//	public static void four_L3_group_added_to_L2_group() {
//		try {
//			Restassured r = new Restassured();
//			//String groupname =  readPreprovsioningData("groupname");
//			
//			String groupname ="adtjira001eu.test.software-users-test-group";
//			
//			String adgroupurl=Property.getProperty("ADgroupURL");
//			String adgrouptokenurl=Property.getProperty("ADgroupTokenURL"); 
//			Response resp = r.tokenGenerationRestAssured(adgrouptokenurl);
//			System.out.println(resp.asString());
//			String token =((resp.asString().split("access_token\":\""))[1]).split("\",\"token_type")[0];
//
//			Response resp1 = r.getresponseFromToken(adgroupurl+"/activedirectory/group/"+groupname, token);
//			System.out.println(resp1.asString());
//			System.out.println("Group Owners for L2 group"+resp1.jsonPath().getList("groupOwners"));
//			System.out.println("Group Members for L2 group"+resp1.jsonPath().getList("groupMembers"));
//
//			
//			System.out.println((String) resp1.jsonPath().getList("groupMembers").get(0));
//			String L2groupname=(String) resp1.jsonPath().getList("groupMembers").get(0);
//			
//			
//			Response resp2 = r.getresponseFromToken(adgroupurl+"/activedirectory/group/"+L2groupname, token);
//			System.out.println("Group Owners for L3 group"+resp2.jsonPath().getList("groupOwners"));
//			System.out.println("Group Members for L3 group"+resp2.jsonPath().getList("groupMembers"));
//			
//			System.out.println(resp2.jsonPath().getList("groupMembers").size());
//			
//			if (resp2.jsonPath().getList("groupMembers").size()==4) {
//				 create_logs_and_report("Four L3 groups have been added to the L2 groups", "pass");
//				
//			}		} catch (Exception e) {
//			 
//		}
//		
//	}
//
//	
//
//	public static void nomenclature_of_the_ad_group_should_be_followed_as_per_the_adt_standards() throws IOException {
//		ArrayList<String> ar = new ArrayList<String>();
//		Restassured r = new Restassured();
//	//	String groupname =  readPreprovsioningData("groupname");
//		String groupname = "adtjira001eu.test.software-users-test-group";
//		String adgrouptokenurl=Property.getProperty("ADgroupTokenURL"); 
//		String adgroupurl=Property.getProperty("ADgroupURL");
//		
//		Response resp = r.tokenGenerationRestAssured(adgrouptokenurl);
//		System.out.println(resp.asString());
//		String token =((resp.asString().split("access_token\":\""))[1]).split("\",\"token_type")[0];
//		      // L1 group name Groupname that want to proviosion from where I'm going to fetch
//		String groupNameAPI=adgroupurl+"/activedirectory/group/"+groupname;
//		Response resp1 = r.getresponseFromToken(groupNameAPI, token);
//		System.out.println("Group Members for L2 group"+resp1.jsonPath().getList("groupMembers"));
//		String groupNme=(String) resp1.jsonPath().getList("groupMembers").get(0);
//		System.out.println(groupNme);
//		String arr[]=groupNme.split(".");
//		for (String string : arr) {
//			ar.add(string);
//		}
//		System.out.println(ar.size());
//		
//	}
//
//	public static void user_should_be_able_to_create_the_issue_for_the_newely_created_jira_project() throws ParseException, IOException {Restassured r = new Restassured();
//	//String projectkey = readPreprovsioningData("projectkey");
//	
//	String projectkey = "TEST11211"; 
//	
//	HttpResponse response = r.Postdata(projectkey);
//	
//	int code = response.getStatusLine().getStatusCode();
//    String responseBody = EntityUtils.toString(response.getEntity());
//     String Projectkey=(responseBody.split("key\":\"")[1]).split("\",\"self")[0];
//    if (code==201 || code==200) {
//    	create_logs_and_report("Issue successfully created with the newly createated project with id"+Projectkey+"and the response code is"+code, "pass");
//
//	}}
//
//   
//	public static String readPreprovsioningData(String key1) throws IOException {
//		String everything = null;
//		BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir")+"\\JiraProvisioningDetails\\PreProvisioningdetails.txt"));
//	 
//		try {
//		    StringBuilder sb = new StringBuilder();
//		    String line = br.readLine();
//
//		    while (line != null) {
//		        sb.append(line);
//		        sb.append(System.lineSeparator());
//		        
//		        line=line;
//		        if (line.contains(key1)) {
//					line=line.split(":=")[1];
//					  everything = line;
//					break;
//				}
//		        line = br.readLine();
//		    }
//		   
//		} finally {
//		    br.close();
//		}
//		return everything;
//	}
//    
//}