package atOffer;

import javax.xml.transform.Source;

/**
 * 题目描述
 * 输入某二叉树的前序遍历和中序遍历的结果，
 * 请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 * <p>
 * <p>
 * 前序遍历：根节点->左子树->右子树
 * 中序遍历：左子树->根节点->右子树
 * 后序遍历：左子树->右子树->根节点
 */
public class DefinitionForBinaryTree {
    /**
     * Definition for binary tree
     */
   /* public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }*/
    public static void main(String[] args) {
        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] end = {4, 7, 2, 1, 5, 3, 8, 6};
        DefinitionForBinaryTree tree = new DefinitionForBinaryTree();
        TreeNode treeNode = tree.reConstructBinaryTree(pre, end);
        treeNode.preOrder(treeNode);
    }

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        TreeNode root = reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
        return root;
    }
    private TreeNode reConstructBinaryTree(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {
        if (startPre > endPre || startIn > endIn) {
            return null;
        }
        TreeNode root = new TreeNode(pre[startPre]);
        for (int i = startIn; i <= endIn; i++) {
            if (in[i] == pre[startPre]) {
                root.left = reConstructBinaryTree(pre, startPre + 1, startPre + i - startIn, in, startIn, i - 1);
                root.right = reConstructBinaryTree(pre, i - startIn + startPre + 1, endPre, in, i + 1, endIn);
            }
        }
        return root;
    }
}
