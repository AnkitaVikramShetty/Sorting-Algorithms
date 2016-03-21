import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BubbleSort {

	public static void Bubblesort(int A[]){
		int i=0,j=0;
		for(i=0; i<A.length-1;i++)
			for(j=A.length-1; j>i; j--)
				if(A[j]<A[j-1]){
					int temp = A[j];
					A[j] = A[j-1];
					A[j-1] = temp;
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
		
		Bubblesort(A);
		
		System.out.println("Output:");
		for(int i=0; i < A.length; i++)
			System.out.print("  "+A[i]);
	}

}
