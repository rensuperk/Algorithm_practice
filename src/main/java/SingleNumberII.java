/**
 * Single Number II
 Given an array of integers, every element appears three times except for one. Find that single one.

 Note:
 Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 用{one}记录到当前处理的元素为止，二进制1出现“1次”（mod 3 之后的 1）的有哪些二进制位；
 用{two}记录到当前计算的变量为止，二进制1出现“2次”（mod 3 之后的 2）的有哪些二进制位。
 当{one}和{two}中的某一位同时为1时表示该二进制位上1出现了3次，此时需要清零。即\textbf{用二进制模拟三进制运算}。
 最终{one}记录的是最终结果。
 这个没有看懂
 */
public class SingleNumberII {
    int singleNumberII(int[] A){
        int n = A.length;
        int one = 0, two = 0, three = 0;
        for (int i = 0; i < n; ++i) {
            //或
            two |= (one & A[i]);
            //异或
            one ^= A[i];
            //非与
            three = ~(one & two);
            one &= three;
            two &= three;
        }

        return one;
    }
}
