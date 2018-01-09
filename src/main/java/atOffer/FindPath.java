package atOffer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 题目描述
 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 */
public class FindPath {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10, new TreeNode(5, new TreeNode(4), new TreeNode(7)), new TreeNode(12));
        FindPath findPath = new FindPath();
        ArrayList<ArrayList<Integer>> arrayLists = findPath.FindPath(root, 22);
        for (ArrayList<Integer> arrayList : arrayLists) {
            for (Integer integer : arrayList) {
                System.out.print(integer + ",");
            }
            System.out.println();
        }
    }
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        if(root == null){
        return lists;
    }
    FindPath(root,target,new Stack<Integer>(),lists);
        return lists;
}
    private void FindPath(TreeNode root, int cur, Stack<Integer> stack, ArrayList<ArrayList<Integer>> lists) {
        cur -= root.val;
        stack.push(root.val);
        boolean isLeaf = root.left == null && root.right == null;
        if(isLeaf && 0 == cur){
            ArrayList<Integer> re = new ArrayList<>();
            re.addAll(stack);
            lists.add(re);
        }
        if(root.left != null){

            FindPath(root.left,cur,stack,lists);
        }
        if(root.right != null){

            FindPath(root.right,cur,stack,lists);
        }

        stack.pop();
        cur += root.val;
    }
}
