package problem3;
import java.util.Random;
import  java.text.DecimalFormat;

public class RandomGenerator {
	static int[] array=new int[20];
	static int total=0;
	static String[] Compare=new String[20];
	static float[] average=new float[20];
	static String[] AveCompare=new String[20]; 
	
	public static void main(String[] args) {
		DecimalFormat df = new   java.text.DecimalFormat("0.0");  
		Random random = new Random();   
		System.out.println("[Value]     [G/l than Prev]    [Avg.]"
				+ "        [G/L than Avg.]");
		System.out.println("------------------------------------------"
				+ "-----------------");
	    for (int i = 0; i < 20; i++) {   
	            array[i]=random.nextInt(100);  
	            total=total+array[i];
	            average[i]=total/(float)(i+1);
	            
	            if(i==0)
	            	Compare[i]="---";
	            else if (array[i]>array[i-1])
	            	Compare[i]="Greater";
	            else if (array[i]==array[i-1])
	            	Compare[i]="Equal";
	            else Compare[i]="Less";
	    
	            if (array[i]>average[i])
	            	AveCompare[i]="Greater";
	            else if (array[i]==average[i])
	            	AveCompare[i]="Equal";
	            else AveCompare[i]="Less";
	            
	            System.out.println("  "+array[i]+"\t\t"+Compare[i]+"\t\t"
	            		+df.format(average[i])+"\t\t"+AveCompare[i]);
	}
	
    }   
}
