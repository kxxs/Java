package patest;

import java.util.Scanner;

public class Ex1001 {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in); 
    int n=  Integer.parseInt(sc.nextLine()); 
    int pace=0;
    while(n>1) {
    	n=((n%2==0)?(n/2):(3*n+1)/2);
    	pace++;
    }
    System.out.println(pace);
    sc.close();
}

}
