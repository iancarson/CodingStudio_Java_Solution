import java.util.* ;
import java.io.*;
import java.util.ArrayList;

public class Maximum_Element_In_Array_After_Update_Operations {

		public static int findMaxElement(ArrayList < ArrayList < Integer >> arr, int n, int m) {
			// Write your code here.
			int [] incrArr = new int[n];

			for(int i =0; i < m; i++)
			{
				ArrayList<Integer> currArr = arr.get(i);
				int lowerbound = currArr.get(0) - 1;
				int upperBound = currArr.get(1) - 1;
				for(int j = lowerbound; j <= upperBound; j++ )
				{
					incrArr[j] += 1;
				}
			}

			int res = Integer.MIN_VALUE;
			for(int i = 0; i < n; i++)
				res = Math.max(res, incrArr[i]);
			return res;
		}

}
