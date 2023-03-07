//Brian Phipps
//Part 4 of Prgramming assignment 2
//find the eigenvalues and eigenvectors of a 2x2 matrix


import java.util.Arrays;
import java.util.Scanner;

public class Phipps_PA2_Part4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
//declare a 2x2 matrix
	double matrix[][] = new double [2][2];
	
	Scanner input = new Scanner (System.in);
	
	
	
	//Asks user to input values for the 2x2 matrix, and assigns input values to the 2x2 array
	//Displays inputted matrix to verify input values are correct
	
	System.out.println("enter values for matrix a11: ");
	matrix[0][0] = input.nextDouble();
	
	System.out.println("enter values for matrix a12: ");
	matrix[0][1] = input.nextDouble();
	
	System.out.println("enter values for matrix a21: ");
	matrix[1][0] = input.nextDouble();
	
	System.out.println("enter values for matrix a22: ");
	matrix[1][1] = input.nextDouble();
	
	
	System.out.println("Inputted values:");
	for (int i =0; i < matrix.length; i++) {
		
		System.out.println();
		for (int j = 0; j < matrix[i].length; j++) {
			System.out.print(matrix[i][j] + " ");
		}
	}
	System.out.println();
		
	//runs a function to calculate the eigenvalues of the matrix
	//matrix is passed to function
	double eigenValues[] = EigenValues(matrix);
	System.out.println();
	//runs a function to calculate the eigenvectors of the matrix
	//passes the matrix and the calculated eigenvalues
	EigenVectors(matrix, eigenValues);
	
	
		
		
	}//end of main
	
	
	
	
	//function that determines the eigenvalues of a 2x2 matrix
	
	public static double[] EigenValues (double matrix[][]) {
		
		//eigenvalues declared
		double val1 = 0;
		double val2 = 0;
		
		//calucates the determinat of matrix A and finds corresponding values that complete the quadratic equation
		double determinant = (matrix[0][0] - matrix [1][1]);
		double squareroot = Math.pow(matrix[0][0], 2) - 4 * (matrix[0][0] * matrix[1][1] - matrix[1][0] * matrix[0][1]);
		val1 = (matrix[0][0] + matrix[1][1] + Math.sqrt(squareroot)) / 2;
		val2 = (matrix[0][0] + matrix[1][1] - Math.sqrt(squareroot)) / 2;
		
		
		//determine the dominant eigenvalue by utilizing absolute value
		
		if (Math.abs(val2) > Math.abs(val1)) {
			//swaps eigenvalues so that eigenvalue1 is always dominant
			double temp = val1;
			val1 = val2;
			val2 = temp;
		}
		
		//displays eigenvalues
		System.out.println("First eigenvalue (dominant): " + val1);
		System.out.println("Second eigenvalue: " + val2);
		
		//returns the two eigenvalues as an array
		double eigenArray[] = {val1,val2};
		return eigenArray;
		
		
	}//end of EigenValues
	
	
	
	
	
	
	
	
	public static void EigenVectors ( double matrix[][], double[] eigenvalues) {
		
		double val1 = eigenvalues[0];
		double val2 = eigenvalues[1];
		
		//create a new matrix A-lambdaI
		double newMatrix[][] = new double [2][2];
		newMatrix[0][0] = matrix[0][0] - val1;
		newMatrix[0][1] = matrix[0][1];
		newMatrix[1][0] = matrix[1][0];
		newMatrix[1][1] = matrix[1][1] - val1;
		
		//check to see if matrix is upper triangular or not
		
		if (newMatrix[1][0] != 0 ) {
			//apply a shear to get matrix into upper triangular form
			double shear[][]=new double[2][2];
			shear[0][0] = 1;
			shear[0][1] = 0;
			shear[1][0] = (-(matrix[1][0]) / matrix[0][0]); // -v2/v1
			shear[1][1] = 1;
			
			//create new matrix, which will be the result of shear * matrix
			double shearedMatrix[][] = new double[2][2];
			shearedMatrix[0][0] = (shear[0][0] * newMatrix[0][0]) + (shear[0][1] * newMatrix [1][0]);
			shearedMatrix[0][1] = (shear[0][0] * newMatrix[0][1]) + (shear[0][1] * newMatrix[1][1]);
			shearedMatrix[1][0] = (shear[1][0] * newMatrix[0][0]) + (shear[1][1] * newMatrix[1][0]);
			shearedMatrix[1][1] = (shear[1][0] * newMatrix[0][1]) + (shear[1][1] * newMatrix[1][1]);
			
			
			//create eigenvector 1
			double eigenV1[][] = new double [2][1];
			eigenV1[1][0] = 1;
			eigenV1[0][0] = shearedMatrix[0][1] / shearedMatrix[0][0];
			System.out.println ( " Eigenvector1: " + eigenV1[0][0] + " " + eigenV1[1][0]);
		}else {
			double eigenV1[][] = new double [2][1];
			eigenV1[1][0] = 1;
			eigenV1[0][0] = newMatrix[0][1] / newMatrix[0][0];
			System.out.println ( " Eigenvector1: " + eigenV1[0][0] + " " + eigenV1[1][0]);
		}
		
		
		double newMatrix2[][] = new double[2][2];
		newMatrix2[0][0] = matrix[0][0] - val2;
		newMatrix2[0][1] = matrix[0][1];
		newMatrix2[1][0] = matrix[1][0];
		newMatrix2[1][1] = matrix[1][1] -val2;
		
		if (newMatrix2[1][0] != 0 ) {
			//apply a shear to get matrix into upper triangular form
			double shear[][]=new double[2][2];
			shear[0][0] = 1;
			shear[0][1] = 0;
			shear[1][0] = (-(matrix[1][0]) / matrix[0][0]); // -v2/v1
			shear[1][1] = 1;
			
			//create new matrix, which will be the result of shear * matrix
			double shearedMatrix[][] = new double[2][2];
			shearedMatrix[0][0] = (shear[0][0] * newMatrix2[0][0]) + (shear[0][1] * newMatrix2[1][0]);
			shearedMatrix[0][1] = (shear[0][0] * newMatrix2[0][1]) + (shear[0][1] * newMatrix2[1][1]);
			shearedMatrix[1][0] = (shear[1][0] * newMatrix2[0][0]) + (shear[1][1] * newMatrix2[1][0]);
			shearedMatrix[1][1] = (shear[1][0] * newMatrix2[0][1]) + (shear[1][1] * newMatrix2[1][1]);
			
			
			//create eigenvector 1
			double eigenV2[][] = new double [2][1];
			eigenV2[1][0] = 1;
			eigenV2[0][0] = shearedMatrix[0][1] / shearedMatrix[0][0];
			
			System.out.println ("Eigenvector2 : " + eigenV2[0][0] + " " + eigenV2[1][0]);
		}else {
			double eigenV2[][] = new double [2][1];
			eigenV2[1][0] = 1;
			eigenV2[0][0] = newMatrix[0][1] / newMatrix[0][0];
			System.out.println ("Eigenvector2 : " + eigenV2[0][0] + " " + eigenV2[1][0]);
			
		}
		
	}
	

}//end of class
