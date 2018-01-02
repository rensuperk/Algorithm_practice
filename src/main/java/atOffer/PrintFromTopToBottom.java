package atOffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 题目描述
 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */
public class PrintFromTopToBottom {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        Queue<TreeNode> temp =  new LinkedList<>();
        temp.offer(root);
        while (!temp.isEmpty()){
            TreeNode poll = temp.poll();
            if(poll.left != null){
                temp.offer(poll.left);
            }
            if(poll.right != null){
                temp.offer(poll.right);
            }
            list.add(poll.val);
        }
        return list;
    }
}
