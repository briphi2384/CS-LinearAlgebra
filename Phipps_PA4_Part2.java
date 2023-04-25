//Brian Phipps
//CS Linear Algebra
//PA4 part2
//read in doubles from a file to define a plane and a point
//compute distance between point and plane
//Also, uses same input to define a line and point cordinates. 
//Checks to see if line intersects with triangle.

import java.util.Scanner;
import java.io.IOException;
import java.util.*;
import java.io.*;

public class Phipps_PA4_Part2 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		File file = new File ("input_PA4_part2.txt");
		
		Scanner input = new Scanner(file);
		PrintWriter writer = new PrintWriter("output_PA4_part2.txt");
		
		double pointOnPlane[] = new double[3];
		double normal[] = new double[3];
		double point[] = new double [3];
		
		for (int i = 0; i < 3; i ++) {
			pointOnPlane[i] = input.nextDouble();
		}
		for (int i =0; i < 3; i ++) {
			normal[i] = input.nextDouble();
		}
		for (int i = 0; i < 3; i ++) {
			point[i] = input.nextDouble();
		}
		double distance = ComputeDistance(pointOnPlane, normal, point);
		writer.println("Distance: " + distance);
		
		input.close();
		
		
		//Begin part 2//
		
		Scanner input2 = new Scanner(file);
		double line1[] = new double[3];
		double line2[] = new double[3];
		double triangle [][] = new double[3][3];
		
		for (int i = 0 ; i < 3; i ++) {
			line1[i] = input2.nextDouble();
		}
		for (int i =0; i < 3; i ++) {
			line2[i] = input2.nextDouble();
		}
		for (int i =0; i < 3; i++) {
			for(int j =0; j < 3; j ++) {
				triangle[i][j] = input2.nextDouble();
			}
		}
		double lineDirection[] = new double[3];
		for (int i =0; i < 3; i ++) {
			lineDirection[i] = line2[i] - line1[i];
		}
		
		double edge1[] = new double[3];
		double edge2[] = new double[3];
		for (int i =0; i <3; i++) {
			edge1[i] = triangle[1][i] - triangle[0][i];
			edge2[i] = triangle[2][i] - triangle[1][i];
		}
		
		double triangleNormal[] = CrossProduct(edge1, edge2);
		
		//Checks if lines are parallel
		if (DotProduct(lineDirection, triangleNormal) == 0) {
			writer.println("Does not intersect.");
		}
		
		//Compute intersection point
		double t = DotProduct(triangleNormal, subtract(triangle[0], line1)) / 
				DotProduct(triangleNormal, lineDirection);
		double intersection[] = new double [3];
		for (int i =0; i < 3; i ++) {
			intersection[i] = line1[i] + t * lineDirection[i];
		}
		
		//Checks if intersection is inside triangle
		double alpha = DotProduct(CrossProduct(subtract(triangle[1], triangle[0]), subtract(intersection, triangle[0])),
				triangleNormal) / DotProduct(triangleNormal, triangleNormal);
		double beta = DotProduct(CrossProduct(subtract(triangle[2], triangle[1]), subtract(intersection, triangle[1])),
				triangleNormal) / DotProduct(triangleNormal, triangleNormal);
		double gamma = DotProduct(CrossProduct(subtract(triangle[0], triangle[2]), subtract(intersection, triangle[2])), 
				triangleNormal) / DotProduct(triangleNormal, triangleNormal);
		
		if (alpha >= 0 && beta >= 0 && gamma >= 0) {
			writer.println("Intersection point:" + intersection[0] + ", " + intersection[1] + ", " + intersection[2]);
			
		}else {
			writer.println("Does not intersect");
		}
		
		
		
		writer.close();
		input.close();
	}//end of main
	
	public static double ComputeDistance (double[] pointOnPlane, double[] normal, double[] point) {
		double distance = 0;
		
		distance = Math.abs((normal[0]*(point[0] - pointOnPlane[0]) + normal[1] * (point[1] - pointOnPlane[1])
				+ normal[2] * (point[2] - pointOnPlane[2])) / Math.sqrt(normal[0] * normal[0] + normal[1] *
						normal[1] + normal[2] * normal[2]));
		
		return distance;
	}//end of ComputeDistance
	
	public static double[] CrossProduct (double[]v1, double[] v2) {
		double array[] = new double[3];
		
		array[0] = v1[1] * v2[2] - v1[2] * v2[1];
		array[1] = v1[2] * v2[0] - v1[0] * v2[2];
		array[2] = v1[0] * v2[1] - v1[1] * v2[0];
		
		return array;
	}//end of CrossProduct
	
	public static double DotProduct (double[] v1, double[] v2) {
		double dotProduct = 0;
		dotProduct = v1[0] * v2[0] + v1[1] * v2[1] + v1[2] * v2[2];
		return dotProduct;
		
	}//end of DotProduct
	
	public static double[] subtract (double[] v1, double[] v2) {
		double array[] = new double [3];
		array[0] = v1[0] - v2[0];
		array[1] = v1[1] - v2[1];
		array[2] = v1[2] - v2[2];
		
		return array;
	}//end of subtract

}//end of class
