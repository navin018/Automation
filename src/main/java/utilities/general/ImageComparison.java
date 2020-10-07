package utilities.general;

import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageComparison {

	/** 
	 * perform simple byte by byte comparison of two screenshot images 
	 */	
	public static Boolean compare(File fileExpected, File fileActual) throws IOException {
	      
		BufferedImage bufileActual = ImageIO.read(fileActual);
		BufferedImage bufileExpected = ImageIO.read(fileExpected);
		   
		DataBuffer dafileActual = bufileActual.getData().getDataBuffer();
		DataBuffer dafileExpected = bufileExpected.getData().getDataBuffer();

		int sizefileActual = dafileActual.getSize();                     
		   
		Boolean matchFlag = true;
		
		for(int j=0; j<sizefileActual; j++) 
		   {
			   if(dafileActual.getElem(j) != dafileExpected.getElem(j)) 
			   {
				   matchFlag = false;
				   break;
			   }
		   }
		
		return matchFlag;
		}

	
}
