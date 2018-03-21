package problem1;

public class FractionTester {
public static void main(String[] args) {
	Fraction A=new Fraction(4,6);
	Fraction B=new Fraction(3,8);
	
	Fraction C=Fraction.add(A,B);
	Fraction D=Fraction.substract(A,B);
	Fraction E=Fraction.multiple(A,B);
	Fraction F=Fraction.division(A,B);
	System.out.println(A+"+"+B+"="+C);
	System.out.println(A+"-"+B+"="+D);
	System.out.println(A+"*"+B+"="+E);
	System.out.println("("+A+")/"+"("+B+")="+F);
	
	System.out.println("E="+E+",A="+A);
	E.add(A);
	System.out.println("after E.add(A),E="+E);
	E.substract(A);
	System.out.println("after E.substract(A),E="+E);
	E.multiple(A);
	System.out.println("after E.multiple(A),E="+E);
	E.division(A);
	System.out.println("after E.division(A),E="+E);
}
}
