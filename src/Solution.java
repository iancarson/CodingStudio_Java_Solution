
import java.util.* ;
/************************************************************
 Ninja has to implement a binary tree class from scratch. The Ninja can perform
 three types of queries on this binary tree:
 . 'I' 'VAL': In this query, ninja has to insert A Node with the Value 'VAL' in The Binary Tree.
 . 'D' 'VAL': In This query, Ninja has to Delete A Node With the Value 'VAL' From the Binary Tree.
 . 'R': In this Query, ninja has to print A Random Node From The Tree.
 All the Node values in the binary tree are different. All nodes are equally likely to be chosen.
 For Each test case, return the value of the Random node obtained from the get Random
 Node Query.
 Print the Output of each test case in a separate line.
 Sample Input 1:
 1
 5
 I 2
 I 4
 I 5
 D 4
 R
 Sample Output 1:
 Valid answer
 Explanation for Sample Input 1:
 In this sample test case, the random nodes may be 2 or 5 because all nodes should be equally likely to be chosen. So you can print any one of them.
 As the random node returned (here 2) exists in the tree, the output is a “Valid answer.
 ************************************************************/

/*
    Time complexity: O(N)
    Space complexity: O(N)

    Where N denotes the number of nodes in the binary tree.
*/

import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class Solution {

	public static TreeNode<Integer> insertNodeInBinaryTree(TreeNode<Integer> root, int val) {

		if(root == null) {
			root = new TreeNode<Integer>(val);
			return root;
		}

		Queue<TreeNode<Integer>>  queue = new LinkedList<>();
		TreeNode<Integer> temp = root;
		queue.add(temp);

		while(!queue.isEmpty()) {
			TreeNode<Integer> currNode = queue.remove();

			if(currNode.left == null) {
				currNode.left = new TreeNode<Integer>(val);
				return root;

			}

			if(currNode.right == null) {
				currNode.right = new TreeNode<Integer>(val);
				return root;

			}

			queue.add(currNode.left);
			queue.add(currNode.right);


		}

		return null;

	}


	public static void deleteDeepestNode(TreeNode<Integer> root, TreeNode<Integer> deepestNode) {

		Queue<TreeNode<Integer>> queue = new LinkedList<>();
		queue.add(root);

		while(!queue.isEmpty()) {
			TreeNode<Integer> currNode = queue.remove();

			if(currNode == deepestNode) {
				currNode = null;
				return ;
			}

			if(currNode.right != null) {
				if(currNode.right == deepestNode) {
					currNode.right = null;
					return ;
				} else {
					queue.add(currNode.right);
				}

			}

			if(currNode.left != null) {
				if(currNode.left == deepestNode) {
					currNode.left = null;
					return ;
				} else {
					queue.add(currNode.left);
				}

			}
		}

	}


	public static void deleteNodeInBinaryTree(TreeNode<Integer> root, int val) {

		if(root == null) {
			return ;
		}

		if(root.left == root.right) {
			if(root.data == val) {
				root = null;
				return ;
			} else {
				return ;
			}
		}

		Queue<TreeNode<Integer>>  queue = new LinkedList<>();
		queue.add(root);

		TreeNode<Integer> nodeToBeDeleted = null;
		TreeNode<Integer> deepestNode = null;

		while(!queue.isEmpty()) {
			deepestNode = queue.remove();

			if(deepestNode.data == val) {
				nodeToBeDeleted = deepestNode;
			}

			if(deepestNode.left != null) {
				queue.add(deepestNode.left);
			}

			if(deepestNode.right != null) {
				queue.add(deepestNode.right);
			}

		}

		if(nodeToBeDeleted != null) {
			int deepestNodeVal = deepestNode.data;
			deleteDeepestNode(root, deepestNode);
			nodeToBeDeleted.data = deepestNodeVal;
		}

	}

	public static void inorderTraversal(TreeNode<Integer> root, ArrayList<Integer> allNodes) {
		if(root == null) {
			return;
		}

		inorderTraversal(root.left, allNodes);
		allNodes.add(root.data);
		inorderTraversal(root.right, allNodes);
	}

	public static int getRandomNodeInBinaryTree(TreeNode<Integer> root) {

		ArrayList<Integer> allNodes = new ArrayList<>();

		inorderTraversal(root,allNodes);
		int randomIndex = (int)(Math.random()*(allNodes.size()));
		return allNodes.get(randomIndex);

	}

	public static Output implementBinaryTree(int q, ArrayList<Pair> queries) {

		TreeNode<Integer> root = null;
		int randomValue = -1;

		for(int i = 0; i < q; i++) {
			char operation = queries.get(i).operation;
			if(operation == 'I') {
				root = insertNodeInBinaryTree(root, queries.get(i).val);

			} else if(operation == 'D') {
				deleteNodeInBinaryTree(root, queries.get(i).val);

			} else {
				randomValue = getRandomNodeInBinaryTree(root);
			}
		}

		Output answer = new Output();
		answer.root = root;
		answer.randomValue = randomValue;
		return answer;

	}
}


class TreeNode<T> {
		T data;
		TreeNode<T> left;
		TreeNode<T> right;

		TreeNode(T data) {
			this.data = data;
			left = null;
			right = null;
		}
	}


class Pair {
	char operation;
	int val;

	Pair(char operation, int val) {
		this.operation = operation;
		this.val = val;
	}
}

class Output {
	TreeNode<Integer> root = null;
	int randomValue = -1;
}