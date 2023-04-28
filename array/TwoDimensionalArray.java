package com.example.array;

import java.util.Arrays;

public class TwoDimensionalArray {
	
	public static void main(String args[]) {
		int arr[][] = new int[3][6];
		
		int a[][] = new int[][] {
								  {5,10,15,20,25},
								  {2,4,6,8,10},
								  {8,16,24,32,40}
								 };
		System.out.println(Arrays.deepToString(a));
		
		for(int row=0;row<a.length;row++) {
			for(int column=0; column<a[0].length; column++) {
				System.out.print(a[row][column] + " ");
			}
		}
		
		//delete field from two dimensional array
		System.out.println("");
		a[2][4] = Integer.MIN_VALUE;
		System.out.println(Arrays.deepToString(a));
		
		int myArray2D[][] = {{1,2,3},{4,5,6},{7,8,9}};
		System.out.println(sumDiagonal(myArray2D));
		
		int[][] matrix = {{1,2,3}, {4,5,6}, {7,8,9}};
	    isRotateMatrix(matrix);
	    System.out.println(Arrays.deepToString(matrix));
	}
	
	public static int sumDiagonal(int[][] a) {
        int sum = 0;
        for (int i=0; i<a.length;i++) {
            sum+= a[i][i];
        }
        return sum;
    }
	
	//For i=0 to n 
	//temp = top[i]
	//top[i] = left[i]
	//left[i] bottom[i]
	//bottom[i] = right[i]
	//right[i] = temp;
	public static boolean isRotateMatrix(int[][] matrix) {
		if (matrix.length == 0 || matrix.length != matrix[0].length) return false;
	    int n = matrix.length;//no of matrix rows
	    
	    //looping layers(2 outer layers), layer length is less than row length / 2
	    for (int layer = 0; layer < n/2; layer++) {
	      int first = layer;
	      int last = n - 1 - layer;
	      
	      //Using start and end, iterate cells
	      for (int i=first; i<last; i++) {
	    	  
	    	//find the location of cell
	        int offset = i - first;
	        
	        int top = matrix[first][i];//top(i) first row, first column matrix[0][0]
	        matrix[first][i] = matrix[last-offset][first];//left(i) last row, first column matrix[2][0], offset for 2 layers. For outer layer, offset is zero. For inner layer, offset change
	        matrix[last-offset][first] = matrix[last][last-offset];//bottom(i) last row, last column
	        matrix[last][last-offset] = matrix[i][last];//right(i) first row, last column 
	        matrix[i][last] = top;

	      }

	    }
	    return true;
	}
    
	
}
