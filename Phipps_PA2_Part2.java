//Brian Phipps
//Program assignment 2 part2
//user inputs values for a 2x2 matrix. The program will determine if an inverse exists. If it does, the inverse is calculated

import java.util.Scanner;

public class Phipps_PA2_Part2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input = new Scanner(System.in);
		
		//gather values for the 2x2 matrix
		System.out.println("Enter 4 values for a 2x2 matrix: ");
		double matrix[][] = new double [2][2];
		matrix[0][0] = input.nextDouble();
		matrix[0][1] = input.nextDouble();
		matrix[1][0] = input.nextDouble();
		matrix[1][1] = input.nextDouble();
		
		//calculate determinate of 2x2 matrix
		double determinate = (matrix[0][0] * matrix[1][1]) - (matrix[0][1] * matrix[1][0]);
		
		//if determinate equals 0, there is no inverse of the matrix.
		
		if (determinate == 0) {
			System.out.println("An inverse of the matrix does not exist.");
			
		}else {
			//otherwise, calulcate the inverse of the matrix
			
			double inverse[][] = new double [2][2];
			
			inverse[0][0] = matrix[1][1] / determinate;
			inverse[0][1] = -matrix[0][1] / determinate;
			inverse[1][0] = -matrix[1][0] / determinate;
			inverse[1][1] = matrix[0][0] / determinate;
			
			System.out.println("Inverted matrix: ");
			System.out.print(inverse[0][0] + "\t" + inverse[0][1] + "\n");
			System.out.print(inverse[1][0] + "\t" + inverse[1][1]);
			
			
		}
		
		
	}//end of main

}//end of class
