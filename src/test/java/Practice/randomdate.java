package Practice;

import java.util.Random;

public class randomdate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int randomYear = new Random().nextInt(2)+2023;
				String randomMonth = String.valueOf(new Random().nextInt(12)+1);
				String randomDay = String.valueOf(new Random().nextInt(28)+1);
				String sDate = randomYear+"-"+String.format("%02d", Integer.valueOf(randomMonth))+"-"+String.format("%02d", Integer.valueOf(randomDay))+"T18:48:07.6972433";
				System.out.println(sDate);
				
//				System.out.println(String.format("%02d", 5));
//				System.out.println(String.format("%02d", Integer.valueOf(randomMonth)));
	}

}
