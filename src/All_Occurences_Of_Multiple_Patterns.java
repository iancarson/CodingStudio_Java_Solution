public class All_Occurences_Of_Multiple_Patterns {
	/*
	You are given an array 'ARR' of strings having 'N' strings. You are also given a string 'S'
	Your task is to find all the occurrences of each string of the array 'ARR'
	as substrings in the string 'S'.
	For example:
	Consider the array 'ARR' = {"ab","aa"} and the string 's' = "aabab".
	The substring "ab" is present at index 1 and 3 in the string 'S' and
	the substring "aa" is present at index 0 of the string 'S'.
	Ouput:
	For each test case,return a 2D array of N rows, the i'th of which contains
	all the indices of string at which 'ARR[I]' is present as a substring.
	Sample Input 1:
	3
aa ab b
abaab
Sample Output 1:
2
0 3
1 4
Explanation for Sample Input 1:
For the first test case :
The substring "aa" is present at 2nd index of the String "abaab". The substring "ab" is present at index 0 and index 3
of string S and the substring "b" is present at index 1 and index 4 of string S.

Sample input 2:
2
cc ty
acty
Sample output 2:
2
Explanation for Sample Input 2:
For the second test case:
The substring "cc" is not present in String S and the substring "ty" is present at index 2 of string S.
Sample input 3:
3
cc aa bb
aabbccaa
Sample output 3:
4
0 6
2
Sample input 4:
3
p q r
prrp
Sample Output 4:

	 */
	public static int[][] findOccurrences(String S, String[] arr) {
		// Write your code here.
		int[][] result = new int[arr.length][];
		for (int i = 0; i < arr.length; i++) {
			int count = 0;
			for (int j = 0; j < S.length(); j++) {
				if (S.charAt(j) == arr[i].charAt(0)) {
					if (j + arr[i].length() <= S.length()) {
						if (S.substring(j, j + arr[i].length()).equals(arr[i])) {
							count++;
						}
					}
				}
			}
			result[i] = new int[count];
			int k = 0;
			for (int j = 0; j < S.length(); j++) {
				if (S.charAt(j) == arr[i].charAt(0)) {
					if (j + arr[i].length() <= S.length()) {
						if (S.substring(j, j + arr[i].length()).equals(arr[i])) {
							result[i][k] = j;
							k++;
						}
					}
				}
			}
		}
		return result;
	}
}
