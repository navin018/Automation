package selenium;

import java.sql.*;


//import com.acn.uc.cukes.dataobjects.LoginInfoDO;
//import com.acn.uc.cukes.testobjects.AgentLogin;
//
//import uk.ndc.csa.utilities.general.DataManager;
//import static uk.ndc.csa.utilities.selenium.SeleniumDSL.getText;

public class CheckDatabase {
	
	public static void database() {
		
		
/***** below commented code to get the sql query from specified location of file********/
//		String aSQLScriptFilePath = "D:\\SeleniumUC\\SQLQuery.sql";
//		System.out.println(aSQLScriptFilePath);
		
		
//		try {
//		// Create MySql Connection
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@rptltcdb09:1521:UCDB31","UC_EVIDENCE_CURRENT31","UC_EVIDENCE_CURRENT31");
//				System.out.println(con);
//				Statement stmt = con.createStatement();
//				System.out.println(stmt);
//
//					// Initialize object for ScripRunner
//					ScriptRunner sr = new ScriptRunner(con);
//
//					// Give the input file to Reader
//					Reader reader = new BufferedReader(new FileReader(aSQLScriptFilePath));
//
//					// Exctute script
//					sr.runScript(reader);
//
//				} catch (Exception e) {
//					System.err.println("Failed to Execute" + aSQLScriptFilePath	+ " The error is " + e.getMessage());
//				}
				
		
		
		
/************ Below code uses preparedStatement to execute a SQL query ********/
		
//		AgentLogin login = new AgentLogin();		
//		login.NINO(testcase);
//		System.out.println("testcase" + testcase);
//		
		
		try {
			// load driver class
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// create connection object
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@rptltcdb09:1521:UCDB31",
					"UC_EVIDENCE_CURRENT31", "UC_EVIDENCE_CURRENT31");
			System.out.println(con);

			// create the statement object
			Statement state = con.createStatement();
			System.out.println(state);

			System.out.println("Testing");
			
			String sql = "UPDATE AWARD_PROCESSING_FLAGS SET marked_for_process_yn = 'Y' \n"
				    + "WHERE award_process_type  = '2' \n"
				    + "AND AWARD_ID in \n"
				    + "(SELECT aw.award_id FROM CLAIM clm \n"
				    + "INNER JOIN AWARD aw ON aw.claim_id = clm.claim_id \n"
				    + "INNER JOIN AWARD_MEMBER awmem ON awmem.award_id = aw.award_id \n"
				    + "INNER JOIN HOUSEHOLD_MEMBER hhmem ON hhmem.hh_member_id = awmem.hh_member_id \n"
				    + "INNER JOIN PERSON p ON p.person_id = hhmem.person_id \n"
				    + "INNER JOIN JOURNEY j ON j.award_id = aw.award_id \n"
				    + "WHERE aw.award_id IN \n"
				    + "(SELECT DISTINCT aw.award_id FROM CLAIM clm \n"
				    + "INNER JOIN AWARD aw ON aw.claim_id = clm.claim_id \n"
				    + "INNER JOIN AWARD_MEMBER awmem ON awmem.award_id = aw.award_id \n"
				    + "INNER JOIN HOUSEHOLD_MEMBER hhmem ON hhmem.hh_member_id = awmem.hh_member_id \n"
				    + "INNER JOIN PERSON p ON p.person_id = hhmem.person_id WHERE p.nino   = ? " 
					+ "))" ;
				   
			System.out.println(sql);			
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "AC758415C");			 
			int rs = pstmt.executeUpdate();
			System.out.println("Updated successfully");
			con.commit();
			System.out.println("Committed successfully");
			
			try {
				if ((con != null) && (!con.isClosed())) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
