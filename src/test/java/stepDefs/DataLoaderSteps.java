package stepDefs;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import testobjects.DataLoader;
import uiMap.MyWizardUIMap;

import static org.testng.Assert.assertTrue;
import static utilities.selenium.SeleniumDSL.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Random;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class DataLoaderSteps {
	
	
	@Then("^i upload file for \"([^\"]*)\" DataLoader$")
	public void i_upload_file_for_DataLoader(String dataload_type)  {
		DataLoader.SelectEntitiyType(dataload_type);
		DataLoader.UploadFile(dataload_type);
	}
	
	@Then("^i prepare the excel data for \"([^\"]*)\" DataLoader$")
	public void i_prepare_the_excel_data_for_DataLoader_on_environment(String dataload_type) throws Throwable {
	
		 DataLoader.prepareExcelFilePathtoBeUploaded(dataload_type);
		}
		
	
}
