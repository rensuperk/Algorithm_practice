package atOffer;

/**
 * 跳台阶
 * 题目描述
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
public class JumpFloor {
    /**
     *其实也是个裴波那切数列的问题
     * 如果一个青蛙第一次跳1级，那么就剩下f(n-1)种跳法
     * 如果一个青蛙第一次跳2级，那么就剩下f(n-2)种跳法
     * 所以f(n) = f(n-1) + f(n-2)
     */
    public int JumpFloor(int target) {
        if(target < 2){
            return target;
        }
        int fone = 1;
        int ftwo = 0;
        int fn =0;
        for (int i = 1; i <= target; i++) {
            fn = fone + ftwo;
            ftwo = fone;
            fone = fn;
        }
        return fn;
    }
}
