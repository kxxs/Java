package problem1;

public class Fraction {
		int nume;    //·Ö×Ó
		int demo;    //·ÖÄ¸
		public Fraction(int nume,int demo)
		{
		this.nume=nume;
		this.demo=demo;
		}
		public String toString()
		 {
		    int x,i;
		    if (nume>demo)
		    	x=nume;
		    else x=demo;
		    
		    for(i=x;i>0;i--)
		    {
		    	if((nume%i==0)&&(demo%i==0))
		    	{
		    		nume=nume/i;
		    		demo=demo/i;
		    	}
		    }
		    return nume+"/"+demo;
		 }
	     public void add(Fraction A)
	     {   int d1=this.demo*A.demo;
	         int n1=this.nume*A.demo+this.demo*A.nume;
	    	 this.demo=d1;
	    	 this.nume=n1;
	     }
	     public void substract(Fraction A)
	     {
	    	 int d1 = this.demo*A.demo;
	    	 int n1=this.nume*A.demo-this.demo*A.nume;
	    	 this.demo=d1;
	    	 this.nume=n1;
	     }
	     public void multiple(Fraction A)
	     {
	    	 int d1=this.demo*A.demo;
	    	 int n1=this.nume*A.nume;
	    	 this.demo=d1;
	    	 this.nume=n1;
	     }
	     public void division(Fraction A)
	     {
	    	 int d1=this.demo*A.nume;
	    	 int n1=this.nume*A.demo;
	    	 this.demo=d1;
	    	 this.nume=n1;
	     }
	     public static Fraction add(Fraction A,Fraction B)
	     {   int d=A.demo*B.demo;
	    	 int n=B.nume*A.demo+B.demo*A.nume;
	    	 return new Fraction(n,d);}
	     public static Fraction substract(Fraction A,Fraction B)
	     {   int d=A.demo*B.demo;
	    	 int n=A.nume*B.demo-A.demo*B.nume;
	    	 return new Fraction(n,d);}
	     public static Fraction multiple(Fraction A,Fraction B)
	     {   int d=A.demo*B.demo;
	    	 int n=B.nume*A.nume;
	    	 return new Fraction(n,d);}
	     public static Fraction division(Fraction A,Fraction B)
	     {   int d=A.demo*B.nume;
	    	 int n=B.demo*A.nume;
	    	 return new Fraction(n,d);}
         public static void main(String[] args) {
			Fraction example1=new Fraction(6,8);
			System.out.println("example1="+ example1);
		}
}


