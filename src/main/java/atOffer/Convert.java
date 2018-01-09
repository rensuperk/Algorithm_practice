package atOffer;

/**
 * 题目描述
 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class Convert {

    public static void main(String[] args) {
        int[] a = {10,6,14,4,8,12,16};
        TreeNode treeNode1 = new TreeNode(10);
        TreeNode treeNode2 = new TreeNode(6);
        TreeNode treeNode3 = new TreeNode(14);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(8);
        TreeNode treeNode6 = new TreeNode(12);
        TreeNode treeNode7 = new TreeNode(16);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode3.left = treeNode6;
        treeNode3.right = treeNode7;
        Convert convert = new Convert();
        TreeNode convert1 = convert.Convert(treeNode1);
        while (convert1 != null && convert1.right != null){
            System.out.println(convert1.val);
            convert1 = convert1.right;
        }

    }
    /**
     * 二叉搜索树是一种排序的数据结构，所以不需要判断顺序问题，在搜索二叉树中，左节点的值总是小于父节点的值，右节点的值总是大于父节点的值
     * 题目要求是排序，所以我们需要中序遍历来遍历二叉树
     * @param pRootOfTree
     * @return
     */


        TreeNode head = null;
        TreeNode realHead = null;
    public TreeNode Convert(TreeNode pRootOfTree) {
        ConvertSub(pRootOfTree);
        return realHead;
    }
     
    private void ConvertSub(TreeNode pRootOfTree) {
        if(pRootOfTree==null) return;
        ConvertSub(pRootOfTree.left);
        if (head == null) {
            head = pRootOfTree;
            realHead = pRootOfTree;
        } else {
            head.right = pRootOfTree;
            pRootOfTree.left = head;
            head = pRootOfTree;
        }
        ConvertSub(pRootOfTree.right);
    }
}
