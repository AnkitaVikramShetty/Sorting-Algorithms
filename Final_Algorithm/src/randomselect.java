import java.io.*;
import java.util.Random;

public class randomselect {
	//method to generate a random pivot
	public static int GetRandom(int[] array, int p, int r) {
		Random rand = new Random(); 
		int rnd = rand.nextInt(r - p)+p;
	    return rnd;
	}
	
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
	
	//method that takes the pivot and calls partition
	public static int RandomizedPartition(int A[], int p, int r){
		int i = GetRandom(A, p, r);
		int temp = A[i];
		A[i] = A[r];
		A[r] = temp;
		return partition(A,p,r);
		
	}
	
	//method to select the ith order statistic
	public static int Randomized_Select_Iterative(int A[], int p, int r, int i){
		if (p==r)
			return A[p];
		while(p<r){
			int q = RandomizedPartition(A, p, r);
			int k = q-p+1;
			if (i==k)
				return A[q];
			else if(i<k)
				r = q;
			else{
				p = q+1;
				i = i-k;
			}
		}
		return -1;
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
		
		System.out.println("Enter which order statistic is to be found:");
		int i = Integer.parseInt(br.readLine());
		
		int x =Randomized_Select_Iterative(A, 0, A.length-1, i);
		
		System.out.println("Sorted Array:");
		for(int j=0; j < A.length; j++)
			System.out.print("  "+A[j]);
		
		if (x==-1)
			System.out.println("Invalid index");
		else
			System.out.println("\nOutput: "+x);
	}

}
