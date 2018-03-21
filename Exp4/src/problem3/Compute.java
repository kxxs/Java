package problem3;
import java.util.Date;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.text.SimpleDateFormat;
import java.lang.Math;


public class Compute {

	 public static long output(double[] array) {
			 double x=Math.sqrt(Math.pow(array[2], array[3]));
			 if(Double.isNaN(x))
			 {
				 System.err.println("输入的数字不合适");
				 return -1;
			 }
			 else { 
				long y=Math.round(Math.sin(array[0])*Math.cos(array[1])*x);
			 	SimpleDateFormat time=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			 	System.out.println("输出:\n"+time.format(new Date())+"\nresult="+y);
			 	return y;
			 }
	 }
	 
	 public static void main(String[] args) {
		    double[] array=new double[4];
		    try {
		    	System.out.println("请输入4个小数,格式为:\"a;b;c;d\"") ;
		    	Scanner scanner = new Scanner(System.in);
		    	if(scanner.hasNextLine()) 
		    		{
			    	String str=scanner.nextLine();
		            StringTokenizer st=new StringTokenizer(str,";");	        
		            for (int i=0; i<4; i++) 
		            	array[i] = Double.parseDouble(st.nextToken());
		            scanner.close();
		    		}
		    	output(array);
		    }
		    catch (Exception e)
				{e.printStackTrace();}
	     }

}
