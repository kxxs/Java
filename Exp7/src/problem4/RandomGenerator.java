package problem4;

import java.util.Random;
import java.util.TreeSet;


public class RandomGenerator {
		public static void main(String[] args) {
			int[] array=new int[80];
			Random rand = new Random();
			TreeSet<Integer> ts=new TreeSet<Integer>();
			
			for (int i = 0; i < 80; i++) {   
	            array[i]=rand.nextInt(100);
	            ts.add(array[i]);
		       }
			
			System.out.println("一共生成了"+ts.size()+"个不同的数：");
			int[] result= new int[ts.size()];  
		    for(int i=0;i<result.length;i++)  
		    {  
		        //从TreeSet中取出元素重新赋给数组  
		        result[i]=ts.pollFirst(); 
		        System.out.println(result[i]);
		    }  
		}
}
