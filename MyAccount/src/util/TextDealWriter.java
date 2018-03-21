package util;

import java.io.*;


public class TextDealWriter {
	
	
	public static void main(String[] args) {
		try {
			
			DataInputStream instr = new DataInputStream( new BufferedInputStream(
	                               new FileInputStream("deal.dat")));
			FileOutputStream dest=new FileOutputStream("dealreport.txt");
			int c;
	        while ((c=instr.read())!=-1) {
	            System.out.write(c);
	        	dest.write(c);}
	        instr.close();
	        dest.close();
		}
		catch ( IOException iox ){
				iox.printStackTrace();   }

	}
	
}

