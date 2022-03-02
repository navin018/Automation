package utilities.selenium;

import com.jcraft.jsch.*;
import utilities.general.Property;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static utilities.reporting.LogUtil.logger;

public class Batches {
	private static String claimID;
	private static String PBSFileName;
	private Object base;
	
	public Object getBase() {
		return base;
	}

	public void setBase(Object base) {
		this.base = base;
	}
	JSch jsch = new JSch();
	
	private static Batches execc = new Batches();
	
	public static Batches getInstance(){
		return execc;
	}
	public static void getClaimidAndPBSFileName(String claim_id, String pbs_file_name) {
		claimID = claim_id;
		PBSFileName= pbs_file_name;
}
	public static Map<String, String> batchNumToCommand = new HashMap<String, String>();
	
	static{
		batchNumToCommand.put("001", "sudo -u jbeap /opt/uc/bin/ucevidencebatch.sh DWP_UC_EVD_001_moveClaimData");
		batchNumToCommand.put("002", "sudo -u jbeap /opt/uc/bin/ucevidencebatch.sh DWP_UC_EVD_002_markClaimForDeletion");
		batchNumToCommand.put("003", "sudo -u jbeap /opt/uc/bin/ucevidencebatch.sh DWP_UC_EVD_003_transformClaimData");
		batchNumToCommand.put("004", "sudo -u jbeap /opt/uc/bin/ucevidencebatch.sh DWP_UC_EVD_004_manageClaimSubmission");
		batchNumToCommand.put("005", "sudo -u jbeap /opt/uc/bin/ucevidencebatch.sh DWP_UC_EVD_005_extractRTINotification");
		batchNumToCommand.put("006", "sudo -u jbeap /opt/uc/bin/ucevidencebatch.sh DWP_UC_EVD_006_processCISChanges");
		batchNumToCommand.put("007", "sudo -u jbeap /opt/uc/bin/ucevidencebatch.sh DWP_UC_EVD_007_performAssessment");
		batchNumToCommand.put("008", "sudo -u jbeap /opt/uc/bin/ucevidencebatch.sh DWP_UC_EVD_008_extractUCEntitlement");
		batchNumToCommand.put("009", "sudo -u jbeap /opt/uc/bin/ucevidencebatch.sh DWP_UC_EVD_009_extractUCAward");
		batchNumToCommand.put("010", "sudo -u jbeap /opt/uc/bin/ucevidencebatch.sh DWP_UC_EVD_010_extractBankDetails");
		batchNumToCommand.put("011", "sudo -u jbeap /opt/uc/bin/ucevidencebatch.sh DWP_UC_EVD_011_deleteBankDetails");
		batchNumToCommand.put("012", "sudo -u jbeap /opt/uc/bin/ucevidencebatch.sh DWP_UC_EVD_012_processPaymentSummary");		
		batchNumToCommand.put("013", "sudo -u jbeap /opt/uc/bin/ucevidencebatch.sh DWP_UC_EVD_001_moveClaimData");
		batchNumToCommand.put("014", "sudo -u jbeap /opt/uc/bin/ucevidencebatch.sh DWP_UC_EVD_001_moveClaimData");
		batchNumToCommand.put("015", "sudo -u jbeap /opt/uc/bin/ucevidencebatch.sh DWP_UC_EVD_015_extractNotification");
		batchNumToCommand.put("016", "sudo -u jbeap /opt/uc/bin/ucevidencebatch.sh DWP_UC_EVD_001_moveClaimData");
		batchNumToCommand.put("017", "sudo -u jbeap /opt/uc/bin/ucevidencebatch.sh DWP_UC_EVD_017_moveSREData");
		batchNumToCommand.put("018", "sudo -u jbeap /opt/uc/bin/ucevidencebatch.sh DWP_UC_EVD_018_markSREForDeletion");
		batchNumToCommand.put("019", "sudo -u jbeap /opt/uc/bin/ucevidencebatch.sh DWP_UC_EVD_019_extractSREData");
		batchNumToCommand.put("020", "sudo -u jbeap /opt/uc/bin/ucevidencebatch.sh DWP_UC_EVD_001_moveClaimData");
		batchNumToCommand.put("021", "sudo -u jbeap /opt/uc/bin/ucevidencebatch.sh DWP_UC_EVD_001_moveClaimData");
		batchNumToCommand.put("022", "sudo -u jbeap /opt/uc/bin/ucevidencebatch.sh DWP_UC_EVD_001_moveClaimData");
		batchNumToCommand.put("023", "sudo -u jbeap /opt/uc/bin/ucevidencebatch.sh DWP_UC_EVD_023_updateCISDetails");
		batchNumToCommand.put("024", "sudo -u jbeap /opt/uc/bin/ucevidencebatch.sh DWP_UC_EVD_024_updateCISInterest");
		batchNumToCommand.put("025", "sudo -u jbeap /opt/uc/bin/ucevidencebatch.sh DWP_UC_EVD_025_extractEmploymentDetail");
		batchNumToCommand.put("026", "sudo -u jbeap /opt/uc/bin/ucevidencebatch.sh DWP_UC_EVD_001_moveClaimData");
		batchNumToCommand.put("027", "sudo -u jbeap /opt/uc/bin/ucevidencebatch.sh DWP_UC_EVD_001_moveClaimData");
		batchNumToCommand.put("028", "sudo -u jbeap /opt/uc/bin/ucevidencebatch.sh DWP_UC_EVD_001_moveClaimData");
		batchNumToCommand.put("029", "sudo -u jbeap /opt/uc/bin/ucevidencebatch.sh DWP_UC_EVD_001_moveClaimData");
		batchNumToCommand.put("030", "sudo -u jbeap /opt/uc/bin/ucevidencebatch.sh DWP_UC_EVD_030_PublishBPMMsgs");
		batchNumToCommand.put("031", "sudo -u jbeap /opt/uc/bin/ucevidencebatch.sh DWP_UC_EVD_031_PublishCAMLiteMsgs");
		batchNumToCommand.put("032", "sudo -u jbeap /opt/uc/bin/ucevidencebatch.sh DWP_UC_EVD_001_moveClaimData");
		batchNumToCommand.put("033", "sudo -u jbeap /opt/uc/bin/ucevidencebatch.sh DWP_UC_EVD_001_moveClaimData");
		batchNumToCommand.put("034", "sudo -u jbeap /opt/uc/bin/ucevidencebatch.sh DWP_UC_EVD_034_DetermineVerification");
		batchNumToCommand.put("035", "sudo -u jbeap /opt/uc/bin/ucevidencebatch.sh DWP_UC_EVD_001_moveClaimData");
		batchNumToCommand.put("036", "sudo -u jbeap /opt/uc/bin/ucevidencebatch.sh DWP_UC_EVD_001_moveClaimData");
		batchNumToCommand.put("037", "sudo -u jbeap /opt/uc/bin/ucevidencebatch.sh DWP_UC_EVD_037_MarkVerification");
		batchNumToCommand.put("038", "sudo -u jbeap /opt/uc/bin/ucevidencebatch.sh DWP_UC_EVD_038_claimant_moveClaimData");
		batchNumToCommand.put("039", "sudo -u jbeap /opt/uc/bin/ucevidencebatch.sh DWP_UC_EVD_039_claimant_markClaimForDeletion");
		batchNumToCommand.put("040", "sudo -u jbeap /opt/uc/bin/ucevidencebatch.sh DWP_UC_EVD_040_igsExtract");
		batchNumToCommand.put("041", "sudo -u jbeap /opt/uc/bin/ucevidencebatch.sh DWP_UC_EVD_001_moveClaimData");
		batchNumToCommand.put("042", "sudo -u jbeap /opt/uc/bin/ucevidencebatch.sh DWP_UC_EVD_042_performMonthlyAssessment");
		batchNumToCommand.put("043", "sudo -u jbeap /opt/uc/bin/ucevidencebatch.sh DWP_UC_EVD_001_moveClaimData");
		batchNumToCommand.put("044", "sudo -u jbeap /opt/uc/bin/ucevidencebatch.sh DWP_UC_EVD_001_moveClaimData");
		batchNumToCommand.put("045", "sudo -u jbeap /opt/uc/bin/ucevidencebatch.sh DWP_UC_EVD_001_moveClaimData");
		batchNumToCommand.put("046", "sudo -u jbeap /opt/uc/bin/ucevidencebatch.sh DWP_UC_EVD_001_moveClaimData");
		batchNumToCommand.put("047", "sudo -u jbeap /opt/uc/bin/ucevidencebatch.sh DWP_UC_EVD_001_moveClaimData");
		batchNumToCommand.put("048", "sudo -u jbeap /opt/uc/bin/ucevidencebatch.sh DWP_UC_EVD_001_moveClaimData");
		batchNumToCommand.put("049", "sudo -u jbeap /opt/uc/bin/ucevidencebatch.sh DWP_UC_EVD_001_moveClaimData");
		batchNumToCommand.put("050", "sudo -u jbeap /opt/uc/bin/ucevidencebatch.sh DWP_UC_EVD_001_moveClaimData");
		batchNumToCommand.put("051", "sudo -u jbeap /opt/uc/bin/ucevidencebatch.sh DWP_UC_EVD_051_categoriseLAData");
		batchNumToCommand.put("052", "sudo -u jbeap /opt/uc/bin/ucevidencebatch.sh DWP_UC_EVD_052_triggerLADSProcess");
		batchNumToCommand.put("053", "sudo -u jbeap /opt/uc/bin/ucevidencebatch.sh DWP_UC_EVD_053_categorisePaymentData");
		batchNumToCommand.put("054", "sudo -u jbeap /opt/uc/bin/ucevidencebatch.sh DWP_UC_EVD_054_updateLCTRInterest");
		batchNumToCommand.put("055", "sudo -u jbeap /opt/uc/bin/ucevidencebatch.sh DWP_UC_EVD_055_requestLACode");
		batchNumToCommand.put("056", "sudo -u jbeap /opt/uc/bin/ucevidencebatch.sh DWP_UC_EVD_001_moveClaimData");
		batchNumToCommand.put("057", "sudo -u jbeap /opt/uc/bin/ucevidencebatch.sh DWP_UC_EVD_001_moveClaimData");
		batchNumToCommand.put("058", "sudo -u jbeap /opt/uc/bin/ucevidencebatch.sh DWP_UC_EVD_001_moveClaimData");
		batchNumToCommand.put("059", "sudo -u jbeap /opt/uc/bin/ucevidencebatch.sh DWP_UC_EVD_001_moveClaimData");
		batchNumToCommand.put("060", "sudo -u jbeap /opt/uc/bin/ucevidencebatch.sh DWP_UC_EVD_001_moveClaimData");
		batchNumToCommand.put("061", "sudo -u jbeap /opt/uc/bin/ucevidencebatch.sh DWP_UC_EVD_001_moveClaimData");
		batchNumToCommand.put("062", "sudo -u jbeap /opt/uc/bin/ucevidencebatch.sh DWP_UC_EVD_001_moveClaimData");
		batchNumToCommand.put("064", "sudo -u jbeap /opt/uc/bin/ucevidencebatch.sh DWP_UC_EVD_064_categoriseHBStopData");//added by VK
		batchNumToCommand.put("065", "sudo -u jbeap /opt/uc/bin/ucevidencebatch.sh DWP_UC_EVD_065_performArrearsAssessment");//added by rsequeir
		batchNumToCommand.put("066", "sudo -u jbeap /opt/uc/bin/ucevidencebatch.sh DWP_UC_EVD_066_triggerHBStopProcess");//added by snagda
		
	}

	public static String executeBatchFile(String batchname) throws NumberFormatException, IOException {
		
		
		if (batchname.equalsIgnoreCase("sessionLoader")) {
			execc.executeSessionLoaderBatch("createPBSFile.sh");
		}
		if (batchname.equalsIgnoreCase("Verification")) {
			execc.executeVerificationBatch("createPBSFile.sh");
		}		
		if (batchname.equalsIgnoreCase("DV2")) {
			execc.executeDV1("createPBSFile.sh");
		}
		if (batchname.equalsIgnoreCase("PA")) {
			execc.executePA("createPBSFile.sh");
		}
		if (batchname.equalsIgnoreCase("GUCE")) {
			execc.executeGUCE("createPBSFile.sh");
		}	
		if (batchname.equalsIgnoreCase("PBS")) {
			execc.executePBSFile("createPBSFile.sh");
		}
		if (batchname.equalsIgnoreCase("RemoveRecordsInPBS")) {
			execc.executeRemovePBSRecords("removeUnmatch.sh");
		}
		if (batchname.equalsIgnoreCase("DeleteFiles")) {
			execc.deleteFilesOnServer();
		}
		
		return targetApp();

	}
	
	public void deleteFilesOnServer(){
		List<String> result = new ArrayList<String>();
		try {
			Session session = connectionSessionToRemote(getUsername(), getPassword(), gethost02(), getport());
			List<String> commandsList = new ArrayList<String>();
			 commandsList.add("sudo -u jbeap /bin/rm /var/middleware/uc-evidence-batch/io/outbound-process/*");
			 commandsList.add("sudo -u jbeap /bin/rm /var/middleware/uc-evidence-batch/io/archive/*");
			 commandsList.add("sudo -u jbeap /bin/rm /ftran/uc/received/internal/*");
//			 commandsList.add("sudo -u jbeap /bin/rm /var/middleware/uc-evidence-batch/io/outbound*");	
						 
			List<String> result1 = executeCommands(commandsList, session);
			int exitStatus = Integer.valueOf(result1.get(result1.size()-1));
			session.disconnect();
			if (exitStatus == -99) {
				throw new RuntimeException();
			}
			if (exitStatus < 0) {
				System.out.println("Done deleting files, but exit status not set!" + exitStatus);

			} else if (exitStatus > 0) {
				System.out.println("exit status" + exitStatus);

			} else {
				System.out.println("Done deleting files!");
			}

		} catch (Exception e) {
			System.err.println("Error: " + e);
		}
		
		
	} 
	
	public void executeBatch(String batchNum) throws IOException, InterruptedException{
		Session session = connectionSessionToRemote(getUsername(), getPassword(), gethost02(), getport());
		List<String> commandsList = new ArrayList<String>();
//		Thread.sleep(4000);
		if(batchNumToCommand.get(batchNum) ==null){
			throw new RuntimeException("Invalid batch number:"+batchNum);
		}
		commandsList.add(batchNumToCommand.get(batchNum));
		List<String> result = executeCommands(commandsList, session);
		int exitStatus = Integer.valueOf(result.get(result.size()-1));
		session.disconnect();
		if (exitStatus == -99) {
			throw new RuntimeException();
		}
		if (exitStatus < 0) {
			System.out.println("Done, but exit status not set!" + exitStatus);

		} else if (exitStatus > 0) {
			System.out.println("exit status" + exitStatus);

		} else {
			System.out.println("Done!");
		}
	}

	public static String executesysDate(String batchname, String sysDD, String sysMM, String sysYYYY) throws NumberFormatException, IOException {
	Batches execc = new Batches();
	
	if (batchname.equalsIgnoreCase("sysDate")) {
		execc.executeSysDateUpdateBatch("createPBSFile.sh",sysDD,sysMM,sysYYYY);
	}
	return targetApp();

	}

	public static String targetApp() throws IOException {
		//System.out.println("targetapp");
//		String test = Property.getProperty("targetApp");
//		System.out.println(test);
		return Property.getProperty("targetApp");

	}

	/***
	 * UserName, Password, Host and Port is captured from Project.properties
	 * file
	 ***/

	public String getUsername() throws IOException {
		return Property.getProperty("batch_USERNAME");
	}

	public String getPassword() throws IOException {
		return Property.getProperty("batch_PASSWORD");
	}

	public String gethost01() throws IOException {
		return Property.getProperty("host3101");
	}

	public String gethost02() throws IOException {
		return Property.getProperty("host3102");
	}

	public int getport() throws IOException {
		return Integer.parseInt(Property.getProperty("port"));
	}
	

	private String getStubhost() throws IOException {
		return Property.getProperty("StubHost");
	}


	/**
	 * This method will execute the script file on the server. This takes file
	 * name to be executed as an argument The result will be returned in the
	 * form of the list
	 * 
	 * @param scriptFileName
	 * @return
	 */
	public List<String> executeSessionLoaderBatch(String scriptFileName) {

		List<String> result = new ArrayList<String>();
		try {

			/**
			 * Create a new Jsch object This object will execute shell commands
			 * or scripts on server
			 */

			/*
			 * Open a new session, with your username, host and port Set the
			 * password and call connect. session.connect() opens a new
			 * connection to remote SSH server. Once the connection is
			 * established, you can initiate a new channel. this channel is
			 * needed to connect to remotely execution program
			 */

			Session session = connectionSessionToRemote(getUsername(), getPassword(), gethost02(), getport());
			// create the execution channel over the session

			List<String> commandsList = new ArrayList<String>();
//			Thread.sleep(4000);
			// accessing through sh file
			// commandsList.add("cd /home/nchaudha");
			// commandsList.add("sh "+"evidenceBatch.sh");
			// System.out.println("Running Session Loader");

			// Batch commands for Claimaint
			commandsList.add("sudo -u jbeap /opt/uc/bin/ucevidencebatch.sh DWP_UC_EVD_001_moveClaimData >> test.log");
			System.out.println("BATCH 001");
//			Thread.sleep(4000);
			commandsList.add("sudo -u jbeap /opt/uc/bin/ucevidencebatch.sh DWP_UC_EVD_003_transformClaimData >> test.log");
			System.out.println("BATCH 003");
//			Thread.sleep(4000);
			commandsList.add("sudo -u jbeap /opt/uc/bin/ucevidencebatch.sh DWP_UC_EVD_002_markClaimForDeletion >> test.log");
			System.out.println("BATCH 002");
//			Thread.sleep(4000);
			commandsList.add("sudo -u jbeap /opt/uc/bin/ucevidencebatch.sh DWP_UC_EVD_004_manageClaimSubmission >> test.log");
			System.out.println("BATCH 004");
//			Thread.sleep(4000);

			List<String> result1 = executeCommands(commandsList, session);
			int exitStatus = Integer.valueOf(result1.get(result1.size()-1));
			// Read the output from the input stream we set above
			// Read each line from the buffered reader and add it to result list
			// You can also simple print the result here

			// Safely disconnect channel and disconnect session. If not done
			// then it may cause resource leak

			session.disconnect();
			if (exitStatus == -99) {
				logger.info("Session loader failed with exit status"+ exitStatus);
				throw new RuntimeException();
			}
			if (exitStatus < 0) {
				System.out.println("Done, but exit status not set!" + exitStatus);
				logger.info("Session loader done. But exit status"+ exitStatus);

			} else if (exitStatus > 0) {
				System.out.println("exit status" + exitStatus);
				logger.info("Session loader done. But exit status"+ exitStatus);

			} else {
				System.out.println("Done!");
				logger.info("Session loader run successful");
				
				
			}

		} catch (Exception e) {
			System.err.println("Error: " + e);
		}
		return result;
	}
	
	public List<String> laDataShareWithPaymentBatch(){


		List<String> result = new ArrayList<String>();
		try {

			/**
			 * Create a new Jsch object This object will execute shell commands
			 * or scripts on server
			 */

			/*
			 * Open a new session, with your username, host and port Set the
			 * password and call connect. session.connect() opens a new
			 * connection to remote SSH server. Once the connection is
			 * established, you can initiate a new channel. this channel is
			 * needed to connect to remotely execution program
			 */

			Session session = connectionSessionToRemote(getUsername(), getPassword(), gethost02(), getport());
			// create the execution channel over the session

			List<String> commandsList = new ArrayList<String>();
			Thread.sleep(4000);
			// accessing through sh file
			// commandsList.add("cd /home/nchaudha");
			// commandsList.add("sh "+"evidenceBatch.sh");
			// System.out.println("Running Session Loader");

			// Batch commands for Claimaint
			commandsList.add("sudo -u jbeap /opt/uc/bin/ucevidencebatch.sh DWP_UC_EVD_012_processPaymentSummary >> test.log");
			System.out.println("BATCH 012");
			Thread.sleep(4000);
			commandsList.add("sudo -u jbeap /opt/uc/bin/ucevidencebatch.sh DWP_UC_EVD_055_requestLACode >> test.log");
			System.out.println("BATCH 055");
			Thread.sleep(4000);
			commandsList.add("sudo -u jbeap /opt/uc/bin/ucevidencebatch.sh DWP_UC_EVD_051_categoriseLAData >> test.log");
			System.out.println("BATCH 051");
			Thread.sleep(4000);
			commandsList.add("sudo -u jbeap /opt/uc/bin/ucevidencebatch.sh DWP_UC_EVD_053_categorisePaymentData >> test.log");
			System.out.println("BATCH 053");
			Thread.sleep(4000);
			commandsList.add("sudo -u jbeap /opt/uc/bin/ucevidencebatch.sh DWP_UC_EVD_052_triggerLADSProcess >> test.log");
			System.out.println("BATCH 052");
			Thread.sleep(4000);

			List<String> result1 = executeCommands(commandsList, session);
			int exitStatus = Integer.valueOf(result1.get(result1.size()-1));
			// Read the output from the input stream we set above
			// Read each line from the buffered reader and add it to result list
			// You can also simple print the result here

			// Safely disconnect channel and disconnect session. If not done
			// then it may cause resource leak

			session.disconnect();
			if (exitStatus == -99) {
				throw new RuntimeException();
			}
			if (exitStatus < 0) {
				System.out.println("Done, but exit status not set!" + exitStatus);

			} else if (exitStatus > 0) {
				System.out.println("exit status" + exitStatus);

			} else {
				System.out.println("Done!");
	
			}

		} catch (Exception e) {
			System.err.println("Error: " + e);
		}
		return result;
	
	}
	
	public void copyFilesToUserDir(String fileType,String nino) throws IOException{
		List<String> commandList = new ArrayList<String>();
		Calendar cal = Calendar.getInstance();
		System.out.println("Creating directory");
		commandList.add("mkdir "+Property.getProperty("user.dir")+nino);
		commandList.add("chmod 777 "+Property.getProperty("user.dir")+nino);
		System.out.println("Executing command");
		if(!"UC_DHUB".equals(fileType)){
			System.out.println("sudo -u jbeap /bin/cp /var/middleware/uc-evidence-batch/io/archive/"+getFileName(fileType, nino) +" "+Property.getProperty("user.dir")+nino+"/"+getFileName(fileType, nino));
			commandList.add("sudo -u jbeap /bin/cp /var/middleware/uc-evidence-batch/io/archive/"+getFileName(fileType, nino) +" "+Property.getProperty("user.dir")+nino+"/"+getFileName(fileType, nino));
		}else{
			System.out.println("sudo -u jbeap /bin/cp /ftran/uc/pending/internal/"+getFileName(fileType, null) +" "+Property.getProperty("user.dir")+nino+"/"+getFileName(fileType, nino));
			commandList.add("sudo -u jbeap /bin/cp /ftran/uc/pending/internal/"+getFileName(fileType, null) +" "+Property.getProperty("user.dir")+nino+"/"+getFileName(fileType, nino));
//			commandList.add("sudo -u jbeap /bin/cp /var/middleware/uc-evidence-batch/io/archive/"+getFileName(fileType, nino) +" "+Property.getProperty("user.dir")+nino+"/"+getFileName(fileType, nino));
		}
		executeCommandList(commandList);
		System.out.println("Done execution!!!Files copied to /home/nchaudha/ap1_output/"+nino+"/");
		commandList.clear();
		if(!"UC_DHUB".equals(fileType)){
			commandList.add("sudo -u jbeap /bin/rm /var/middleware/uc-evidence-batch/io/archive/"+getFileName(fileType, nino));
		}else{
			commandList.add("sudo -u jbeap /bin/rm /var/middleware/uc-evidence-batch/io/archive/"+getFileName(fileType, null));
			commandList.add("sudo -u jbeap /bin/rm /ftran/uc/pending/internal/"+getFileName(fileType, null));
		}
		executeCommandList(commandList);
		System.out.println("Removed all files!!!");
	}
	
	public void removeFiles(){
		List<String> commandList = new ArrayList<String>();
		commandList.add("sudo -u jbeap /bin/rm /ftran/uc/pending/internal/*.*");
		commandList.add("sudo -u jbeap /bin/rm /var/middleware/uc-evidence-batch/io/archive/*.*");
		executeCommandList(commandList);
	}
	
	private String getFileName(String fileType,String nino){  //always pass nino as null for original file
		List<String> result = new ArrayList<String>();
		List<String> commandList = new ArrayList<String>();
		commandList.add("date +%Y-%m-%d");
		result = executeCommandList(commandList);
		System.out.println("Date:"+result.get(0));
		String[] dates = result.get(0).split("-");
		String fileName = fileType+"_"+dates[0]+dates[1]+dates[2]+"_1";
		if(nino != null)
			fileName += "_"+nino;
		if("UC_PBS".equals(fileType) || "UC_GUCE".equals(fileType))
			fileName += ".dat";
		else
			fileName += ".xml";
		return fileName;
	}
	
	public int executeCommand(String command){
		List<String> commandList = new ArrayList<String>();
		commandList.add(command);
		List<String> result = executeCommandList(commandList);
		return Integer.valueOf(result.get(result.size()-1));
	}
	
	public List<String> executeCommandList(List<String> commandList){
		List<String> result1 = new ArrayList<String>();
		try {
			Session session = connectionSessionToRemote(getUsername(), getPassword(), gethost02(), getport());
//			Session session = connectionSessionToRemote("nchaudha", "Nilstarz@12","rptltcuc3402.dwpptp.londondc.com", 22);
			result1 = executeCommands(commandList, session);
			int exitStatus = Integer.valueOf(result1.get(result1.size()-1));
			session.disconnect();
			if (exitStatus == -99) {
				throw new RuntimeException();
			}
			if (exitStatus < 0) {
				System.out.println("Done, but exit status not set!" + exitStatus);

			} else if (exitStatus > 0) {
				System.out.println("exit status" + exitStatus);

			} else {
				System.out.println("Done!");
			}
			return result1;
		} catch (IOException e) {
			e.printStackTrace();
			result1.add("-99");
			return result1;
		}
	}
	
	public List<String> executeCommandListStub(List<String> commandList){
		List<String> result1 = new ArrayList<String>();
		try {
			Session session = connectionSessionToRemote(getUsername(), getPassword(), getStubhost(), getport());
//			Session session = connectionSessionToRemote("nchaudha", "Nilstarz@12","rptltcuc3402.dwpptp.londondc.com", 22);
			result1 = executeCommands(commandList, session);
			int exitStatus = Integer.valueOf(result1.get(result1.size()-1));
			session.disconnect();
			if (exitStatus == -99) {
				throw new RuntimeException();
			}
			if (exitStatus < 0) {
				System.out.println("Done, but exit status not set!" + exitStatus);

			} else if (exitStatus > 0) {
				System.out.println("exit status" + exitStatus);

			} else {
				System.out.println("Done!");
			}
			return result1;
		} catch (IOException e) {
			e.printStackTrace();
			result1.add("-99");
			return result1;
		}
	}

	
	public void addOneMonthToPBSRecord(String claimId) throws ParseException{
		String assessmentStartDate = "";
		String assessmentEndDate = "";
		List<String> result = new ArrayList<String>();
		List<String> commandList = new ArrayList<String>();
		System.out.println(getFileName("UC_PBS", null));
		commandList.add("sed -n '/01|"+claimId+"/p' "+getFileName("UC_PBS", null));
		result = executeCommandList(commandList);
		commandList.clear();
		String pbsRecordArr[] = result.get(0).split("\\|");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		for(int i = pbsRecordArr.length-1 ; i >= 0; i--){
			if(pbsRecordArr[i].contains("-")){
				if("".equals(assessmentEndDate)){
					assessmentEndDate = pbsRecordArr[i];
				}else if("".equals(assessmentStartDate)){
					assessmentStartDate = pbsRecordArr[i];
					break;
				}
			}
		}
		Date date = df.parse(assessmentEndDate);
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DAY_OF_MONTH, 1);
		Date nextAssessmentStartDate = cal.getTime();
		String nextAssessmentStartDateStr = df.format(nextAssessmentStartDate);
		cal.add(Calendar.DAY_OF_MONTH, 30);
		Date nextAssessmentEndDate = cal.getTime();
		String nextAssessmentEndDateStr = df.format(nextAssessmentEndDate);
		cal.setTime(date);
		cal.add(Calendar.DAY_OF_MONTH, 7);
		Date waitingDay = cal.getTime();
		String waitingDayStr = df.format(waitingDay);
		String[] labels = {assessmentStartDate,assessmentEndDate,waitingDayStr,nextAssessmentStartDateStr,nextAssessmentEndDateStr};
		int count = 0;
		for(int i=0 ; i<pbsRecordArr.length;i++){
			if(pbsRecordArr[i].contains("-")){
				pbsRecordArr[i]=labels[count];
				count++;
			}
		}
		String newRecord = String.join("|", pbsRecordArr);
		System.out.println(newRecord);
		commandList.add("sed -i '/01|"+claimId+"/c"+"\\"+newRecord+"||' "+getFileName("UC_PBS", null));
		executeCommandList(commandList);
		System.out.println("Completed");
	}
	
	public List<String> executeSysDateUpdateBatch(String scriptFileName, String sysDD, String sysMM, String sysYYYY) {
		List<String> result = new ArrayList<String>();
		String sysDatetsx = sysMM+"/"+sysDD+"/"+sysYYYY;
		String sysDatetDB = sysYYYY+"-"+sysMM+"-"+sysDD;
//		System.out.println("System Date - "+sysDatetsx);
//		System.out.println("System Date DB - "+sysDatetDB);
//		System.out.println("tsx set -u jboss jbeap "+sysDatetsx);
//		System.out.println("sudo -u oracle /export/home/oracle/tsx_db.ksh UCDB31 "+sysDatetDB);
		try {

			Session session = connectionSessionToRemote(getUsername(), getPassword(), gethost02(), getport());
			// create the execution channel over the session

			List<String> commandsList = new ArrayList<String>();
//			Thread.sleep(4000);
			// accessing through sh file
			// commandsList.add("cd /home/nchaudha");
			// commandsList.add("sh "+"sysDate.sh");
			// System.out.println("Updating System Date");
			
			
			System.out.println("tsx set -u jboss jbeap "+getUsername()+" "+sysDatetsx);
			commandsList.add("tsx set -u jboss jbeap "+getUsername()+" "+sysDatetsx); // (mm/dd/yyyy)
			System.out.println("tsx date");
			System.out.println("sudo -u oracle /export/home/oracle/tsx_db.ksh "+Property.getProperty("SID")+" "+sysDatetDB);
			commandsList.add("sudo -u oracle /export/home/oracle/tsx_db.ksh "+Property.getProperty("SID")+" "+sysDatetDB); // (yyyy-dd-mm)
			System.out.println("db date");

			List<String> result1 = executeCommands(commandsList, session);
			int exitStatus = Integer.valueOf(result1.get(result1.size()-1));
			session.disconnect();
			if (exitStatus == -99) {
				throw new RuntimeException();
			}
			if (exitStatus < 0) {
				System.out.println("Done, but exit status not set!" + exitStatus);

			} else if (exitStatus > 0) {
				System.out.println("exit status" + exitStatus);

			} else {
				System.out.println("Done!");
			}

		} catch (Exception e) {
			System.err.println("Error: " + e);
		}

		try {

			Session session = connectionSessionToRemote(getUsername(), getPassword(), gethost01(), getport());
			// create the execution channel over the session

			List<String> commandsList = new ArrayList<String>();
//			Thread.sleep(4000);
			// accessing through sh file
			// commandsList.add("cd /home/nchaudha");
			// commandsList.add("sh "+"sysDate.sh");
			// System.out.println("Updating System Date");
			System.out.println("tsx set -u jboss jbeap "+getUsername()+" "+sysDatetsx);
			commandsList.add("tsx set -u jboss jbeap "+getUsername()+" "+sysDatetsx); // (mm/dd/yyyy)
			System.out.println("tsx date");

			List<String> result1 = executeCommands(commandsList, session);
			int exitStatus = Integer.valueOf(result1.get(result1.size()-1));
			session.disconnect();
			if (exitStatus == -99) {
				throw new RuntimeException();
			}
			if (exitStatus < 0) {
				System.out.println("Done, but exit status not set!" + exitStatus);

			} else if (exitStatus > 0) {
				System.out.println("exit status" + exitStatus);

			} else {
				System.out.println("Done!");
			}

		} catch (Exception e) {
			System.err.println("Error: " + e);
		}
		return result;
	}

	public List<String> executeVerificationBatch(String scriptFileName) {
		List<String> result = new ArrayList<String>();
		try {

			Session session = connectionSessionToRemote(getUsername(), getPassword(), gethost02(), getport());
			// create the execution channel over the session

			List<String> commandsList = new ArrayList<String>();
//			Thread.sleep(4000);
			// accessing through sh file
			// commandsList.add("cd /home/nchaudha");
			// commandsList.add("sh "+"verificationBatch.sh");
			// System.out.println("Running Batch 37 and batch 34");

			commandsList.add("sudo -u jbeap /opt/uc/bin/ucevidencebatch.sh DWP_UC_EVD_037_MarkVerification >> test.log");
			System.out.println("BATCH 037");
//			Thread.sleep(4000);

			commandsList.add("sudo -u jbeap /opt/uc/bin/ucevidencebatch.sh DWP_UC_EVD_034_DetermineVerification >> test.log");
			System.out.println("BATCH 034");
//			Thread.sleep(4000);

			List<String> result1 = executeCommands(commandsList, session);
			int exitStatus = Integer.valueOf(result1.get(result1.size()-1));
			session.disconnect();
			if (exitStatus == -99) {
				logger.info("Verification batch's failed with exit status"+ exitStatus);
				throw new RuntimeException();
			}
			if (exitStatus < 0) {
				System.out.println("Done, but exit status not set!" + exitStatus);
				logger.info("Verification batch Done, but exit status not set!" + exitStatus );

			} else if (exitStatus > 0) {
				System.out.println("exit status" + exitStatus);
				logger.info("Verification batch Done, but exit status" + exitStatus );

			} else {
				System.out.println("Done!");
				logger.info("Verification batch Successful");
			}

		} catch (Exception e) {
			System.err.println("Error: " + e);
		}
		return result;
	}

	public List<String> executeDV1(String scriptFileName) {
		List<String> result = new ArrayList<String>();
		try {

			Session session = connectionSessionToRemote(getUsername(), getPassword(), gethost02(), getport());
			// create the execution channel over the session

			List<String> commandsList = new ArrayList<String>();
//			Thread.sleep(4000);
			// accessing through sh file
			// commandsList.add("cd /home/nchaudha");
			// commandsList.add("sh "+"verificationBatch.sh");
			System.out.println("Inside Batch 34");

			commandsList.add("sudo -u jbeap /opt/uc/bin/ucevidencebatch.sh DWP_UC_EVD_034_DetermineVerification >> test.log");
			System.out.println("Determine Verification BATCH 034");
//			Thread.sleep(4000);

			List<String> result1 = executeCommands(commandsList, session);
			int exitStatus = Integer.valueOf(result1.get(result1.size()-1));
			session.disconnect();
			if (exitStatus == -99) {
				logger.info("DV batch failed");
				throw new RuntimeException();
			}
			if (exitStatus < 0) {
				System.out.println("Done, but exit status not set!" + exitStatus);
				logger.info("DV done, but exit status not set!" + exitStatus );
				

			} else if (exitStatus > 0) {
				System.out.println("exit status" + exitStatus);
				logger.info("DV done, but with exit status" + exitStatus );

			} else {
				System.out.println("Done!");
				logger.info("DV sucessful");
			}

		} catch (Exception e) {
			System.err.println("Error: " + e);
		}
		return result;
	}
	
	public List<String> executePA(String scriptFileName) {
		List<String> result = new ArrayList<String>();
		try {

			Session session = connectionSessionToRemote(getUsername(), getPassword(), gethost02(), getport());
			// create the execution channel over the session

			List<String> commandsList = new ArrayList<String>();
//			Thread.sleep(4000);
			// accessing through sh file
			// commandsList.add("cd /home/nchaudha");
			// commandsList.add("sh "+"verificationBatch.sh");
			 System.out.println("Inside BATCH 007");

			commandsList.add("sudo -u jbeap /opt/uc/bin/ucevidencebatch.sh DWP_UC_EVD_007_performAssessment >> test.log");
			System.out.println("Performance Assessment BATCH 007");
//			Thread.sleep(4000);

			List<String> result1 = executeCommands(commandsList, session);
			int exitStatus = Integer.valueOf(result1.get(result1.size()-1));
			session.disconnect();
			if (exitStatus == -99) {
				logger.info("PA failed");
				throw new RuntimeException();
				}
			if (exitStatus < 0) {
				System.out.println("Done, but exit status not set!" + exitStatus);
				logger.info("PA done, but exit status not set!" + exitStatus);

			} else if (exitStatus > 0) {
				System.out.println("exit status" + exitStatus);
				logger.info("PA done, but with exit status:" + exitStatus);

			} else {
				System.out.println("Done!");
				logger.info("PA successful");
			}

		} catch (Exception e) {
			System.err.println("Error: " + e);
		}
		return result;
	}
	
	public List<String> executeGUCE(String scriptFileName) {
		List<String> result = new ArrayList<String>();
		try {

			Session session = connectionSessionToRemote(getUsername(), getPassword(), gethost02(), getport());
			// create the execution channel over the session

			List<String> commandsList = new ArrayList<String>();
//			Thread.sleep(4000);
			// accessing through sh file
			// commandsList.add("cd /home/nchaudha");
			// commandsList.add("sh "+"verificationBatch.sh");
			System.out.println("Inside Batch 008");
			commandsList.add("sudo -u jbeap /opt/uc/bin/ucevidencebatch.sh DWP_UC_EVD_008_extractUCEntitlement >> test.log");
			System.out.println("GUCE BATCH 008");
//			Thread.sleep(4000);

			List<String> result1 = executeCommands(commandsList, session);
			int exitStatus = Integer.valueOf(result1.get(result1.size()-1));
			session.disconnect();
			if (exitStatus == -99) {
				logger.info("EVD 8 failed");
				throw new RuntimeException();
			}
			if (exitStatus < 0) {
				System.out.println("Done, but exit status not set!" + exitStatus);
				logger.info("EVD 8 Done, but exit status not set!" + exitStatus);

			} else if (exitStatus > 0) {
				System.out.println("exit status" + exitStatus);
				logger.info("EVD 8 Done, but with exit status:" + exitStatus);

			} else {
				System.out.println("Done!");
				logger.info("EVD 8 successful");
			}

		} catch (Exception e) {
			System.err.println("Error: " + e);
		}
		return result;
	}
	
	public boolean addPaymentSpecialEntryInPBS(String filePath,String commandArgs) throws InterruptedException{
		String nino = "";
		try {
			Session session = connectionSessionToRemote(getUsername(), getPassword(), gethost02(), getport());
			List<String> commandsList = new ArrayList<String>();
			commandsList.add("cd "+Property.getProperty("home"));
			System.out.println("PBS FilePath:"+filePath);
			System.out.println("sh add_payment_special_data.sh "+commandArgs+" "+filePath);
			commandsList.add("sh add_payment_special_data.sh "+commandArgs+" "+filePath);
			System.out.println("Done calling add_payment_special_data");
			System.out.println("Copying PBS File");
			System.out.println("Copying Successful!");
			List<String> result1 = executeCommands(commandsList, session);
			int exitStatus = Integer.valueOf(result1.get(result1.size()-1));
			nino = commandArgs.split(" ")[1];
			session.disconnect();
			if (exitStatus == -99) {
				throw new RuntimeException();
			}
			if (exitStatus < 0) {
				System.out.println("Done, but exit status not set!" + exitStatus);

			} else if (exitStatus > 0) {
				System.out.println("exit status" + exitStatus);

			} else {
				System.out.println("Done!");
			}
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			copyPBSFileToRecd(nino);
		}
		return false;
	}
	
	public void copyPBSFileToRecd(String nino) throws InterruptedException{
		//nino = "AC813528C";
		try {
			Session session = connectionSessionToRemote(getUsername(), getPassword(), gethost02(), getport());
			List<String> commandsList = new ArrayList<String>();
			Calendar cal = Calendar.getInstance();
//			 System.out.println("sudo -u jbeap /bin/cp "+Property.getProperty("home")+getFileName("UC_PBS", null)+" /ftran/uc/received/internal/"+getFileName("UC_PBS",nino));
//			 commandsList.add("sudo -u jbeap /bin/cp "+Property.getProperty("home")+getFileName("UC_PBS", null)+" /ftran/uc/received/internal/"+getFileName("UC_PBS",nino));
//			 commandsList.add("rm -rf "+Property.getProperty("home")+getFileName("UC_PBS", null));
			commandsList.add("cp "+Property.getProperty("home")+getFileName("UC_PBS", null)+" "+Property.getProperty("homeArch"));		//copy PBSFile to G drive archive folder
			 System.out.println("sudo -u jbeap /bin/cp "+Property.getProperty("home")+getFileName("UC_PBS", null)+" /ftran/uc/received/internal/");
			 commandsList.add("sudo -u jbeap /bin/cp "+Property.getProperty("home")+getFileName("UC_PBS", null)+" /ftran/uc/received/internal/");
			 commandsList.add("rm -rf "+Property.getProperty("home")+getFileName("UC_PBS", null));
			 List<String> result1 = executeCommands(commandsList, session);
			int exitStatus = Integer.valueOf(result1.get(result1.size()-1));
			 System.out.println("Successful Copy!Now sleep");
				session.disconnect();
//				Thread.sleep(20000);
				if (exitStatus == -99) {
					throw new RuntimeException();
				}
				if (exitStatus < 0) {
					System.out.println("Done, but exit status not set!" + exitStatus);

				} else if (exitStatus > 0) {
					System.out.println("exit status" + exitStatus);

				} else {
					System.out.println("Done!");
				}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<String> executeRemovePBSRecords(String anotherString) {
		List<String> result = new ArrayList<String>();
		try {
			Session session = connectionSessionToRemote(getUsername(), getPassword(), gethost02(), getport());
			List<String> commandsList = new ArrayList<String>();
			 commandsList.add("cd "+Property.getProperty("home"));	
			 commandsList.add("sh removeUnmatch.sh "+claimID+" "+getFileName("UC_PBS",null));
			List<String> result1 = executeCommands(commandsList, session);
			int exitStatus = Integer.valueOf(result1.get(result1.size()-1));
			session.disconnect();
			if (exitStatus == -99) {
				throw new RuntimeException();
			}
			if (exitStatus < 0) {
				System.out.println("Done, but exit status not set!" + exitStatus);

			} else if (exitStatus > 0) {
				System.out.println("exit status" + exitStatus);

			} else {
				System.out.println("Done!");
			}

		} catch (Exception e) {
			System.err.println("Error: " + e);
		}
		return result;
	}
	
	public List<String> executePBSFile(String scriptFileName) {
		List<String> result = new ArrayList<String>();
		try {

			Session session = connectionSessionToRemote(getUsername(), getPassword(), gethost02(), getport());
			// create the execution channel over the session
			List<String> commandsList = new ArrayList<String>();
//			Thread.sleep(4000);
			// accessing through sh file
			 commandsList.add("cd "+Property.getProperty("home"));
			 commandsList.add("sh createPBSFile.sh");
			 System.out.println("executing createPBS");
			 System.out.println("Executed CreatePBSFileFile");
//			 Thread.sleep(4000);

			List<String> result1 = executeCommands(commandsList, session);
			int exitStatus = Integer.valueOf(result1.get(result1.size()-1));
			session.disconnect();
			if (exitStatus == -99) {
				throw new RuntimeException();
			}
			if (exitStatus < 0) {
				System.out.println("Done, but exit status not set!" + exitStatus);

			} else if (exitStatus > 0) {
				System.out.println("exit status" + exitStatus);

			} else {
				System.out.println("Done!");
			}

		} catch (Exception e) {
			System.err.println("Error: " + e);
		}
		return result;
	}

	private Session connectionSessionToRemote(String username, String password, String host, int port)
			throws IOException {
		Session session;

		try {
			session = jsch.getSession(username, host, port);
			session.setConfig("StrictHostKeyChecking", "no");
			session.setPassword(password);
			session.connect();
			return session;
		} catch (JSchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	private List<String> executeCommands(List<String> commandsList, Session session) throws IOException {
		List<String> result = new ArrayList<String>();
		String commands = "";
		ChannelExec channelExec = null;
		try {
			channelExec = (ChannelExec) session.openChannel("exec");

		} catch (JSchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result.add("-99");
			return result;
		}
		for (String command : commandsList) {
			commands += command + ";";
		}
		channelExec.setCommand(commands);
		try {
			channelExec.connect();
			InputStream in = channelExec.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			String line;
			while ((line = reader.readLine()) != null) {
				result.add(line);
			}
//			int exitStatus = channelExec.getExitStatus();
			result.add(String.valueOf(channelExec.getExitStatus()));
			channelExec.disconnect();
			return result;
		} catch (JSchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			channelExec.disconnect();
			result.add("-99");
			return result;
		}
	}
	
	public boolean copyFileFromRemote(String sourceDirectory,String fileName,String destinationDirectory,String destinationFileName,String host){
		Session session = null;
		try {
			session = connectionSessionToRemote(getUsername(), getPassword(), host, getport());
			ChannelSftp channel = null;
			channel = (ChannelSftp) session.openChannel("sftp");
			channel.connect();
			System.out.println("Source Directory:"+sourceDirectory);
			channel.cd(sourceDirectory);
			byte[] buffer = new byte[1024];
			System.out.println("Filename:"+fileName);
			BufferedInputStream bis = new BufferedInputStream(channel.get(fileName));
			File file = new File(destinationDirectory+destinationFileName);
			OutputStream os = new FileOutputStream(file);
			BufferedOutputStream bos = new BufferedOutputStream(os);
			int readCount;
			while((readCount = bis.read(buffer)) > 0){
				System.out.println("Writing to:"+destinationDirectory+destinationFileName);
				bos.write(buffer,0,readCount);
			}
			bis.close();
			bos.close();
			channel.disconnect();
			session.disconnect();
		} catch (IOException e) {
			e.printStackTrace();
			session.disconnect();
		} catch (JSchException e) {
			e.printStackTrace();
			session.disconnect();
		} catch (SftpException e) {
			e.printStackTrace();
			session.disconnect();
		}
		return false;
	}
	
	public void copyFileFromRemoteHost(String sourceDirectory,String fileName,String destinationDirectory,String destinationFileName,String hostName) throws IOException{
		String host="";
		if(hostName.equalsIgnoreCase("host01"))
			host=gethost01();
		else
			host=gethost02();
		copyFileFromRemote(sourceDirectory,fileName,destinationDirectory,destinationFileName,host);
	}
	
	public static void main(String...args){
		Batches.getInstance().copyFileToRemote("/home/nchaudha/", "test", "/home/nchaudha/", "test");
	}
	
	public boolean copyFileToRemote(String sourceDirectory,String fileName,String destinationDirectory,String destinationFileName){
		Session session = null;
		try {
			session = connectionSessionToRemote(getUsername(), getPassword(), gethost02(), getport());
			ChannelSftp channel = null;
			channel = (ChannelSftp) session.openChannel("sftp");
			channel.connect();
			System.out.println("Source Directory:"+destinationDirectory);
			channel.cd(sourceDirectory);
			File f = new File(sourceDirectory+fileName);
			channel.put(new FileInputStream(f), destinationFileName);
			channel.exit();
			channel.disconnect();
		} catch (IOException e) {
			e.printStackTrace();
			session.disconnect();
		} catch (JSchException e) {
			e.printStackTrace();
			session.disconnect();
		} catch (SftpException e) {
			e.printStackTrace();
			session.disconnect();
		}
		return false;
	}

		
}
