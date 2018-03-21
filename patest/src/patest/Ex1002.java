package patest;

import java.util.Scanner;

public class Ex1002 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
	    String str=sc.nextLine();
	    int i,sum=0;
	    for(i=0;i<str.length();i++)
	    	sum+=(str.charAt(i)-48);
	    String result=String.valueOf(sum);
	    StringBuffer output = new StringBuffer();
	    for(i=0;i<result.length();i++)
	    	switch(result.charAt(i)) {
	    	case '0':output.append("ling "); break;
	    	case '1':output.append("yi "); break;
	    	case '2':output.append("er "); break;
	    	case '3':output.append("san "); break;
	    	case '4':output.append("si "); break;
	    	case '5':output.append("wu "); break;
	    	case '6':output.append("liu "); break;
	    	case '7':output.append("qi "); break;
	    	case '8':output.append("ba "); break;
	    	case '9':output.append("jiu "); break;
	    	default:;
	    	}
	    output.deleteCharAt(output.length()-1);
	    System.out.println(output);
	    sc.close();
	}
}
