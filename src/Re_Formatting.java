import java.util.Arrays;

public class Re_Formatting {
	/*
	You are given a String S and a dictionary of words DRR of length 'M'. It is guaranteed
	that S does not contain any space. DRR is a list of words.
	Your task is to convert S into a document of space-separated words such that each word
	is present in the dictionary DRR, and the number of spaces in between the word is minimized. You have to print the minimum
	number of spaces used.
	For example, if S = "iamalice", DRR = ["i","am","alice","iam"]
	Here the answer is 1, as S can be returned as "iam alice" which uses only 1 space.
	S = "i am alice" is also a valid answer, but it uses 2 spaces.
	Output Format:
	For each test case, print the minimum number of spaces used to convert S to a Document
	for which each word is present in DRR.
	If there is no way to convert S into a Document, then print -1.
	Output for each test case is printed in a separate line.
	Sample Input 1:
	2
marginissmall
6
small all mall is in margin
abcd
10
a b c d e f g h i j
Sample Output 1:
2
3
Explanation for Sample Input 1:
For the first test case S can be written as S = ”margin is small”

For the second test case S can be written as S = “a b c d”
Sample Input 2:
2
aaaaaaaa
1
a
codeninjacodeninja
3
code ninja codeninja
Sample Output 2:
7
1
Sample input 3:
5
tttaaay
4
tt ta aa y
zzzyyyy
3
z zz y
cdcdcdcdcd
2
c d
xyzxyzxyz
3
yz xy z
abcdefgh
7
a b c d f g h
Sample output 3:
3
5
9
5
-1
Sample Input 4:
5
catratbathatlet
5
cat rat bat hat let
iamnotgoodinmath
6
not good math in i am
codingtillmidnight
4
cod lmid ingtil night
hellothere
2
hello here
iandme
3
i and me
Sample Output 4:
4
5
3
-1
2
	 */
	public static void main(String[] args) {

	}
	//This method formats the String and the DRR and returns the length
	//of the minimum number of spaces used to convert S to a Document
	//for which each word is present in DRR.
	public static int format(int m, String S, String[] DRR) {
		int n = S.length();
		int[] dp = new int[n + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < m; j++) {
				int len = DRR[j].length();
				if (i - len >= 0 && S.substring(i - len, i).equals(DRR[j])) {
					if (dp[i - len] != Integer.MAX_VALUE) {
						dp[i] = Math.min(dp[i], dp[i - len] + 1);
					}
				}
			}
		}
		if (dp[n] == Integer.MAX_VALUE) {
			return -1;
		}
		return dp[n] - 1;
	}

}
