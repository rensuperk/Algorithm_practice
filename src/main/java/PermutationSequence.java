import java.util.ArrayList;
import java.util.List;

/**
 * Permutation Sequence
 * The set [1,2,3,…,n] contains a total of n! unique permutations.
 * <p>
 * By listing and labeling all of the permutations in order,
 * We get the following sequence (ie, for n = 3):
 * <p>
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * Given n and k, return the kth permutation sequence.
 * <p>
 * Note: Given n will be between 1 and 9 inclusive.
 * <p>
 * 解析：
 * 给一个数组，求出第n个排列
 * 第一个数确定，有（n-1）！个排列，
 * 反推回来，要求第n个排列,
 */
public class PermutationSequence {
    public String PermutationSequence(int n, int k) {
        //数组开始
        k--;//to transfer it as begin from 0 rather than 1
        List<Integer> numList = new ArrayList<Integer>();
        //将数字添加进列表
        for (int i = 1; i <= n; i++)
            numList.add(i);

        int factorial = 1;
        //计算总的排序 （n-1）！
        for (int i = 2; i < n; i++)
            factorial *= i;

        StringBuilder res = new StringBuilder();
        int times = n - 1;
        while (times >= 0) {
            //计算最高位的index
            int indexInList = k / factorial;
            res.append(numList.get(indexInList));
            numList.remove(indexInList);
            //剩余的继续计算
            k = k % factorial;//new k for next turn
            if (times != 0)
                factorial = factorial / times;//new (n-1)!

            times--;
        }

        return res.toString();
    }

}
