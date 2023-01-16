import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Pattern_Matching {
	/*
	You are given a pattern in the form of a string and a collection of words. Your task is to
	determine if the pattern string and the collection of words have the
	same order.
	Note:
	The Strings are non-empty.
	The strings only contain lowercase letters.
	Output Format:
	For each test case, print in a new line, "True" if the strings in the words array follow
	the same order as the order of the characters in the pattern string. Otherwise,
	print "False".
	Sample Input 1:
	1
abab 4
bat ball bat ball
Sample Output 1:
True
Explanation for Sample Input 1:
In the given example, ‘a’ is present at the 1st and 3rd position, and ‘b’
 is present at the 2nd and 4th position. Similarly, in the collection of words,
  “bat” is present at the 1st and 3rd position while “ball” is present at
   the 2nd and 4th position. Since the words are following the order of
   the pattern string, we print “True”.
   Sample Input 2:
   2
abbb 4
bat ball bat bat
abab 4
bat bat bat bat
Sample Output 2:
False
False

	 */
	public static void main(String[] args) {

	}
	/*
    Time Complexity: O(N)
    Space Complexity: O(M),

	Where N is the length of the pattern string and M is the number of unique words in the collection.
*/

		public static boolean isPatternMatching(String pattern, ArrayList<String> words)
		{
			// Maintain a HashMap to keep a track of the corresponding characters and strings.
			HashMap<Character, String> charToString = new HashMap<>();

			// Maintain another HashMap to keep a track of whether a string has already been matched or not.
			HashMap<String, Boolean> alreadyMatched = new HashMap<>();

			// If the size of the pattern string is not equal to the size of the string array, return False.
			if (pattern.length() != words.size())
			{
				return false;
			}

			for (int i = 0; i < pattern.length(); i++)
			{
				if (charToString.containsKey(pattern.charAt(i)) == false)
				{
					if (alreadyMatched.containsKey(words.get(i)))
					{
						return false;
					}

					charToString.put(pattern.charAt(i), words.get(i));
					alreadyMatched.put(words.get(i), true);
				}
				else
				{
					if (charToString.get(pattern.charAt(i)).equals(words.get(i)) == false)
					{
						return false;
					}
				}
			}

			// If there is no mismatch, return True.
			return true;
		}
	}

