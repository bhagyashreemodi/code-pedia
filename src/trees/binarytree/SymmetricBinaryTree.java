package trees.binarytree;


public class SymmetricBinaryTree {

    static class TreeNode<T> {
        public T data;
        public TreeNode<T> left;
        public TreeNode<T> right;

        public TreeNode(T data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String [] args) {
        TreeNode<Integer> root = new TreeNode<>(1);
        //root.left = new TreeNode<>(2);
        System.out.println(isSymmetric(root));
    }

    public static boolean isSymmetric(TreeNode<Integer> root) {
        return root == null || checkSymmetry(root.left, root.right);
    }

    public static boolean checkSymmetry(TreeNode<Integer> subtree0,  TreeNode<Integer> subtree1) {
        if((subtree0 == null && subtree1 == null))
            return true;
        else if(subtree0 != null && subtree1 != null) {
            return subtree0.data == subtree1.data &&
                    checkSymmetry(subtree0.left, subtree1.right) &&
                    checkSymmetry(subtree0.right, subtree1.left);
        }
        return false;
    }

}
