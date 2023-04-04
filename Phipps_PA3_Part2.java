//Brian Phipps
//Part2: take a 2x2 matrix from a txt file
//find eigenvalues and eigenvectors of matrix
//create a new matrix with these values

import java.util.Scanner;
import java.util.*;
import java.io.*;
import java.io.IOException;

public class Phipps_PA3_Part2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		File file = new File ("matrix.txt");
		
		Scanner scanner = new Scanner (file);
		
		PrintWriter writer = new PrintWriter("output2.txt");
		
		
		//fill matrix with values from file
		int matrix[][] = new int[2][3];
		
		for (int row =0; row < matrix.length; row ++) {
			
			for ( int col = 0; col < matrix[0].length; col ++) {
				
				if (scanner.hasNextInt()) {
					matrix[row][col] = scanner.nextInt();
				}
				
			}//end of inner for
		}//end of outer for
		
		int matA[][] = new int[2][2];//create matrix A
		matA[0][0] = matrix[0][0];//fill matrix A with corresponding values
		matA[0][1] = matrix[0][1];
		matA[1][0] = matrix[1][0];
		matA[1][1] = matrix[1][1];
		
		
		//calculate eigenvalues
		double eigenvalues[] = EigenValues(matA);
		System.out.printf("Eigen vals: %.4f \t %.4f", eigenvalues[0], eigenvalues[1]);
		
		double eigenVectors[][] = new double[2][2];
		eigenVectors = EigenVectors(matA, eigenvalues);
		
		System.out.println("\nMatrix A:");
		displayMatrix(matA);
		System.out.println();
		
		
		
//		System.out.println("\nEigenVectors: ");
//		displayMatrix(eigenVectors);
		
		//displays part 1 matrix Λ
		System.out.println("Matrix Λ: ");
		System.out.println(eigenvalues[0] + "\t" + matA[0][1]);
		System.out.println(matA[1][0] + "\t" + eigenvalues[1]);
		double matrixV[][] = new double[2][2];
		matrixV[0][0] = eigenvalues[0];
		matrixV[0][1] = matA[0][1];
		matrixV[1][0] = matA[1][0];
		matrixV[1][1] = eigenvalues[1];
		System.out.println();
		
		//displays part 2 matrix R of eigen vectors
		System.out.println("Matrix R: ");
		displayMatrix(eigenVectors);
		System.out.println();
		
		
		//displays RΛRT
		double RART[][] = matrixMultiplication(eigenVectors, matrixV);
		System.out.println("Matrix RΛRT: ");
		displayMatrix(RART);
		
		
		
		
		
		
		
		
		
		
		
		scanner.close();
		
	}//end of main
	
	public static void displayMatrix(int matrix[][]) {
		
		for (int i =0; i < matrix.length; i ++) {
			System.out.println();
			
			for (int j = 0; j < matrix[0].length; j++) {
				
				System.out.print(matrix[i][j] + "\t");
			}
		}
		
	}//end of display matrix
	
public static void displayMatrix(double matrix[][]) {
		
		for (int i =0; i < matrix.length; i ++) {
			System.out.println();
			
			for (int j = 0; j < matrix[0].length; j++) {
				
				System.out.printf("%.4f \t", matrix[i][j]);
			}
		}
		
	}//end of display matrix
	
	
public static double[] EigenValues (int matrix[][]) { //copied from my PA2 Part 4
		
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
		
		
		//returns the two eigenvalues as an array
		double eigenArray[] = {val1,val2};
		return eigenArray;
		
		
	}//end of EigenValues



public static double[][] EigenVectors ( int matrix[][], double[] eigenvalues) { //copied from my PA2 part 4
	
	double returnMatrix[][] = new double[2][2];
	
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
		//System.out.println ( " Eigenvector1: " + eigenV1[0][0] + " " + eigenV1[1][0]);
		returnMatrix[0][0] = eigenV1[0][0];
		returnMatrix[1][0] = eigenV1[1][0];
		
	}else {
		double eigenV1[][] = new double [2][1];
		eigenV1[1][0] = 1;
		eigenV1[0][0] = newMatrix[0][1] / newMatrix[0][0];
		//System.out.println ( " Eigenvector1: " + eigenV1[0][0] + " " + eigenV1[1][0]);
		returnMatrix[0][0] = eigenV1[0][0];
		returnMatrix[1][0] = eigenV1[1][0];
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
		
		//System.out.println ("Eigenvector2 : " + eigenV2[0][0] + " " + eigenV2[1][0]);
		returnMatrix[0][1] = eigenV2[0][0];
		returnMatrix[1][1] = eigenV2[1][0];
	}else {
		
		double eigenV2[][] = new double [2][1];
		eigenV2[1][0] = 1;
		eigenV2[0][0] = newMatrix[0][1] / newMatrix[0][0];
		//System.out.println ("Eigenvector2 : " + eigenV2[0][0] + " " + eigenV2[1][0]);
		returnMatrix[0][1] = eigenV2[0][0];
		returnMatrix[1][1] = eigenV2[1][0];
		
	}//end of else
	
	return returnMatrix;
}//end of function Eigen vectors

public static double[][] matrixMultiplication(double matrixR[][], double matrix[][]) {
	
	double matRTranspose[][] = Transpose(matrixR);
	
	double newMatrix[][] = new double [matrix.length][matrix[0].length];
	
	newMatrix[0][0] = (matrixR[0][0] * matrix[0][0]) + (matrixR[0][1] * matrix[1][0]);
	newMatrix[0][1] = (matrixR[0][0] * matrix[0][1]) + (matrixR[0][1] * matrix[1][1]);
	newMatrix[1][0] = (matrixR[1][0] * matrix[0][0]) + (matrixR[1][1] * matrix[1][0]);
	newMatrix[1][1] = (matrixR[1][0] * matrix[0][1]) + (matrixR[1][1] * matrix[1][1]);
	
	newMatrix[0][0] = (newMatrix[0][0] * matRTranspose[0][0]) + (newMatrix[0][1] * matRTranspose[1][0]);
	newMatrix[0][1] = (newMatrix[0][0] * matRTranspose[0][1]) + (newMatrix[0][1] * matRTranspose[1][1]);
	newMatrix[1][0] = (newMatrix[1][0] * matRTranspose[0][0]) + (newMatrix[1][1] * matRTranspose[1][0]);
	newMatrix[1][1] = (newMatrix[1][0] * matRTranspose[0][1]) + (newMatrix[1][1] * matRTranspose[1][1]);
	
	return newMatrix;
	
	
	
}

public static double[][] Transpose(double matrix[][]){
	
	double Tmatrix[][] = new double[matrix[0].length][matrix.length];
	
	for (int row = 0; row < matrix.length; row++) {
		
		for (int col = 0; col < matrix[0].length; col++) {
			
		Tmatrix[col][row] = matrix[row][col];
			
		}
		
	}
	
	return matrix;
}

}//end of class
