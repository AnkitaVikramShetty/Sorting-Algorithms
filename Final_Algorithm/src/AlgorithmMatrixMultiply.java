import java.io.*;
import java.util.*;

public class AlgorithmMatrixMultiply {
	//check if n is a power of 2
	public static boolean ispowerof2(int n){
		boolean flag = true;
		int remainder = 0;
		while(n > 1){
			remainder = n % 2;
			if(remainder != 0){
				flag = false;
				break;
			}
			else
			n = n / 2;
		}
		return flag;
	}
	
	//generate an array dynamically having random float values
	public static float[][] generatearray(float[][] arrayname){
		int n = arrayname.length;
		float minX = 1f;
		float maxX = 5f;
		Random rand = new Random();
		for(int i=0; i<n; i++)
			for(int j=0; j<n; j++){
				arrayname[i][j]=rand.nextFloat() * (maxX - minX) + minX;
			}
		return arrayname;
	}
	
	//prints the array
	public static void printarray(float array[][],int n){
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++)
				System.out.print(" "+array[i][j]);
			System.out.println();
		}
	}
	//Direct Multiplication
	public static float[][] Mul(float myArray1[][], float myArray2[][]){
		int i=0,j=0,k=0;
		int n = myArray1.length;
		float[][] result = new float[n][n];
        for (i = 0; i < n; i++)
            for (j = 0; j < n; j++)
                for (k = 0; k < n; k++)
                    result[i][j] += myArray1[i][k] * myArray2[k][j];
		return result;
	}
	
	//Sum of two matrices
	public static float[][] plus(float[][] A, float[][] B)
    {
        int n = A.length;
        float[][] C = new float[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                C[i][j] = A[i][j] + B[i][j];
        return C;
    }
	
	//Difference between two matrices
	public static float[][] minus(float[][] A, float[][] B)
    {
        int n = A.length;
        float[][] C = new float[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                C[i][j] = A[i][j] - B[i][j];
        return C;
    }
	
	//Divide into sub arrays
	public static float[][] subarray(float newarray[][], float oldarray[][], int for1init, int for1cond, int for2init, int for2cond){
		for(int i=for1init, row=0; i<for1cond; i++,row++)
			for(int j=for2init, col=0; j<for2cond; j++,col++){
				newarray[row][col] = oldarray[i][j];
			}
		return newarray;
	}
	
	//Construct the 'C' matrix using c1. c2, c3 and c4
	public static float[][] joinarray(float resultarray[][], float c[][], int for1init, int for1cond, int for2init, int for2cond){
		for(int row=for1init, i=0; row<for1cond; i++,row++)
			for(int col=for2init, j=0; col<for2cond; j++,col++){
				resultarray[row][col] = c[i][j];
			}
		return resultarray;
	}
	
	//Strassen's algorithm
	public static float[][] Strassen(float A[][],float B[][]){
		int n = A.length;
		float C[][] = new float[n][n];
		
		if(n!=1){
			float a[][] = new float[n/2][n/2];
			float b[][] = new float[n/2][n/2];
			float c[][] = new float[n/2][n/2];
			float d[][] = new float[n/2][n/2];
			float e[][] = new float[n/2][n/2];
			float f[][] = new float[n/2][n/2];
			float g[][] = new float[n/2][n/2];
			float h[][] = new float[n/2][n/2];
			
			a = subarray(a, A, 0, n/2, 0, n/2);
			b = subarray(b, A, 0, n/2, n/2, n);
			c = subarray(c, A, n/2, n, 0, n/2);
			d = subarray(d, A, n/2, n, n/2, n);
			e = subarray(e, B, 0, n/2, 0, n/2);
			f = subarray(f, B, 0, n/2, n/2, n);
			g = subarray(g, B, n/2, n, 0, n/2);
			h = subarray(h, B, n/2, n, n/2, n);
		
			float [][] p1 = Strassen(plus(a, d), plus(e, h));
		    float [][] p2 = Strassen(plus(c, d), e);
		    float [][] p3 = Strassen(a, minus(f, h));
		    float [][] p4 = Strassen(d, minus(g, e));
		    float [][] p5 = Strassen(plus(a, b), h);
		    float [][] p6 = Strassen(minus(c, a), plus(e, f));
		    float [][] p7 = Strassen(minus(b, d), plus(g, h));
		
			
			float c1[][] = plus(minus(plus(p1,p4),p5),p7);
			float c2[][] = plus(p3,p5);
			float c3[][] = plus(p2,p4);
			float c4[][] = plus(plus(minus(p1,p2),p3),p6);
			
			C = joinarray(C, c1, 0, n/2, 0, n/2);
			C = joinarray(C, c2, 0, n/2, n/2, n);
			C = joinarray(C, c3, n/2, n, 0, n/2);
			C = joinarray(C, c4, n/2, n, n/2, n);
		}
		else
			C[0][0] = A[0][0]*B[0][0];
		return C;
	}
	
	//Standard Recursive Multiplication
	public static float[][] Standard_Multiply_Recursive(float A[][],float B[][]){
		int n = A.length;
		float C[][] = new float[n][n];
		if (n==1)
			C[0][0] = A[0][0]*B[0][0];
		else{
			float a[][] = new float[n/2][n/2];
			float b[][] = new float[n/2][n/2];
			float c[][] = new float[n/2][n/2];
			float d[][] = new float[n/2][n/2];
			float e[][] = new float[n/2][n/2];
			float f[][] = new float[n/2][n/2];
			float g[][] = new float[n/2][n/2];
			float h[][] = new float[n/2][n/2];
			
			a = subarray(a, A, 0, n/2, 0, n/2); 
			b = subarray(b, A, 0, n/2, n/2, n); 
			c = subarray(c, A, n/2, n, 0, n/2); 
			d = subarray(d, A, n/2, n, n/2, n); 
			
			e = subarray(e, B, 0, n/2, 0, n/2);
			f = subarray(f, B, 0, n/2, n/2, n);
			g = subarray(g, B, n/2, n, 0, n/2);
			h = subarray(h, B, n/2, n, n/2, n);
			
			float c1[][] = plus((Standard_Multiply_Recursive(a,e)),(Standard_Multiply_Recursive(b,g)));
			float c2[][] = plus((Standard_Multiply_Recursive(a,f)),(Standard_Multiply_Recursive(b,h)));
			float c3[][] = plus((Standard_Multiply_Recursive(c,e)),(Standard_Multiply_Recursive(d,g)));
			float c4[][] = plus((Standard_Multiply_Recursive(c,f)),(Standard_Multiply_Recursive(d,h)));
			
			C = joinarray(C, c1, 0, n/2, 0, n/2);
			C = joinarray(C, c2, 0, n/2, n/2, n);
			C = joinarray(C, c3, n/2, n, 0, n/2);
			C = joinarray(C, c4, n/2, n, n/2, n);
		}
		return C;
	}
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		int n=0;
		InputStreamReader isr = new InputStreamReader(System.in);
	    BufferedReader br = new BufferedReader(isr);
	    System.out.println("Enter the size of the array: ");
		n = Integer.parseInt(br.readLine());
		float A[][] = new float[n][n];
		float B[][] = new float[n][n];
		float C[][] = new float[n][n];
		System.out.println("Choose from the following ");
		System.out.println("1. Generate arrays dynamically having random float values ");
		System.out.println("2. Enter values for the arrays manually ");
		int choice = Integer.parseInt(br.readLine());
		if(choice == 1){
			A=generatearray(A);
			B=generatearray(B);
		}
		else {
			System.out.println("Enter "+n*n+" values for array A:");
			for(int i=0; i<n; i++)
				for(int j=0; j<n; j++)
					A[i][j] = Integer.parseInt(br.readLine());
			System.out.println("Enter "+n*n+" values for array B:");
			for(int i=0; i<n; i++)
				for(int j=0; j<n; j++)
					B[i][j] = Integer.parseInt(br.readLine());
		}
		System.out.println("Choose the following ");
		
		if(ispowerof2(n) == false){
			System.out.println("Given matrix size is invalid for Strassen's and Recursive Multiplication");
			System.out.println("The result of direct multiplication is:");
			C=Mul(A,B);
			printarray(C,n);
		}
		else{
		System.out.println("Strassen's Algorithm for Matrix Multiplication:");
		long startTimeStrassen = System.currentTimeMillis();
		C=Strassen(A,B);
		long endTimeStrassen = System.currentTimeMillis();
		//printarray(C,n);
		System.out.println("Execution time for Strassen's Algorithm: " + (endTimeStrassen-startTimeStrassen) + "ms");
		
		System.out.println();
		
		System.out.println("Standard Recursive Algorithm for Matrix Multiplication:");
		long startTimeStandard = System.currentTimeMillis();
		C=Standard_Multiply_Recursive(A,B);
		long endTimeStandard = System.currentTimeMillis();
		//printarray(C,n);
		System.out.println("Execution time for standard: " + (endTimeStandard-startTimeStandard) + "ms");

		}
	}
}
