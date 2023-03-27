//Brian Phipps
//Part One: Reads in a 2x3 matrix from a file
//First two cols  (2x2) is A, last col (2x1) is b
//Solves for x in Ax = b

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Arrays;
import java.util.*;
import java.io.*;


public class Phipps_PA3_Part1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		int matrix[][] = new int [2][3];
		
		File file = new File ("matrix.txt");
		
		Scanner readFromFile = new Scanner (file);
		
		
		//reads in values from txt file "matrix"
		for (int row = 0; row < matrix.length; row ++) {
			
			for (int col = 0; col < matrix[0].length; col ++) {
				
				if (readFromFile.hasNextInt()) {
					
					matrix[row][col] = readFromFile.nextInt();
				}//end of if
			}//end of inner for
		}//end of outer for
		
		
		int matA[][] = new int [2][2]; //define matrix A as a 2x2 matrix
		int matB[][] = new int [2][1];
		
		//fill matrix A with values.
		matA[0][0] = matrix[0][0];
		matA[0][1] = matrix[0][1];
		matA[1][0] = matrix[1][0];
		matA[1][1] = matrix[1][1];
		
		//fill matrix B with values.
		matB[0][0] = matrix[0][2];
		matB[1][0] = matrix[1][2];
		
		//display matrices so user can confirm values are correct
		System.out.println("OG matrix: ");
		displayMatrix(matrix);
		
		System.out.println("\nMatrix A: ");
		displayMatrix(matA);
		
		System.out.println("\nMatrix B: ");
		displayMatrix(matB);
		
		PrintWriter writer = new PrintWriter("output.txt");
		
		// solve for matrix X
        double[][] matX = new double[2][1];
        int detA = (matA[0][0] * matA[1][1]) - (matA[0][1] * matA[1][0]);//find determinate
        
        if (detA != 0) { //check to see if matrix A is invertible. If it is, it solves for matrix X
           matX[0][0] = (matB[0][0] * matA[1][1] - matB[1][0] * matA[0][1]) / detA; //multiply B with the inverse of A
           matX[1][0] = (matB[1][0] * matA[0][0] - matB[0][0] * matA[1][0]) / detA;
           
           //displays X only if x is solvable.
           System.out.println("\nMatrix x = ");
           displayMatrix(matX);
           
           writer.println("Solved matrix x: ");
           writer.println(matX[0][0] + "\n" + matX[1][0]);
           
        } else {
            System.out.println("Matrix A is not invertible. System inconsistent/undetermined");
           
        }
        
       
        
		
		readFromFile.close();
		writer.close();
	}//end of main
	
	public static void displayMatrix (int matrix[][]) {
		
		for (int i = 0; i < matrix.length; i ++) {
			System.out.println();
			for (int j =0; j < matrix[0].length; j ++) {
				System.out.print(matrix[i][j] + "\t");
				
			}
		}
	}
	
	//method overload
public static void displayMatrix (double matrix[][]) {
		
		for (int i = 0; i < matrix.length; i ++) {
			System.out.println();
			for (int j =0; j < matrix[0].length; j ++) {
				System.out.print(matrix[i][j] + "\t");
				
			}
		}
	}
	

}//end of class
