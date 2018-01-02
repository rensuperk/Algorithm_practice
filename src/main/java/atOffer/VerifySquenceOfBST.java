package atOffer;

/**
 * 题目描述
 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
public class VerifySquenceOfBST {

    public static void main(String[] args) {
        int[] a = {8,9,6,12,16,14,10};
        VerifySquenceOfBST verifySquenceOfBST = new VerifySquenceOfBST();
        boolean b = verifySquenceOfBST.VerifySquenceOfBST(a);
        System.out.println(b);
    }
    /**
     *BST的后序序列的合法序列是，对于一个序列S，最后一个元素是x （也就是根），如果去掉最后一个元素的序列为T，那么T满足：T可以分成两段，前一段（左子树）小于x，后一段（右子树）大于x，且这两段（子树）都是合法的后序序列。完美的递归定义 : ) 。
     *
     * 分析：搜索二叉树的特点是左子树都小于右子树，小于根节点，右子树大于根节点大于右子树。
     * 那么就可以用最后一个数字作为根节点，搜索前面n位都比跟节点小，后面m位都比根节点大，如果没有的话，那么就返回false
     * @param sequence
     * @return
     */
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence == null || sequence.length == 0){
            return false;
        }

        return VerifySquenceOfBST(sequence,0,sequence.length-1);
    }
    private boolean VerifySquenceOfBST(int [] sequence,int m,int n){
        System.out.println("m = " + m + ",k = " + n);
        if( m >= n){
            return true;
        }
        int root = sequence[n];
        int i  = m;
        for (; i <= n; i++) {
            if(root < sequence[i]){
                break;
            }
        }
        int j = i;
        for (; j <= n; j++) {
            if(root > sequence[j]){
                return false;
            }
        }
        //玄学修正。。。如果是开始，那说明后面根下面都是右子树，如果是结尾+1，说明根下面都是左子树。。。这个不知道符合不符合题的意思
        if( i == m){
            i++;
        }else if( i == n +1){
            i--;
        }
        System.out.println(" i = " + i);
        return VerifySquenceOfBST(sequence,m,i-1) && VerifySquenceOfBST(sequence,i,n-1);
    }
}
