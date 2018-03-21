package problem2;

public class MyClass {
   private int val1,val2;
   public void myFun(int x,int y)
   {
	   val1=x;
	   val2=y;
	   int sum=val1+val2;
	   System.out.println("The sum of "+val1+" and "+val2+" is: "+sum);
	  
   }
   public static void main(String[] args) {
	MyClass MyObj=new MyClass();
	MyObj.myFun(1, 2);
}
}
