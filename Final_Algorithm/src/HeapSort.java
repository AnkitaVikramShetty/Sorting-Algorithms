import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HeapSort {
	private static int heapsize;
	public static int Left(int i){
		if(i==0)
			return 1;
		return 2*i;
	}
	public static int Right(int i){
		if(i==0)
			return 2;
		return 2*i + 1;
	}
	public static int Parent(int i){
		if(i==1 || i==2)
			return 0;
		return i/2;
	}
	public static void Max_heapify(int A[], int i){
		int l,r,largest;
		l = Left(i);
		r = Right(i);
		largest = i;
		if (l<=heapsize && A[l]>A[i])
			largest = l;
		else largest = i;
		if(r<=heapsize && A[r]>A[largest])
			largest = r;
		if (largest!=i){
			int temp = A[i];
			A[i] = A[largest];
			A[largest] = temp;
			Max_heapify(A,largest);
		}
		
	}    
	public static void Build_max_heap(int A[]){
		heapsize = A.length-1;
		for(int i = heapsize; i>=0; i--)
			Max_heapify(A,i);
	}
    
	public static void Heapsort(int A[]){
		Build_max_heap(A);
		for(int i=A.length-1; i>0; i--){
			int temp = A[i];
			A[i] = A[0];
			A[0] = temp;
			heapsize = heapsize - 1;
			Max_heapify(A,0);
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
		
		Heapsort(A);
		
		System.out.println("Output:");
		for(int i=0; i < A.length; i++)
			System.out.print("  "+A[i]);
	}

}
