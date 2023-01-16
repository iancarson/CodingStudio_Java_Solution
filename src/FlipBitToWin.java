public class FlipBitToWin {
	/*
	You are given an integer, get the binary representation of the integer, flip a zero
	that will give a maximum continous number of 1s. Return the value of the binary representation.
	Sample Input 1:
	1775
	Sample Output 1:
	8
	Explanation for Sample Input 1:
	1775 in binary is 11011101111. If we flip the 4th bit from right, we get 8 consecutive 1s which is the maximum number of 1s possible.
	Sample Input 2:
	54
	Sample Output 2:
	5:
	Explanation for Sample Input 2:
	The binary representation of 54 is 110110. if we flip the third bit from the left,
	we get consecutive 5 bits. i.e 111110.
	Sample Input 3:
	12
	Sample Output 3:
	3
	Sample Input 4:
	15
	Sample Output 4:
	4.
	Explanation for Sample Input 4:
	The binary representation of 15 is 1111. There is no need to flip any bit as all the bits are already 1s.
	 */

		public static int flipBit(int a) {
			// Write your code here.
			String binary = Integer.toBinaryString(a);
			int max = 0;
			int count = 0;
			int prev = 0;
			for (int i = 0; i < binary.length(); i++) {
				if (binary.charAt(i) == '1') {
					count++;
				} else {
					prev = count;
					count = 0;
				}
				max = Math.max(max, prev + count + 1);
			}
			return max;
		}

}
