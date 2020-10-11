/**
 * https://leetcode.com/problems/univalued-binary-tree/
 *
 * 965. Univalued Binary Tree
 * A binary tree is univalued if every node in the tree has the same value.
 * Return true if and only if the given tree is univalued.
 *
 * Input: [1,1,1,1,1,null,1]
 * Output: true
 */
public class UnivalTree {

    public static void main(String[] args) {
        Node s = new Node(1);
        s.right = new Node(1);
        s.left = new Node(1);
        s.left.left = new Node(1);
        s.left.right = new Node(2);

        boolean result = isUnivalTree(s);
        System.out.println(result);
    }

    public static boolean isUnivalTree(Node root) {
        if (root == null) {
            return true;
        }

        return ((root.left == null || root.value == root.left.value && isUnivalTree(root.left)) &&
                (root.right == null || root.value == root.right.value && isUnivalTree(root.right)));
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
