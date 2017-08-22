import java.util.Arrays;
import java.util.Set;

/**
 * 3Sum Closest
 Given an array S of n integers, find three integers in S such that the sum is closest to a given number,
 target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

 For example, given array S = {-1 2 1 -4}, and target = 1.

 The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

 解析：
 先排序，再夹逼
 */
public class ThreeSumClosest {
    public static void main(String[] args) {
        ThreeSumClosest threeSum = new ThreeSumClosest();
        int i = threeSum.ThreeSumClosest(new int[]{-1, 2, 1, -4}, 1);
        System.out.println(i);

    }
    public int ThreeSumClosest(int[] a ,int target){
        Arrays.sort(a);
        int result = 0;
        int mingap = Integer.MAX_VALUE;
        for (int i = 0; i < a.length; i++) {
            int k = i+1;
            int j = a.length-1;
            while (k < j){
                int sum = a[i]+a[k]+a[j];
                int gap =Math.abs(target - sum);
                if(gap < mingap){
                    result = sum;
                    mingap = gap;
                }
                if(sum < target) k++;
                else j--;
            }
        }
        return result;
    }
}
