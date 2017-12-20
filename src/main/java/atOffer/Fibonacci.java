package atOffer;

/**
 * 题目描述
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项。
 * n<=39
 */
public class Fibonacci {
    /**
     * 默认的裴波那切数列
     * 但是效率很低，随着n的增大，下面有很多的重复计算，所以计算效率很低
     * @param n
     * @return
     */
    public int Fibonacci(int n) {
        if(n <= 0){
            return 0;
        }
        if( n ==1 ){
            return 1;
        }
        return Fibonacci(n-1) + Fibonacci(n-2);
    }

    /**
     * 暂存中间数据的
     * @param n
     * @return
     */
    public int Fibonacci1(int n) {
        if(n <= 0){
            return 0;
        }
        if( n ==1 ){
            return 1;
        }
        int fOne = 1;
        int fTwn = 0;
        int fn = 0;
        for (int i = 2; i <= n; i++) {
            fn = fOne + fTwn;
            fTwn = fOne;
            fOne = fn;
        }
        return fn;
    }
}
