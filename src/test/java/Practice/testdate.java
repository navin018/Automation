package Practice;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.junit.Assert;



public class testdate {

	public static void main(String[] args) throws ParseException {

		String date_s = "1/dec/2020";
		String comparewith = "2020-12-02";
		Date date = new SimpleDateFormat("d/MMM/yyyy").parse(date_s);
	
		SimpleDateFormat sdfDestination = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(sdfDestination.format(date).toString());
		Assert.assertEquals(comparewith,sdfDestination.format(date).toString());
		

	}

}
