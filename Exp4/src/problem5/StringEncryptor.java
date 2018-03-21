package problem5;

import java.util.Random;
import java.util.Scanner;

public class StringEncryptor {
	public static Random randomno = new Random(); //生成随机数
	
	//第一种编码方式
	public static String encode1(String word)
	{
		String source="abcdefghijklmnopqrstuvwxyz ";
		String target="veknohzf iljxdmygbrcswqupta"; 
		StringBuffer resulte=new StringBuffer();
		char[] arraySource=source.toCharArray();
		char[] arrayTarget=target.toCharArray();
		for (int i = 0; i < word.length(); i++) {           
			  for(int j=0; j<source.length();j++) {
				  if (word.charAt(i)==arraySource[j])
					  resulte.append(arrayTarget[j]);
			  }
		  }
		String result=resulte.toString();
		return result;
	}
	
	//第一种解码方式
	public static String decode1(String code)
	{
	String source="abcdefghijklmnopqrstuvwxyz ";
	String target="veknohzf iljxdmygbrcswqupta"; 
	StringBuffer resulte=new StringBuffer();
	char[] arraySource=source.toCharArray();
	char[] arrayTarget=target.toCharArray();
	for (int i = 0; i < code.length(); i++) {           
		  for(int j=0; j<source.length();j++) {
			  if (code.charAt(i)==arrayTarget[j])
				  resulte.append(arraySource[j]);
		  }
	  }
	String result=resulte.toString();
	return result;}

	//第二种编码方式,设已有字符（非空格）的ASCII数值为x,
	//生成的随机数为rand(0或1)，则目标字符ASCII:y=(x-96)*(rand+1)+58;
	//空格ASCII值比较特殊，单独判断，加密为110+rand
	public static String encode2(String word)
	{ randomno.setSeed(1);
	  int wordLength=word.length();
	  StringBuffer resulte=new StringBuffer();
	  int[] target=new int[wordLength];
	  
	  for(int i=0;i<wordLength;i++)
	  { if(!Character.isWhitespace(word.charAt(i)))
		  target[i]=((Integer.parseInt(Integer.toHexString(word.charAt(i)), 16))-96)
			  *(randomno.nextInt(2)+1)+58; 	
	    else target[i]=110+randomno.nextInt(10);    	          
        resulte.append((char)target[i]);
	  }
	  return resulte.toString();
	}
	
	//第二种解码方式:x=(y-58)/(rand+1)+96
	//空格单独判断
	public static String decode2(String code)
	{ randomno.setSeed(1);
	  int codeLength=code.length();
	  StringBuffer resulte=new StringBuffer();
	  int[] target=new int[codeLength];
	  
	  for(int i=0;i<codeLength;i++)
	  { if((Integer.parseInt(Integer.toHexString(code.charAt(i)),16)>110))
	            {  target[i]=32;
	  		       randomno.nextInt(10);}
	  	else target[i]=((Integer.parseInt(Integer.toHexString(code.charAt(i)), 16))-58)
	   			  /(randomno.nextInt(2)+1)+96;
	    resulte.append((char)target[i]);
	  }
	  return resulte.toString();
	}
	
    public static void main(String[] args) {
//    	  Scanner sc=new Scanner(System.in);  //可以自己输入任意字符串进行测试
//    	  String str=null;
//    	  System.out.print("请输入原始信息:");
//    	  str=sc.nextLine();
//  	       sc.close();
    	  String str="we will break out of prison at dawn";
    	  System.out.println("\n原始信息：\t\t"+str);
    	  System.out.println("加密后的字符串(方法一)：\t"+encode1(str));
    	  System.out.println("加密后的字符串(方法二）：\t"+encode2(str));
    	  System.out.println("解密后的字符串(方法一)：\t"+decode1(encode1(str)));
    	  System.out.println("解密后的字符串(方法二）：\t"+decode2(encode2(str)));
	}
    
    
}
