/**
 * You are climbing a stair case. It takes n steps to reach to the top.

 Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 分析：
    一次能爬1到2个阶梯，有多少种爬法能爬到顶
    这是个斐波那契数列
    只需要用裴波那契数列的通项式来计算就行了

 */
public class ClimbingStairs {
    //时间复杂度O(n)，其实有更好的算法
    public int climbStairs(int n) {
        if(n==0||n==1||n==2)
            return n;
        int [] dp = new int[n+1];
        dp[0]=0;
        dp[1]=1;
        dp[2]=2;

        for(int i = 3; i<n+1;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}
