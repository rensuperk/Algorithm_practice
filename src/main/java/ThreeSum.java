import groovy.json.JsonBuilder;
import groovy.json.JsonOutput;
import groovy.json.internal.JsonFastParser;
import jdk.nashorn.internal.ir.debug.JSONWriter;

import java.util.*;

/**
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.

 Note:

 Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
 The solution set must not contain duplicate triplets.
 For example, given array S = {-1 0 1 2 -1 -4},

 A solution set is:
 (-1, 0, 1)
 (-1, -1, 2)
 */
public class ThreeSum {
    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        threeSum.ThreeSum(new int[] {-1 ,0, 1, 2, -1, -4});
    }
    public Set<Integer[]> ThreeSum(int[] a){
        Set<Integer[]> list = new HashSet<>();
        if(a.length < 3){
            return list;
        }
        Arrays.sort(a);
        for (int i = 0; i < a.length; i++) {
            if(a[i] > 0 ) break;
            if(i > 0 && a[i] == a[i-1]) continue;
            int target = 0 - a[i];
            int k = i+1,j = a.length -1;
            while (k < j){
                if(a[k] + a[j] == target){
                    list.add(new Integer[]{a[i],a[k],a[j]});
                    while ( k < j && a[i] == a[i+1]) i++;
                    while ( k < j && a[j] == a[j-1]) j--;
                    k++;
                    j--;
                }else if(a[k] + a[j] < target){
                    k++;
                }else {
                    j--;
                }
            }
        }
        System.out.println(JsonOutput.toJson(list));
        return list;
    }
}
