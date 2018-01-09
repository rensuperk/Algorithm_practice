package atOffer;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
    TreeNode(int x,TreeNode left,TreeNode right) {
        val = x;
        this.left = left;
        this.right = right;
    }



    /**
     * 前序遍历
     * @param treeNode
     */
    public  void preOrder(TreeNode treeNode){
        if (treeNode != null) {
            System.out.println("node.val = " + treeNode.val);
//            System.out.println("node.left = " + (treeNode.left == null ? "null" :treeNode.left.val));
//            System.out.println("node.right = " + (treeNode.right == null ? "null" :treeNode.right.val));
            preOrder(treeNode.left);
            preOrder(treeNode.right);
        }
    }
    /**
     * 中序遍历
     * @param treeNode
     */
    public  void midOrder(TreeNode treeNode){
        if (treeNode != null) {
            midOrder(treeNode.left);
            System.out.println(treeNode.val);
            midOrder(treeNode.right);
        }
    }
    /**
     * 后序遍历
     * @param treeNode
     */
    public  void afterOrder(TreeNode treeNode){
        if (treeNode != null) {
            afterOrder(treeNode.left);
            afterOrder(treeNode.right);
            System.out.println(treeNode.val);
        }
    }

    public static void main(String[] args) {
        TreeNode top = new TreeNode(1);
        top.left = new TreeNode(2);
        top.right = new TreeNode(3);
        top.left.left = new TreeNode(4);
        top.left.left.right = new TreeNode(5);
        top.left.right = new TreeNode(6);
        top.left.right.left = new TreeNode(7);
        top.preOrder(top);
        top.midOrder(top);
        top.afterOrder(top);

    }
}
