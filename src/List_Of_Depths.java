import java.util.LinkedList;
import java.util.Queue;

public class List_Of_Depths {
	class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;

		TreeNode(int data) {
			this.data = data;
			left = null;
			right = null;
		}
	}
	class Node
	{
		int data;
		Node next;
		Node child;
		Node(int data)
		{
			this.data = data;
			this.next = null;
			this.child = null;
		}
	}
	/*
	You are Given a binary tree. Your task is to convert this binary tree into
	a LinkedList, such that the value at nodes is in the level
	order form.
	Output Format:
	Just return the Pointer to the head node of the Linked List,
	no need to print anything.
	Sample Input 1:
	2
3 5 1 -1 -1 -1 -1
15 40 62 -1 -1 10 20 -1 -1 -1 -1
Sample Output 1:
3 5 1
15 40 62 10 20
Sample Input 2:
2
9 1 17 -1 14 9 -1 -1 -1 -1 -1
3 14 -1 4 -1 14 -1 12 -1 -1 -1
Sample Output 2:
9 1 17 14 9
3 14 4 14 12
	 */
	 class Solution {
		public Node listOfDepth(TreeNode root) {
			// Write your code here.
			if (root == null) {
				return null;
			}
			Queue<TreeNode> queue = new LinkedList<>();
			queue.add(root);
			Node head = null;
			Node tail = null;
			while (!queue.isEmpty()) {
				int size = queue.size();
				for (int i = 0; i < size; i++) {
					TreeNode curr = queue.poll();
					if (curr.left != null) {
						queue.add(curr.left);
					}
					if (curr.right != null) {
						queue.add(curr.right);
					}
					if (head == null) {
						head = new Node(curr.data);
						tail = head;
					} else {
						tail.next = new Node(curr.data);
						tail = tail.next;
					}
				}
			}
			return head;
		}
	}


}
