package atOffer;

/**
 * 题目描述
 操作给定的二叉树，将其变换为源二叉树的镜像。
 左子树变成右子树，右子树变成左子树，为啥一看到树了我就想用递归呢
 思路就是翻转翻转
 */
public class Mirror {
    public void Mirror(TreeNode root) {
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            return;
        }
        TreeNode temp = root.left;
        root.left=root.right;
        root.right = temp;
        Mirror(root.left);
        Mirror(root.right);
    }
}
