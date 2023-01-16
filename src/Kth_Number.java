public class Kth_Number {
	/*
	Find the kth Element in a list of given elements(array) comprising of only
	3,5, and 7 as their prime factors. Return the kth element in the list.
	Sample Input1:
	'K' = 10
	Sample Output1:
	Output: 45
	Explanation: The list of elements will comprise of 3,5,7,9,15,21,25,27,35,45,49
	Sample Input2:
	'K' = 5
	Sample Output2:
	Output: 15
	Sample Input3:
	'K' = 9
	Sample Output3:
	Output: 35
	 */
	public static int kthElement(int k) {
		int a = 0, b = 0, c = 0;
		int[] elements = new int[k];

		if (k > 0) elements[0] = 3;  // fix: handle k = 1
		if (k > 1) elements[1] = 5;  // fix: handle k = 2
		if (k > 2) elements[2] = 7;  // fix: handle k = 3

		for (int i = 3; i < k; i++) {
			int next = Math.min(Math.min(elements[a] * 3, elements[b] * 5), elements[c] * 7);
			elements[i] = next;
			if (next == elements[a] * 3) a++;
			if (next == elements[b] * 5) b++;
			if (next == elements[c] * 7) c++;
		}

		return elements[k-1];
	}

	public static void main(String[] args) {
		System.out.println(kthElement(1));   // 3
		System.out.println(kthElement(2));   // 5
		System.out.println(kthElement(3));   // 7
		System.out.println(kthElement(10));  // 45
		System.out.println(kthElement(5));   // 15
		System.out.println(kthElement(9));   // 35
		System.out.println(kthElement(4)); // 105
	}

}
