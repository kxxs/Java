package problem2;

public class ComplexNumber {
	double real = 0;
	double imagine = 0;
	public ComplexNumber(double real, double imagine) {
		this.real = real;
		this.imagine = imagine; } 
	public ComplexNumber minus(ComplexNumber operand) { 
		return new ComplexNumber(this.real - operand.real, this.imagine - operand.imagine);
	}
	public boolean equals (ComplexNumber compared)
	{   if ( compared == null || compared.getClass() != this.getClass() )
			return false; 
		if ((this.real-compared.real<0.0001)&&(this.imagine-compared.imagine<0.0001))
			return true;
		else return false;
	}
	
	public static void main(String[] args) {
	ComplexNumber complex1 = new ComplexNumber(2.02d, 3.1d);
	ComplexNumber complex2 = new ComplexNumber(2d, 3d);
	ComplexNumber complex3 = complex2;
	ComplexNumber complex4 = new ComplexNumber(2d, 3d);
	ComplexNumber complex5 = new ComplexNumber(0.02d, 0.1d);
	ComplexNumber complex6 = complex1.minus(complex2);
	System.out.println(complex2 == complex3);
	System.out.println(complex2.equals(complex3));
	System.out.println(complex2.equals(complex4));
	System.out.println(complex6.equals(complex5));
	System.out.println(complex1.equals(null));
	System.out.println(complex1.equals(new String("abc")));

    }
}
