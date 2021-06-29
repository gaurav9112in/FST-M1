package activities;

import java.util.Arrays;

public class Activity4 {

	public static void main(String[] args) {

		int[] numArr = {4,3,2,10,12,1,5,6};
		
		System.out.print("Numbers before Sorting -> " + Arrays.toString(numArr));
		numArr = insertionSort(numArr);
		System.out.print("\nNumbers After Sorting -> " + Arrays.toString(numArr));
	}

	public static int[] insertionSort(int[] numArr) {
		int size = numArr.length - 1;
		for (int i = 1;i<=size;i++)
		{
			int key = numArr[i];
			int j=i-1;
			while ( j>= 0 && key < numArr[j] )
			{
				numArr[j+1] = numArr[j];
				--j;
			}
			numArr[j+1] = key;	
			
		}
	return numArr;	
	}

}
