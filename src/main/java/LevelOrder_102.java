//给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
//
//
//
// 示例：
//二叉树：[3,9,20,null,null,15,7],
//
//
//    3
//   / \
//  9  20
//    /  \
//   15   7
//
//
// 返回其层序遍历结果：
//
//
//[
//  [3],
//  [9,20],
//  [15,7]
//]
//
// Related Topics 树 广度优先搜索 二叉树
// 👍 964 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.TooManyListenersException;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
@Slf4j
@Data
public class LevelOrder_102 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

//    public static void main(String[] args) {
//        LevelOrder_102 levelOrder_102 = new LevelOrder_102();
//        //[3,9,20,null,null,15,7],
//        TreeNode root = new TreeNode(3);
//        root.left = new TreeNode(9);
//        root.right = new TreeNode(20);
//        root.right.left = new TreeNode(15);
//        root.right.right = new TreeNode(7);
//        List<List<Integer>> lists = levelOrder_102.levelOrder(root);
//        log.info("result={}",lists);
//    }
    public static void main(String[] args) {
        LevelOrder_102 levelOrder_102 = new LevelOrder_102();
        //[3,9,20,null,null,15,7],
        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(9);
//        root.right = new TreeNode(20);
//        root.right.left = new TreeNode(15);
//        root.right.right = new TreeNode(7);
        List<List<Integer>> lists = levelOrder_102.levelOrder(root);
        log.info("result={}",lists);
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode end = root;
        TreeNode nextEnd = null;
        List<Integer> top = new ArrayList<>();
        result.add(top);
        while (!queue.isEmpty()){
            TreeNode cur = queue.poll();
            top.add(cur.val);
            if (cur.left != null){
                queue.add(cur.left);
                nextEnd = cur.left;
            }
            if (cur.right != null){
                queue.add(cur.right);
                nextEnd = cur.right;
            }
            //下一层没有值,防止多生成一个list
            if (cur == end && nextEnd != null && end != nextEnd ){
                top = new ArrayList<>();
                result.add(top);
                end = nextEnd;
            }
        }
        return result;
    }
}
