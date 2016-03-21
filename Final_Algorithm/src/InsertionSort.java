import java.io.*;
import java.util.*;

public class InsertionSort {
	public static void Insertionsort(int A[]){
		int key = -1;
		for(int j=1; j<A.length; j++){	
			key = A[j];
			int i = j-1;
			while(i>=0 && A[i]>key){
				A[i+1]=A[i];
				i=i-1;
			}
			A[i+1] = key;
		}
	}

	public static void main(String[] args) throws IOException{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		System.out.println("Enter the size of the input array:");
		int n = Integer.parseInt(br.readLine());
		
		int A[] = new int[n];
		System.out.println("Enter the array elements to be sorted:");
		for(int i=0; i<n; i++)
			A[i] = Integer.parseInt(br.readLine());
		
		System.out.println("Input:");
		for(int i=0; i < A.length; i++)
			System.out.print("  "+A[i]);
		System.out.println();
		
		Insertionsort(A);
		
		System.out.println("Output:");
		for(int i=0; i < A.length; i++)
			System.out.print("  "+A[i]);
	}
}
