//Brian Phipps
//CS Linear Algebra
//Program assignment 4 Part 1
//Read in data from a file, program a parallel projection and a perspective projection

import java.util.Scanner;
import java.io.PrintWriter;
import java.util.*;
import java.io.*;


public class Phipps_PA4_Part1 {

	public static void main(String[] args) throws IOException{
		File file = new File ("input_p1.txt");
		Scanner input = new Scanner (file);
		PrintWriter writer = new PrintWriter("bphipps_output_1_A.txt");

		double[] x = new double [3];
		double[] q = new double [3];
		double[] n = new double [3];
		double[] v = new double [3];
		double[][] I = new double[3][3]; //Identity matrix
		double VdotN;
		double QdotN;
		
		//reads first 3 values as q, the point on the plane
		for (int i =0; i < 3; i ++) {
			q[i] = input.nextDouble();
			
		}
		//reads next 3 values as n, the normal to the plane
		for (int i=0; i < 3; i ++) {
			n[i] = input.nextDouble();
			
		}
		//reads next 3 values, the directional vector v
		for (int i =0; i < 3; i ++) {
			v[i] = input.nextDouble();
			
		}
		//Lastly, we will read in the last 3 values as point x
		for (int i=0; i < 3; i++) {
			x[i] = input.nextDouble();
		}
		
		double[][]VnT = VnT(v,n);
		I=IdentityMatrix();
		
		VdotN = DotProduct(v, n);
		QdotN = DotProduct(q, n);
		
		//now comes the math
		//I split the equation up into 2 parts to make the math simpler/easier to follow
		double[] firstHalf = new double[3];
		firstHalf = FirstHalf(I, VnT, VdotN, x);
		double[] secondHalf = new double[3];
		secondHalf = SecondHalf(VdotN, QdotN, v);
		
		//Lastly, we add both parts of the equation to get our final answer, x'
		double[]finalAnswer = new double[3];
		writer.println("Parallel prjection:");
		System.out.println("Parallel projection: ");
		for (int i = 0; i < 3; i++) {
			finalAnswer[i] = firstHalf[i] + secondHalf[i];
			System.out.println(finalAnswer[i]);
			writer.println(finalAnswer[i]);
			
		}
		
//		PERSPECTIVE PROJECTION x' = (q . n / v . n) X
		
		double xPrime[] = new double [3];
		double XdotN = DotProduct(x, n);
		double division = QdotN / XdotN;
		System.out.println("Perspective projection: ");
		writer.println("Perspective prjection: ");
		for (int i =0; i < 3; i++) {
			
			xPrime[i] = division * x[i];
			System.out.println(xPrime[i]);
			writer.println(xPrime[i]);
		}
		input.close();
		writer.close();
	}//end of main
	
	public static double[][] VnT (double[]v, double[]n){
		double[][] array = new double[3][3];
		
		for (int i =0; i < 3; i ++) {
			
			
			for (int j=0;j < 3; j++) {
				array[i][j] = v[i]*n[j];
				
			}
		}
	return array;
	}//end of VnT
	
	public static double[][] IdentityMatrix(){
		double array[][] = new double[3][3];
		
		for (int i =0; i < 3; i++) {
			
			for (int j = 0; j < 3; j ++) {
				
				if (i==j) { //fills identity matrix
					array[i][j] = 1;
				}
				else{
					array[i][j] = 0;
				}
			}
		}
		return array;
	}//end of IDMatrix
	
	public static double DotProduct(double[] array1, double[] array2) {
		double sum =0;
		//computes the dot product of 2 vectors/arrays
		for (int i =0; i < 3; i++) {
			
			sum = sum + (array1[i]*array2[i]);
		}
		
		return sum;
	}//end of DotProduct
	
	public static double[] FirstHalf(double[][]I, double[][]VnT, double VdotN, double[] x) {
		double product[] = new double[3];
		//First, we will calculate VnT / VdotN, which we will call Z
		double[][] Z = new double[3][3];
		
		for (int i = 0; i < 3; i ++) {
			
			for (int j=0; j < 3; j ++) {
				Z[i][j] = VnT[i][j]/VdotN;
			}
		}
		
		//Next, we will subtract I - Z. The resulting Matrix we will call A
		double[][] A = new double[3][3];
		for ( int i = 0; i < 3; i++){
			
			for (int j =0; j < 3; j ++) {
				A[i][j] = I[i][j] - Z[i][j];
				
			}
		}
		
		//Lastly, we will multiply our new matrix A by the point X to complete the first half of the equation
		for (int i =0; i < 3; i ++) {
			
			for ( int j =0; j <3; j++) {
				
				product[i]=A[i][j] * x[j];
				
			}
		}
		
		return product;
	}//end of first half
	
	public static double[] SecondHalf(double VdotN, double QdotN, double[] v) {
		double product[] = new double[3];
		
		//first, divide QdotN / VdotN. We will call this A.
		double A = QdotN/VdotN;
		
		//Now we multiply V by this number A
		for (int i =0; i < 3; i ++) {
			product[i] = A*v[i];
		}
		
		return product;
	}
}//end of class
