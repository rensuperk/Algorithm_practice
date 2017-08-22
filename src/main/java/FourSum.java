import groovy.json.JsonOutput;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 4Sum
 Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target?
 Find all unique quadruplets in the array which gives the sum of target.

 Note:

 Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
 The solution set must not contain duplicate quadruplets.
 For example, given array S = {1 0 -1 0 -2 2}, and target = 0.

 A solution set is:
 (-1,  0, 0, 1)
 (-2, -1, 1, 2)
 (-2,  0, 0, 2)
 解析：
    和3sum没啥区别，就是多了一层循环
 */
public class FourSum {
    public static void main(String[] args) {
        FourSum fourSum = new FourSum();
        Set<Integer[]> integers = fourSum.FourSum(new int[]{1, 0, -1, 0, -2, 2}, 0);
        System.out.println(JsonOutput.toJson(integers));
    }
    public Set<Integer[]> FourSum(int[] a ,int target){
        Set<Integer[]> set = new HashSet<>();
        Arrays.sort(a);
        for (int i = 0; i < a.length-3; i++) {
            for (int j = i +1; j < a.length -2; j++) {
                int left = j+1;
                int right = a.length -1;
                while (left < right){
                    if(a[i]+a[j]+a[left]+a[right] == target){
                        set.add(new Integer[]{a[i],a[j],a[left],a[right]} );
                        left++;
                        right--;
                    }else if(a[i]+a[j]+a[left]+a[right] < target){
                        left ++;
                    }else {
                        right --;
                    }
                }
            }
        }
        return set;
    }
}
