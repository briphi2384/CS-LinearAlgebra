//Brian Phipps
//Program Assignment 3 part 3
//CS linear algebra
//reads in a 2x3 or a 3x3 matrix, computes the area of the triangle, constructs a line/plane and finds the distance
//of the third point from the line/plane

import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.io.*;

public class Phipps_PA3_part3 {

	public static void main(String[] args) throws IOException {
		
		File file = new File ("3D_test_input_1.txt");
		Scanner input = new Scanner (file);
		PrintWriter writer = new PrintWriter ("output3.txt");
		
		double matrix[][] = new double [3][3];
		
		for ( int row = 0; row < 3; row ++) {
			
			for ( int col = 0; col < 3; col ++) {
				matrix[row][col] = input.nextDouble();
				
			}
		}
		
		
		double area = ComputeArea(matrix);
		System.out.printf("Area of triangle: %.2f\n", area);
		writer.printf("Area of triangle: %.2f\n", area);
		
		
		double distance = ComputeDistance(matrix);
		System.out.printf("Distance from plane to point: %.2f", distance);
		writer.printf("Distance from plane to point: %.2f", distance);
		
		

		input.close();
		writer.close();
	}//end of main	
	
	public static double ComputeArea(double matrix[][]) {
		
		double A[] = new double [3];
		double B[] = new double [3];
		double C[] = new double [3];
		
		//assign each point of triangle from matrix passed to func
		for (int i = 0; i < matrix.length; i ++) {
			A[i] = matrix[i][0];
			B[i] = matrix[i][1];
			C[i] = matrix[i][2];
		}
		
		//allows for cross product
		double AB[] = new double [3];
		double AC[] = new double [3];
		
		for ( int i =0; i < AB.length; i++) {      // finds the difference in length
			
			AB[i] = B[i] - A[i];
			AC[i] = C[i] - A[i];
		}
		
		double crossProduct[] = new double[3];
		
		crossProduct[0] = (AB[1] * AC[2]) - (AB[2] * AC[1]); //computes cross product
		crossProduct[1] = (AB[2] * AC[0]) - (AB[0] * AC[2]);
		crossProduct[2] = (AB[0] * AC[1]) - (AB[1] * AC[0]);
		
		double magnitude = Math.sqrt(crossProduct[0]*crossProduct[0] + crossProduct[1]*crossProduct[1] + 
				crossProduct[2]*crossProduct[2]); //Pythagorean Theorem magnitude formula
		
		return 0.5 * magnitude;
		
	}//end of compute area
	
	public static double ComputeDistance(double matrix[][]) {
		
		double normal[] = new double[3]; //compute the normal vector to the plane
		normal [0] = matrix[1][0]*matrix[2][1] - matrix[2][0]*matrix[1][1]; //A
		normal [1] = matrix[2][0]*matrix[0][1] - matrix[0][0]*matrix[2][1]; //B
		normal [2] = matrix[0][0]*matrix[1][1] - matrix[1][0]*matrix[0][1]; //C
		double d = -(normal[0]*matrix[0][0] + normal[1]*matrix[0][1] + normal[2]*matrix[0][2]); //D
		
		
		double point[] = new double[3]; //create a point using the 3rd column of matrix
		for (int i = 0; i < matrix.length; i ++) {
			point[i] = matrix[i][2];
		}
		
		//computes distance
		//Ax + By + Cd + D / sqrt(A^2 + B^2 + C^2)
		double distance = Math.abs(normal[0]*point[0] + normal[1]*point[1] + normal[2]*point[2] +d) 
				/ Math.sqrt(normal[0]*normal[0] + normal[1]*normal[1] + normal[2]*normal[2]);
		
		return distance;
		
	}
}//end of class
