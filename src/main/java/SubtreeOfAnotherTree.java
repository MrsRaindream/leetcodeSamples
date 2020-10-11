
/**
 * https://leetcode.com/problems/subtree-of-another-tree/
 * 572. Subtree of Another Tree
 * Given two non-empty binary trees s and t,
 * check whether tree t has exactly the same structure and node values with a subtree of s.
 * A subtree of s is a tree consists of a node in s and all of this node's descendants.
 * The tree s could also be considered as a subtree of itself.
 *
 * Example 1:
 * Given tree s:
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 * Given tree t:
 *    4
 *   / \
 *  1   2
 * Return true, because t has the same structure and node values with a subtree of s.
 */
public class SubtreeOfAnotherTree {

    public static void main(String[] args) {
        Node s = new Node(3);
        s.right = new Node(5);
        s.left = new Node(4);
        s.left.left = new Node(1);
        s.left.right = new Node(2);

        Node t = new Node(4);
        t.left = new Node(1);
        t.right = new Node(2);

        System.out.println(checkForSubtree(s, t));
    }

    public static boolean checkForSubtree(Node s, Node t) {
        if (checkForTheSame(s, t)) {
            return true;
        }
        return checkForSubtree(s.left, t) || checkForSubtree(s.right, t);
    }

    private static boolean checkForTheSame(Node s, Node t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        if (s.value != t.value) {
            return false;
        }
        return checkForTheSame(s.left, t.left) && checkForTheSame(s.right, t.right);
    }

    public static class Node {
        public Node right;
        public Node left;
        public int value;

        public Node(int val) {
            this.value = val;
        }
    }

}
