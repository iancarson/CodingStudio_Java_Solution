import java.util.Arrays;
/*
    Time Complexity: O(N * L * L)
    Space Complexity: O(N)

    Where 'N' is the number of words in the list while 'L' is the length of the longest word
*/
/*
	You are given an array/list of words 'ARR'. Your task is to find all the words having the
	longest length which can be made from same other words in the list.
	Note:
	Return the list of all those words sorted in alphabetical, all the words should be available in the returned array. Return an empty list in case
	there are no such words.
	For example:
	Input: cat, banana, dog, nana,my, walk, walker, baby, dogwalkers, s, babymybaby
	Output: babymybaby dogwalkers

	Here in the given list of words, you can see that the words babymybaby, dogwalkers
	contain the words present in the list i.e. 's','dog','walker','baby', and 'my' and
	both are of the same length.
	Output Format:
	For the given list of 'N' words, print all such words in lexico-graphical order.
	Sample input:
	5
test
tester
testertest
testing
testingtester
Sample output:
testingtester
Explanation:
Here in the given list of words, you can see that the words testingtester contains
both the words present in the list i.e. 'test','tester' and 'testing'.
Sample input:
11
cat
banana
dog
nana
my
walk
walker
baby
dogwalkers
s
babymybaby
Sample Output:
babymybaby dogwalkers
Sample input 5:
7
This
is
example
an
anexample
Thisisanexample
Thisistheexample
Sample output:
Thisisanexample
Sample input 6:
3
Hello
Hi
HelloHi
Sample output:
HelloHi
	 */
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Longest_Word
{
	public static boolean isBreakable(String word, int startIndex, HashSet<String> Set)
	{
		if(startIndex == word.length())
		{
			return true;
		}

		for(int i = 0; i < word.length(); i++)
		{
			String subString = "";
			for(int j = startIndex; j < i + 1; j++)
			{
				subString += word.charAt(j);
			}

			if(startIndex == 0 && i == word.length() - 1)
			{
				continue;
			}
			else if(Set.contains(subString) == false)
			{
				continue;
			}


			if(isBreakable(word, i + 1, Set))
			{
				return true;
			}
		}
		return false;
	}

	public static String[] findLongestWordList(String[] wordList)
	{
		Arrays.sort(wordList, new Comparator < String > () {
			public int compare(String one, String two) {
				int val = two.length() - one.length();
				if (val == 0)
					val = one.compareToIgnoreCase(two);
				return val;
			}
		});

		HashSet<String> Set = new HashSet<>();

		for (String word : wordList)
		{
			Set.add(word);
		}

		ArrayList<String> result = new ArrayList<>();
		String prevMaxLengthWord = "";

		for (String word : wordList)
		{
			if (prevMaxLengthWord.length() <= word.length() && isBreakable(word, 0, Set))
			{
				if (result.contains(word) == false)
				{
					prevMaxLengthWord = word;
					result.add(word);
				}
			}
		}

		Collections.sort(result);
		String[] ans = new String[result.size()];
		ans = result.toArray(ans);
		return ans;
	}
}
