import java.io.*;

public class QuickSort {
	//method to partition the array around the pivot
	public static int partition(int A[], int p, int r){
		int x = A[r];
		int i = p-1;
		for(int j=p; j<r; j++){
			if(A[j]<=x){
				i = i+1;
				int temp = A[i];
				A[i] = A[j];
				A[j] = temp;
			}
		}
		int temp = A[i+1];
		A[i+1] = A[r];
		A[r] = temp;
		return (i+1);
	}
	
	//method to recursively call itself until the array is sorted
	public static void Quicksort(int A[], int p, int r){
		if(p<r)
		{
			int q = partition(A,p,r);
			Quicksort(A, p, q-1);
			Quicksort(A, q+1, r);
			
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
		
		Quicksort(A, 0, A.length-1);
		
		System.out.println("Output:");
		for(int i=0; i < A.length; i++)
			System.out.print("  "+A[i]);
	}

}
