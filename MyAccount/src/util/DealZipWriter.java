package util;

import java.io.*;
import java.util.zip.*;

public class DealZipWriter {
	public static void main(String[] args) throws IOException {
	     ZipOutputStream out=new ZipOutputStream(new BufferedOutputStream(new FileOutputStream("deal.zip")));   
	     String[] srcfile=new String[2];
	     srcfile[0]="deal.dat";
	     srcfile[1]="dealreport.txt";
	     for(int i = 0; i < 2; i++) {
	         System.out.println("Writing file " + srcfile[i]);
	         BufferedInputStream in =new BufferedInputStream(new FileInputStream(srcfile[i]));
	         out.putNextEntry(new ZipEntry(srcfile[i])); 
	         int c;
	         while((c=in.read())!=-1)  out.write(c); 
	         in.close();
	      }
	      out.close(); 

	}
}
