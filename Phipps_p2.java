//matrix addition
//created by Brian Phipps

import java.util.Arrays;
import java.util.Scanner;
import java.lang.Math;
import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.File;

public class Phipps_p2 {

	public static void main(String[] args) throws IOException {
		
		File mat1file = new File("Phipps_mat1.txt");
		File mat2file = new File ("Phipps_mat2.txt");
		File mat3file = new File ("Phipps_mat3.txt");
		File mat4file = new File ("Phipps_mat4.txt");
		File mat5file = new File ("Phipps_mat5.txt");
		File mat6file = new File ("Phipps_mat6.txt");
		
		Scanner mat1scan = new Scanner (mat1file);
		Scanner mat2scan = new Scanner (mat2file);
		Scanner mat3scan = new Scanner (mat3file);
		Scanner mat4scan = new Scanner (mat4file);
		Scanner mat5scan = new Scanner (mat5file);
		Scanner mat6scan = new Scanner (mat6file);
		
		
		double mat1[][];
		double mat2[][];
		double mat3[][];
		double mat4[][];
		double mat5[][];
		double mat6[][];
		
		mat1 = fillMatrix(mat1scan, mat1file);
		displayMatrix(mat1);
		mat2 = fillMatrix(mat2scan, mat2file);
		mat3 = fillMatrix(mat3scan, mat3file);
		mat4 = fillMatrix(mat4scan, mat4file);
		mat5 = fillMatrix(mat5scan, mat5file);
		mat6 = fillMatrix(mat6scan, mat6file);
		
		
		double matAdd2and3[][];
		double matAdd4and5[][];
		matAdd2and3 = matrixAddition(mat2,mat3);
		matAdd4and5 = matrixAddition(mat4,mat5);
		
		String mat2plus3 = "Phipps_p2_out23";
		String mat4plus5 = "Phipps_p2_out45";
		
		printMatrixNicely(matAdd2and3, mat2plus3);
		printMatrixNicely(matAdd4and5, mat4plus5);
		
		
		mat1scan.close();
		mat2scan.close();
		mat3scan.close();
		mat4scan.close();
		mat5scan.close();
		mat6scan.close();
	}// end of main
	
	public static double[][] fillMatrix (Scanner matScan, File file) throws IOException{
		Scanner tempScan = new Scanner (file);
		
		int sum = 0;
		while(matScan.hasNext()) {
			sum++;
		}
		int numCol = sum;
		sum=0;
		while(matScan.hasNextLine()) {
			sum++;
		}
		int numRow = sum;
		
		double matrix[][] = new double [numRow][numCol];
		
		for (int i = 0; i < numRow; i++) {
			
			for (int j = 0; j < numCol; j++) {
				matrix[i][j] =(double) tempScan.nextInt();
				
			}
		}
		
		return matrix;
	}//end of fillMatrix

	public static double[][] matrixAddition (double matrix1[][], double matrix2[][]) {
		
		int length = matrix1.length;
		double newMatrix[][] = new double [matrix1.length][matrix1[length].length];
		
		for (int i =0; i < matrix1.length; i ++) {
			
			for (int j =0; j<matrix1[i].length; j++) {
				
				newMatrix[i][j] = (matrix1[i][j] + matrix2[i][j]);
			}
			
		}//end outer for
		
		return newMatrix;
	}//end of matrix addition
	
	public static void displayMatrix (double matrix[][]) {
		
		for (int i =0; i < matrix.length; i++) {
			System.out.println("");
			
			for (int j =0; j < matrix[i].length; j++) {
				
				System.out.printf("%.2f", matrix[i][j]);
			}
		}
		
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
}//end of class

//class WriteFile {
//	
//	private String path;
//	private boolean appendToFile = false;
//	
//	public WriteFile (String filePath) {
//		path = filePath;
//	}
//	
//	public WriteFile (String filePath, boolean appendValue) {
//		path = filePath;
//		appendToFile = appendValue;
//	}
//	
//	public void writeToFile (String textLine) throws IOException {
//		
//		
//		FileWriter write = new FileWriter (path, appendToFile);
//		PrintWriter printLine = new PrintWriter (write);
//		
//		printLine.printf("%s" , textLine);
//		printLine.close();
//		write.close();
//	}
//
//}//end of WriteFile

