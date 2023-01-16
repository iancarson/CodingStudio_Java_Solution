public class Shortest_Subsequence {
	/*
	Given two arrays 'SMALL' and 'LARGE'. You need to find the length of the shortest sub-array of 'LARGE' array,
	that contains all elements of the 'SMALL' array. It is given that elements in
	the 'SMALL' sub-array can be in any order.
	Note:
	All the elements in the 'SMALL' array are distinct.
	For example:
	Let us say 'SMALL' = [3,6] and 'LARGE' = [8,6,9,3,1,2,6].
	Subarray [1,3] (from index 1 to index 3) and [3,6] have all the elements that
	are present
	In 'SMALL' array. The length of the sub-array [1,3] is 3 is shorter.
	Therefore required answer = 3.
	Note:
	For each test case, print an integer denoting the length of the shortest sub-array of
	'LARGE' having all elements of the 'SMALL' array.
	If no such subarray exists, return '-1'.
	Sample Input 1:
	6 3
5 10 15 5 2 13
15 10 2
Sample Output 1:
4
Explanation for Sample Input 1:
Test Case 1: The ‘LARGE’ array is [5, 10, 15, 5, 2, 13] and ‘LARGE’ = [15, 10, 2].

Subarray [10, 15,5, 2] has all elements of the ‘LARGE’ array. Therefore answer = 4.
Sample Input 2:
5 2
7 4 1 9 8
9 6
Sample Output 2:
-1
Explanation for Sample Input 2:
Test Case 2: There is no sub-array having elements of the ‘LARGE’ array. Therefore answer = -1.
Sample Input 3:
3 1
22 45 17
17
Sample Output 3:
1
Sample Input 4:
6 2
4 6 8 9 5 4
8 4
Sample Output 4:
3
Explanation for Sample Input 4:
Test Case 4: The ‘LARGE’ array is [4, 6, 8, 9, 5, 4] and ‘LARGE’ contains [8,4] from 1 to 3.
Therefore answer = 3.
The method below has the optimized implementation of the above algorithm:
	 */
	public static int shortestSupersequence(int[] large, int[] small, int m, int n) {

		// Initializing variable to store result.
		int res = Integer.MAX_VALUE;

		int find = 0;

		// Stores the ending index of supersequence.
		int end;

		// Checking supersequence starting from every index of 'large' array.
		for (int i = 0; i < m; i++) {
			end = -1;

			// Checking for every element of 'small' array.
			for (int j = 0; j < n; j++) {
				find = -1;

				// Iterating over large array to find nearest index of element at small[ j ].
				for (int k = i; k < m; k++) {

					// If element is found update find and break loop.
					if (large[k] == small[j]) {
						find = k;
						break;
					}
				}

				// Element is not found if value of find remains -1.
				if (find == -1) {
					break;
				}
				// Update end if element is found.
				else {
					end = Math.max(end, find);
				}
			}

			// If find = -1, element not found.
			if (find == -1) {
				break;
			}

			// Update res if supersequence found.
			else {
				res = Math.min(res, end - i + 1);
			}
		}

		// Return res if supersequence found.
		if (res != Integer.MAX_VALUE) {
			return res;
		}
		// Return -1 if no supersequence found.
		else {
			return -1;
		}
	}
}
