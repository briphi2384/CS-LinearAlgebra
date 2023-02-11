
// * Brian Phipps
// * Feb 7 2023
// * Programming Assignment 1
// * Working with matrices

import java.util.Arrays;
import java.util.Scanner;
import java.lang.Math;
import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.File;


public class Phipps_p1 {

	public static void main(String[] args) throws IOException {
		
		String firstName = "Brian";
		String lastName = "Phipps";
		int numFirstName = firstName.length();
		int numLastName = lastName.length();
		
		//Matrix 1 gets created, filled, and then displayed
		//First Name x First Name
		System.out.println("Matrix 1: Brian Brian 5x5 Matrix");
		int Mat1[][] = new int [numFirstName][numFirstName];
		Mat1 = fillMatrix1(Mat1);
		displayMatrix(Mat1);
		
		
		//Matrix 2 gets created, filled, and then displayed
		//First Name x Last Name
		System.out.println("Matrix 2: Brian Phipps 5x6 Matrix");
		int Mat2[][] = new int [numFirstName][numLastName];
		Mat2 = fillMatrix2(Mat2);
		displayMatrix(Mat2);
		
		
		//Matrix 3 gets created, filled, and then displayed
		//First Name x Last Name DOUBLES/FLOAT
		System.out.println("Matrix 3. Brian Phipps 5x6 Matrix");
		double Mat3[][] = new double[numFirstName][numLastName];
		Mat3 = fillMatrix3(Mat3);
		displayMatrix(Mat3);
		
		//Matrix 4 gets created, filled, and the displayed
		//4row x 6col
		System.out.println("Matrix 4: 4 rows, 6 columns");
		int Mat4[][] = new int[4][6]; //hardcoding....ewwww
		Mat4 = fillMatrix4(Mat4);
		displayMatrix(Mat4);
		
		
		//Matrix 5
		//4row x 6col
		System.out.println("Matrix 5: 4 rows, 6 columns");
		double Mat5[][] = new double[4][6];
		Mat5 = fillMatrix5(Mat5);
		displayMatrix(Mat5);
		
		
		//Matrix 6
		//2row x 4col
		System.out.println("Matrix 6: 2 rows, 4 columns");
		int Mat6[][] = new int[2][6];
		Mat6 = fillMatrix6(Mat6);
		displayMatrix(Mat6);
		
		
		//create files
		
		String mat1FileName = "Phipps_mat1.txt";
	
		
		printMatrixNicely(Mat1, mat1FileName);
		
		String mat2FileName = "Phipps_mat2.txt";
		printMatrixNicely(Mat2, mat2FileName);
		
		String mat3FileName = "Phipps_mat3.txt";
		printMatrixNicely(Mat3, mat3FileName);
		
		String mat4FileName = "Phipps_mat4.txt";
		printMatrixNicely(Mat4, mat4FileName);
		
		String mat5FileName = "Phipps_mat5.txt";
		printMatrixNicely(Mat5, mat5FileName);
		
		String mat6FileName = "Phipps_mat6.txt";
		printMatrixNicely(Mat6, mat6FileName);

//		
////		write matrices to files
//		String mat2FileName = "Phipps_mat2.txt";
//		WriteFile mat2File = new WriteFile (mat2FileName, true);
//		mat2File.writeToFile();
//		
//		String mat3FileName = "Phipps_mat3.txt";
//		WriteFile mat3File = new WriteFile (mat3FileName, true);
//		mat3File.writeToFile();
//		
//		String mat4FileName = "Phipps_mat4.txt";
//		WriteFile mat4File = new WriteFile (mat4FileName, true);
//		mat4File.writeToFile();
//		
//		String mat5FileName = "Phipps_mat5.txt";
//		WriteFile mat5File = new WriteFile (mat5FileName, true);
//		mat5File = writeToFile();
//		
//		String mat6FileName= "Phipps_mat6.txt";
//		WriteFile mat6File = new WriteFile (mat6FileName, true);
//		mat6File.writeToFile();
	}//end of main
	
	public static int[][] fillMatrix1 (int matI[][]) {
		
		int num = 1;
		
		for (int col = 0; col < matI[0].length; col++) {
			
			for (int row =0; row < matI.length; row++) {
				
				matI[row][col] = num;
				num++;
				
			}//end of inner for
			
		}//end of outer for
		
		return matI;
		
	}//end of fillMatrix
	
	
	
	public static void displayMatrix(int matrix[][]) {
		
		
		for (int i = 0 ; i < matrix.length; i++) {
		String m = "\n";
		System.out.print(m);
			for (int j = 0; j < matrix.length; j++) {
				
				 System.out.print(matrix[i][j] + "\t");
			}//end of inner for
			
		}//end of outer for
		System.out.println("\n");
	}//end of displayMatrix
public static void displayMatrix(double matrix[][]) {
		
		for (int i = 0 ; i < matrix.length; i++) {
			String m = "\n";
			System.out.print(m);
			for (int j = 0; j < matrix.length; j++) {
				
				System.out.printf("%.2f" + "\t",matrix[i][j]);
			}//end of inner for
			
		}//end of outer for
		System.out.println("\n");
	}//end of displayMatrix

public static void printMatrixNicely (double matrix[][], String filename) throws IOException {
	
	WriteFile writeToFile = new WriteFile (filename,true);
	
	for (int i=0; i < matrix.length; i++) {
		
		String m = "\n";
		writeToFile.writeToFile(m);
		
		for (int j=0; j < matrix[i].length; j++) {
			 m = "" + matrix[i][j] + "  ";
			 writeToFile.writeToFile(m);
			//return m;
		}
	}
	
	//return "";
	
}//end of print matrix
public static void printMatrixNicely (int matrix[][], String filename) throws IOException {
	
	WriteFile writeToFile = new WriteFile (filename,true);
	
	for (int i=0; i < matrix.length; i++) {
		
		String m = "\n";
		writeToFile.writeToFile(m);
		
		for (int j=0; j < matrix[i].length; j++) {
			 m = "" + matrix[i][j] + "  ";
			 writeToFile.writeToFile(m);
			//return m;
		}
	}
	//return "";
	
}//end of print matrix
	
	public static int[][] fillMatrix2 (int matrix[][]) {
		
		int num = 2;
		
		for (int col = 0; col< matrix.length; col++) {
			
			for (int row = 0; row < matrix[col].length; row++) {
				
				matrix[col][row] = num;
				num=num+3;
				
				
			}//inner for
		}//outer for
		return matrix;
		
	}//end of functin fillmatrix2
	
	public static double[][] fillMatrix3 (double matrix[][]){
		
		double num = 0.2;
		
		for (int col = 0; col < matrix[0].length; col++) {
			
			for (int row = 0; row < matrix.length; row++) {
				
				matrix[row][col] = num;
				num = num + 0.2;
				
			}//inner for
		}//outer for
		
		return matrix;
	}//end of fill matrix 3
	
	public static int[][] fillMatrix4 (int matrix[][]){
		
		int num = 10;
		
		for (int col = 0; col < matrix[0].length; col++) {
			
			for (int row =0; row < matrix.length; row++) {
				matrix[row][col] = num;
				num = num -2;
			}
		}//outer for
		
		return matrix;
	}//end of fill matrix 4
	
	public static double[][] fillMatrix5 (double matrix[][]){
		
		double num = -6;
		
		for (int row = 0; row < matrix.length; row ++) {
			
			for (int col = 0; col < matrix[row].length; col++) {
				
				matrix[row][col] = num;
				num = num + 1.5;
				
			}//inner for
		}//outer for
		
		return matrix;
	}//end of fill matrix 5

	public static int[][] fillMatrix6 (int matrix[][]){
		
		int num = -10;
		
		for (int row = 0; row < matrix.length; row++) {
			
			for (int col = 0; col < matrix[row].length; col++) {
				
				matrix[row][col] = num;
				num = num +10;
				
			}//inner for
		}//outer for
		
		return matrix;
	}//end of fill matrix 6

}//end of initial class

//I did not know how to write information to text files, so
//this class WriteFile was written with help from google.
// Link is https://www.homeandlearn.co.uk/java/write_to_textfile.html
//Full credit goes to the author of this article.

class WriteFile {
	
	private String path;
	private boolean appendToFile = false;
	
	public WriteFile (String filePath) {
		path = filePath;
	}
	
	public WriteFile (String filePath, boolean appendValue) {
		path = filePath;
		appendToFile = appendValue;
	}
	
	public void writeToFile (String textLine) throws IOException {
		
		
		FileWriter write = new FileWriter (path, appendToFile);
		PrintWriter printLine = new PrintWriter (write);
		
		printLine.printf("%s" , textLine);
		printLine.close();
		write.close();
	}

}//end of WriteFile

