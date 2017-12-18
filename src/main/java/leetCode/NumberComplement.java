package leetCode;

/**
 * Created by renkai on 2017/4/7.
 */
public class NumberComplement {
    /**
     *思路,从高到底的遍历
     * 和同位数的1与计算,结果相同就改为false
     * 如果是true的话就是1,再与同位数的1异或计算就可以了
     *
     * @param num
     * @return
     */
    public static int findComplement(int num) {
        int res = num;
        boolean flag = true;
        for (int i = 31; i >= 0; i--) {
            if((num &(1<<i)) == (1<<i)){
                flag = false;

            }
            if(!flag){
                res ^= 1<<i;
            }
        }
        return res;
    }

    /**
     * 从num最低位开始翻转
     * 当前值小于等于1的时候停止
     *
     * @param num
     * @return
     */
    public static int findComplement2(int num) {
        int n = 1 - num % 2;
        return n + 2*(num <= 1 ? 0 : findComplement2(num / 2));
    }
    /**
     * 从num最低位开始翻转
     * 当前值小于等于1的时候停止
     *
     * @param num
     * @return
     */
    public static int findComplement3(int num) {
        int temp = num, mask = 1;
         while(temp > 0){
                 temp >>= 1;
                 mask <<= 1;
             }
        return ((mask - 1) ^ num);
    }

    public static void main(String[] args) {
        int num = 5;
        System.out.println(findComplement(num));
        System.out.println(findComplement2(num));
        System.out.println(findComplement3(num));
    }
}
