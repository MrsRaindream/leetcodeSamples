
/**
 * https://leetcode.com/problems/merge-two-binary-trees/
 *
 * Given two binary trees and imagine that when you put one of them to cover the other,
 * some nodes of the two trees are overlapped while the others are not.
 *
 * You need to merge them into a new binary tree. The merge rule is that if two nodes overlap,
 * then sum node values up as the new value of the merged node.
 * Otherwise, the NOT null node will be used as the node of new tree.
 *
 * Example 1:
 *
 * Input:
 * 	Tree 1                     Tree 2
 *           1                         2
 *          / \                       / \
 *         3   2                     1   3
 *        /                           \   \
 *       5                             4   7
 * Output:
 * Merged tree:
 * 	     3
 * 	    / \
 * 	   4   5
 * 	  / \   \
 * 	 5   4   7
 */
public class MergeTrees {

    public static void main(String[] args) {
        Node s = new Node(3);
        s.right = new Node(5);
        s.left = new Node(4);
        s.left.left = new Node(1);
        s.left.right = new Node(2);

        Node t = new Node(4);
        t.left = new Node(1);
        t.right = new Node(2);

        Node result = mergeTrees(s, t);
        System.out.println(result.value);
        System.out.println(result.left.value);
        System.out.println(result.right.value);

        System.out.println(result.left.left.value);
        System.out.println(result.left.right.value);
    }

    public static Node mergeTrees(Node t1, Node t2) {
        if (t1 == null && t2 == null) {
            return null;
        }

        if (t1 == null) {
            return t2;
        }

        if (t2 == null) {
            return t1;
        }
        return new Node(t1.value + t2.value, mergeTrees(t1.left, t2.left), mergeTrees(t1.right, t2.right));
    }

    public static class Node {
        public Node right;
        public Node left;
        public int value;

        public Node(int val) {
            this.value = val;
        }

        public Node(int val, Node left, Node right) {
            this.value = val;
            this.left = left;
            this.right = right;
        }
    }

}
