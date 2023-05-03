
import java.util.Scanner;
import java.util.*;
import java.io.*;
import java.io.File;
import java.io.IOException;
public class Phipps_PA4_Part3 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		File file = new File ("input_p4.txt");
		Scanner input = new Scanner(file);
		PrintWriter writer = new PrintWriter ("output_PA4_part3.txt");
		
		//create and fill matrix from input file
		double matrix[][] = new double[3][3];
		for (int i =0; i < matrix.length; i++) {
			
			for (int j =0; j < matrix[i].length; j++) {
				matrix[i][j] = input.nextDouble();
			}
		}
		
		//checks to see if any numbers in matrix are negative
		for (int i =0; i < matrix.length; i++) {
			for (int j =0; j < matrix[i].length; j++) {
				if (matrix[i][j] == -1) {
					System.out.println("Invalid input");
					writer.println("Invalid input.");
				}
			}
		}
		//checks if matrix is stochastic or not
		boolean isStochastic = Stochastic(matrix);
		if (isStochastic == false) {
			System.out.println("Invalid input");
			writer.println("Invalid input");
		}else {
			double[] eigenvector = new double[matrix.length];
			eigenvector = Eigenvector(matrix, 0.01);
			writer.println("Webpage eigenvector: ");
			for (int i =0; i < eigenvector.length; i ++) {
				writer.print(eigenvector[i] + "  ");
			}
			writer.println();
			writer.println("Webpage with the highest ranking: ");
			
			//finds the webpage with highest ranking
			double webpage = 0;
			double index = 0;
			for (int i=0; i < eigenvector.length; i ++) {
				if (eigenvector[i] > webpage) {
					webpage = eigenvector[i];
					index = i;
				}
			}
			writer.println("Page: " + index);
			writer.println("With a value of: " + webpage);
			
		}//end of else
		
		input.close();
		writer.close();
	}//end of main
	
	public static boolean Stochastic (double[][] matrix) {
		
		for (int i =0; i < matrix.length; i++) {
			double sum = 0;
			for (int j = 0; j < matrix[i].length; j++) {
				sum += matrix[i][j];
			}
			if ( sum != 1) {
				return false;
			}
		}
		return true;
	}//end of stochastic func
	
	public static double[] Eigenvector (double[][] matrix, double tolerance)throws IOException {
		//This function finds the eigenvector r for the stochastic matrix that is
		//passed to the function
		PrintWriter writer = new PrintWriter ("output_part4.txt")
;		double r[] = new double [matrix.length];
		double rPrev[] = new double [ matrix.length];
		double eigenvalue = 0;
		
		for (int i =0; i < matrix.length; i++) {
			r[i] = Math.random();
		}
		normalize(r);
		
		//iterates until convergence
		while (true) {
			//saves previous r
			System.arraycopy(r, 0, rPrev, 0, matrix.length);
			
			multiply(matrix, r, r);
			eigenvalue = dotProduct(rPrev, r);
			normalize(r);
			
			//checks for convergence
			double normDiff = norm(subtract(r, rPrev));
			if (normDiff < tolerance) {
				break;
			}
		}
		//writer.println("Domainant Eigenvalue: " + eigenvalue);
		writer.close();
		return r;
		
		
	}//end of Eigenvector function
	
	public static void multiply (double[][] matrix, double[] vector, double[] result) {
		for (int i =0; i < matrix.length; i++) {
			double sum = 0;
			for (int j = 0; j < matrix.length; j++) {
				sum += matrix[i][j] * vector [j];
			}
			result[i] = sum;
		}
	}//end of multiply
	
	public static double dotProduct (double[] vector1, double[] vector2) {
		
		double result = 0;
		for (int i =0; i < vector1.length; i++) {
			result += vector1[i] * vector2[i];
		}
		return result;
	
	}//end of dotProduct function
	
	public static double[] subtract (double[] vector1, double[] vector2) {
		double[] result = new double [vector1.length];
		for (int i =0; i < vector1.length; i++) {
			result[i] = vector1[i] - vector2[i];
		}
		return result;
		
		
	}//end of subtract function
	public static void normalize(double[] vector) {
		double norm = norm(vector);
		for(int i=0; i < vector.length; i++) {
			vector[i]/= norm;
		}
		
		
	}//end of normalize func
	
	public static double norm (double[] vector) {
		double sum = 0;
		for (double v : vector) {
			sum += v*v;
		}
		return Math.sqrt(sum);
	}//end of norm function

}//end of class
