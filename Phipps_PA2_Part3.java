//Brian Phipps
//Programming assign. 2 part 3
//finding the linear map that maps a source triangle to a target triangle
//user will input values for source triangle

import java.util.Scanner;

public class Phipps_PA2_Part3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input = new Scanner(System.in);
		
		//gather input values for the source and target triangle
		System.out.println("Enter 6 values for source triangle: ");
		
		double x1 = input.nextDouble(); //source triangle values
		double y1 = input.nextDouble();
		double x2 = input.nextDouble();
		double y2 = input.nextDouble();
		double x3 = input.nextDouble();
		double y3 = input.nextDouble();
		
		
		System.out.println("Enter 6 values for target triangle: ");
		
		double x1prime = input.nextDouble(); //target triangle values
		double y1prime = input.nextDouble();
		double x2prime  = input.nextDouble();
		double y2prime = input.nextDouble();
		double x3prime = input.nextDouble();
		double y3prime = input.nextDouble();
		
		
		
		//calculate V and V'
		double V[][] = new double[2][2];
		V[0][0] = x2 - x1;
		V[1][0] = y2 - y1;
		V[0][1] = x3 - x1;
		V[1][1] = y3 - y1;
		
		double Vprime[][] = new double [2][2];
		Vprime[0][0] = x2prime - x1prime;
		Vprime[1][0] = y2prime - y1prime;
		Vprime[0][1] = x3prime - x1prime;
		Vprime[1][1] = y3prime - y1prime;
		
		//calculate the inverse of V
		double Vinverse[][] = new double[2][2];
		double a = Vprime[0][0];
		double b = Vprime[0][1];
		double c = Vprime[1][0];
		double d = Vprime[1][1];
		
		double coeff = 1/((a*d) - (b*c));
		
		Vinverse[0][0] = coeff * d;
		Vinverse[0][1] = coeff * (-b);
		Vinverse[1][0] = coeff * (-c);
		Vinverse[1][1] = coeff * a;
		
		//calculate linear map
		double A[][] = new double [2][2];
		A[0][0] = (Vprime[0][0] * Vinverse[0][0]) + (Vprime[0][1] * Vinverse[1][0]);
		A[0][1] = (Vprime[0][0] * Vinverse[0][1]) + (Vprime[0][1] * Vinverse[1][1]);
		A[1][0] = (Vprime[1][0] * Vinverse[0][0]) + (Vprime[1][1] * Vinverse[1][0]);
		A[1][1] = (Vprime[1][0] * Vinverse[0][1]) + (Vprime[1][1] * Vinverse[1][1]);
		
		
		
		//Display calculated linear map
		System.out.println("Calculated linear map A: ");
		System.out.print(A[0][0] + "\t" + A[0][1] + "\n");
		System.out.print(A[1][0] + "\t" + A[1][1]);
		
		
		
		
	}//end of main

}//end class
