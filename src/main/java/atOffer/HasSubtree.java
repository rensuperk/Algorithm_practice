package atOffer;

/**
 * 题目描述
 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */
public class HasSubtree {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if(root1 == null || root2 == null){
            return false;
        }
        //相等或者不相等，不相等就比较左子树和右子树
        return isSubtree(root1,root2) || HasSubtree(root1.left,root2) || HasSubtree(root1.right,root2);
    }
    public boolean isSubtree(TreeNode root1,TreeNode root2) {
        //遍历空了说明上面的都相等，那么就说明就是子树，返回true
        if(root2 == null){
            return true;
        }
        if(root1 == null ){
            return false;
        }

       if(root1.val == root2.val){
            return isSubtree(root1.left,root2.left) && isSubtree(root1.right,root2.right);
       }else{
           return false;
       }
    }
}
