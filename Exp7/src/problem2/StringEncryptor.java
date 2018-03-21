package problem2;

import java.util.HashMap;

public class StringEncryptor {
	
		public static char getKey(HashMap<Character,Character> map,char value){  
		    char key = 0;
		    for(char getKey: map.keySet()){  
		        if(map.get(getKey).equals(value))
		          key = getKey;  
		      }  
		         return key;  
		           
		    }  
	
	   //编码方式
		public static String encode1(String word)
		{
			String source="abcdefghijklmnopqrstuvwxyz ";
			String target="veknohzf iljxdmygbrcswqupta"; 
			StringBuffer resulte=new StringBuffer();
			char[] arraySource=source.toCharArray();
			char[] arrayTarget=target.toCharArray();
			char[] start=word.toCharArray();
			HashMap<Character,Character> encoding = new HashMap<Character,Character>();  
			for (int i = 0; i < source.length(); i++)          
				  encoding.put(arrayTarget[i], arraySource[i]);
			for (int i = 0; i < word.length(); i++)
				resulte.append(getKey(encoding,start[i]));
			String result=resulte.toString();
			return result;
		}
		
		//解码方式
		public static String decode1(String code)
		{
		String source="abcdefghijklmnopqrstuvwxyz ";
		String target="veknohzf iljxdmygbrcswqupta"; 
		StringBuffer resulte=new StringBuffer();
		char[] arraySource=source.toCharArray();
		char[] arrayTarget=target.toCharArray();
		char[] start=code.toCharArray();
		HashMap<Character,Character> decoding = new HashMap<Character,Character>();  
		for (int i = 0; i < source.length(); i++)          
			  decoding.put(arraySource[i], arrayTarget[i]);
		for (int i = 0; i < code.length(); i++)
			resulte.append(getKey(decoding,start[i]));
		String result=resulte.toString();
		return result;
		}


public static void main(String[] args) {
//	  Scanner sc=new Scanner(System.in);  //可以自己输入任意字符串进行测试
//	  String str=null;
//	  System.out.print("请输入原始信息:");
//	  str=sc.nextLine();
//       sc.close();
	  String str="we will break out of prison at dawn";
	  System.out.println("\n原始信息：\t\t"+str);
	  System.out.println("加密后的字符串(方法一)：\t"+encode1(str));
	  System.out.println("解密后的字符串(方法一)：\t"+decode1(encode1(str)));
	 
}


}
