package atOffer;

/**
 * 题目描述
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 * 刚开始的时候没有思路,二进制的位运算，与运算的结果如果是1那么就是1
 *如果是负数的话，右移操作可能会有问题
 */
public class NumberOf1 {

    /**
     * 如果传的是个负数的话，可能就会死循环
     * @param n
     * @return
     */
    public int NumberOf1(int n) {
        int count = 0;
        while (n > 0){
            if((n & 1 )== 1){
                count++;
            }
            n = n>>1;
        }
        return count;
    }

    /**
     * 这个只需要查询32次
     * @param n
     * @return
     */
    public int NumberOf2(int n) {
        int count = 0;
        int flag = 1;
        while (flag != 0){
            if((n & flag )== flag){
                count++;
            }
            flag = flag << 1;
        }
        return count;
    }

    /**
     * 把一个整数减去1，都是把最右边的1变成0。如果它的右边还有0的话，所有的0都变成1，而它左边所有位都保持不变。接下来我们把一个整数和它减去1的结果做位与运算，相当于把它最右边的1变成0。还是以前面的1100为例，它减去1的结果是1011。我们再把1100和1011做位与运算，得到的结果是1000。我们把1100最右边的1变成了0，结果刚好就是1000。
     * @param n
     * @return
     */
    public int NumberOf3(int n) {
        int count = 0;
        while (n != 0){
            count++;
            n = (n-1)&n;
        }
        return count;
    }
}
