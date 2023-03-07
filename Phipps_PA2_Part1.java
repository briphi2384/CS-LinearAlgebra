//Brian Phipps
//PA2 Part1
//This program converts between paramteric and implicit equations of a line. 
//The user is asked which line they will input, and asks the users to input the values
//The program then converts to the other equation of a line. 


import java.util.Scanner;
import java.util.Arrays;


public class Phipps_PA2_Part1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input = new Scanner(System.in);
		
		System.out.println("Which equation will you be inputting? ");
		System.out.println("Press (i) for implicit, or (p) for parametric: ");
		
		char choice = input.next().charAt(0); //gathers user input
		
		
		if(choice == 'i' || choice == 'I') {
			
			//gather input from user
			System.out.println("You chose implicit, which is of the form Ax1 + Bx2 + C = 0");
			System.out.println("Enter value for A: ");
			double A = input.nextDouble();
			System.out.println("Enter value for B: ");
			double B = input.nextDouble();
			System.out.println("Enter value for C: ");
			double C = input.nextDouble();
			
			//converts to parametric
			double P[][] = new double[2][1];
			P[0][0] = (-C)/A;
			P[1][0] = 0;
			
			double V[][] = new double[2][1];
			V[0][0] = B;
			V[1][0] = -A;
			
			//displays converted equation
			System.out.println("Converted parametric equation: ");
			System.out.println("l(t) = [" + P[0][0] + " " + P[1][0] + "] t[" + V[0][0] + " " + V[1][0] + "]");
			
			
		}else if(choice == 'p' || choice == 'P') {
			
			//gather input from user
			System.out.println("You chose parametric, which is of the form l(t) = p + tv");
			System.out.println ("Enter values for P: ");
			double P[][] = new double [2][1];
			P[0][0] = input.nextDouble();
			P[1][0] = input.nextDouble();
			
			System.out.println("Enter values for V: ");
			double V[][] = new double [2][1];
			V[0][0] = input.nextDouble();
			V[1][0] = input.nextDouble();
			
			//converts to implicit
			double A = -(V[1][0]);
			double B = V[0][0];
			double C = -((A*P[0][0]) + (B*P[1][0]));
			
			//displays converted equation
			System.out.println("Converted implicit equation: ");
			System.out.println(A + "x1 + " + B + "x2 + " + C +" = 0");
			
			
			
			
			
		}else {
			System.out.println("Not a valid entry, try again.");
		}
		
		
	
		
		
		
		
		
	}//end of main

}//end of class
