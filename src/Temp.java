public class Temp {
	/*
	There are 'N' students standing in a row. Students are comprised of both girls G and
	boys B. Kevin is their teacher, who wants to pick a group of students that have an equal
	number of boys and girls. Kevin does not want to disturb the whole row and so, he only
	wants to pick students that are adjacent to each other. Formally, he can only
	pick a subarray, not a subsequence.
	A complete row is given as an array of characters (as a String 'S'), you have
	to find the length of the longest such subarray which follows the above
	criteria.
	For each test case, print the length of the longest possible subarray that kevin
	picks so that students are adjacent to each other, that is B and G are adjacent to each other.
	Output for every test case will be printed in a separate line.
	Sample Input 1:
	2
4
BGGB
5
BBBGB
Sample Output 1:
4
2
In the first test case, Kevin can choose all students as there is exactly the same number of Boys and Girls in the row.

In the second test case, possible subarrays are “BG” and “GB”.
Sample Input 2:
2
1
B
2
GG
Sample Output 2:
0
0
Sample Input 3:
10
1
G
2
BG
10
GGGGGBGGGG
13
GBGGGGBGGBGGG
7
GGBGBGG
8
BGBBBBGB
11
BGGBGBGBBGG
5
BGBBG
1
B
3
BGB
Sample Output 3:
0
2
2
4
4
2
10
4
0
2
	 */
	public static void main(String[] args) {

	}
	public static int lengthOfLongestSubArrWithEqualBAndG(String s) {
		// Write your code here and comment appropriately

		int n = s.length();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			if (s.charAt(i) == 'B') {
				arr[i] = 1;
			} else {
				arr[i] = -1;
			}
		}
		int[] sum = new int[n];
		sum[0] = arr[0];
		for (int i = 1; i < n; i++) {
			sum[i] = sum[i - 1] + arr[i];
		}
		int res = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				//The time
				int cur = sum[j] - sum[i] + arr[i];
				if (cur == 0) {
					res = Math.max(res, j - i + 1);
				}
			}
		}
		return res;

	}
}
