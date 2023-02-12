import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Phipps_p5 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub


		int arrayR[][] = new int [2][1];
		
		int arrayS[][] = new int [2][1];
		
		int arrayU[][] = new int [2][1];
		
		int arrayV[][] = new int[2][1];
		int arrayW[][] = new int[2][1];
		
		arrayR[0][0] = -1;
		arrayR[1][0] = -2;
		
		arrayS[0][0] = -3;
		arrayS[1][0] = 3;
		
		arrayU[0][0] = 2;
		arrayU[1][0] = -1;
		
		arrayV[0][0] = 3;
		arrayV[1][0] = 1;
		
		arrayW[0][0] = 1;
		arrayW[1][0] = 3;
		
		int arrayRS[][] = matrixAddition (arrayR, arrayS);
		int arraySW[][] = matrixAddition (arrayS, arrayW);
		int arrayuv[][] = matrixAddition (arrayU, arrayV);
		
		
		
		
	}//end of main
	
public static int[][] matrixAddition (int matrix1[][], int matrix2[][]) {
		
		int length = matrix1.length;
		int newMatrix[][] = new int [matrix1.length][matrix1[length].length];
		
		for (int i =0; i < matrix1.length; i ++) {
			
			for (int j =0; j<matrix1[i].length; j++) {
				
				newMatrix[i][j] = (matrix1[i][j] + matrix2[i][j]);
			}
			
		}//end outer for
		
		return newMatrix;
	}//end of matrix addition
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

}//end of class
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
