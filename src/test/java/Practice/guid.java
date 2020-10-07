package Practice;

import java.io.IOException;
import java.util.UUID;

import com.fasterxml.uuid.Generators;

import utilities.general.Property;

public class guid {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
//		UUID uuid1 = Generators.timeBasedGenerator().generate();
//		System.out.println(uuid1);
//		 String mywizURL = Property.getProperty("MyWizard_URL");
//		 mywizURL = mywizURL.replace("mywizard", "mywizardapi");
//		String Flat_url = mywizURL+"/v1/WorkItems/Query/flat?clientUId="+Property.getProperty("ClientUId")+"&deliveryConstructUId="+Property.getProperty("DeliveryConstructUId_L1")+"&includeCompleteHierarchy=false";
//		String WorkItemOrDeliverableOrIteration;
		
//		String Flat_url1 = mywizURL+"/v1/"+WorkItems+"/Query/flat?clientUId="+Property.getProperty("ClientUId")+"&deliveryConstructUId="+Property.getProperty("DeliveryConstructUId_L1")+"&includeCompleteHierarchy=false";
		 String mywizURL = Property.getProperty("MyWizard_URL");
		 String[] mywizURL_Sp = mywizURL.split(".com");
		 System.out.println(mywizURL_Sp[0]+".com/core");
	}

}
