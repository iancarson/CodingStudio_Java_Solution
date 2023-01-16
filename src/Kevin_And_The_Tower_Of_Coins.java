import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Kevin_And_The_Tower_Of_Coins {
	/*
	Kevin has 'N' coins. Each coin has a specific width and diameter. Kevin wants to build a tower
	using these coins such that each coin in the tower has strictly less width and diameter as compared
	to all coins placed below this coin.
	You have to find the maximum height of the tower that kevin can build using these coins:
	Note:
	The height of the tower ic calculated by adding the width of all the coins used in the
	formation of this tower.
	For each test case, return the maximum possible height of the tower.
	Output for every test case will be printed in a separate line.
	Sample Input 1:
	4 5
2 4
Sample Output 1:
2
Explanation for Sample Input 1:
In the first test case, the tower formed will have the 2nd coin at the lowest level and the 1st coin on top of it.
Sample Input 2:
1 1
2 2
3 3
4 4
Sample Output 2:
4
Explanation for Sample Input 2:
In the second test case, the 4th coin will be placed at the bottom of the tower, on top of that is 3rd and on whose top is 2nd and at the topmost level is 1st coin.
Sample Input 3:
1
5 4
Sample Output 3:
1
Sample Input 4:
2
4 5
2 4
Sample Output 4:
2
Sample Input 5:
4
1 1
2 2
3 3
4 4
Sample Output 5:
4
Sample Input:
12
5 4
6 7
6 5
6 6
5 3
1 7
7 4
1 3
3 4
6 1
5 6
1 6
Sample Output:
5
Sample Input:
10
6 1
7 7
3 4
1 2
2 4
5 1
2 7
7 7
7 5
3 3
Sample Output:
5
Sample Input:
10
7 3
5 3
5 2
6 2
5 2
1 4
4 4
5 6
2 1
5 2
Sample Output:
4
Sample Input:


Write a method that implements the above approach and returns the correct output as indicated in the sample test cases.
	 */
	/*
	Time complexity: O(2^N)
	Space complexity: O(N)

	Where 'N' is the total number of coins.
*/

	// Compare function which helps in sorting the array in the increasing order of the first element (width of the coin).



		// Helper function to calculate the longest increasing subsequence on the basis of the diameter of coins.
		private static int helper(ArrayList<ArrayList<Integer>> arr, int previous, int current) {
			if (current == arr.size()) {
				return 0;
			}

			int pick = 0, drop = 0;

			// Pick this coin and call for the rest one.
			if (previous < arr.get(current).get(1)) {
				pick = 1 + helper(arr, arr.get(current).get(1), current + 1);
			}

			// Drop this coin and call for the rest.
			drop = helper(arr, previous, current + 1);

			// Return the maximum between pick and drop.
			return Math.max(pick, drop);
		}

		public int maxTowerHeight(ArrayList<ArrayList<Integer>> arr, int n) {
			// Sort the array "arr".
			Collections.sort(arr, new cmp());

			// Call the helper to calculate the answer.
			return helper(arr, Integer.MIN_VALUE, 0);
		}

	class cmp implements Comparator<ArrayList<Integer>> {
		@Override
		public int compare(ArrayList<Integer> a1, ArrayList<Integer> a2) {
			if (a1.get(0).intValue() == a2.get(0).intValue()) {
				return (a1.get(1) - a2.get(1));
			}
			return (a1.get(0) - a2.get(0));
		}
	}
}
