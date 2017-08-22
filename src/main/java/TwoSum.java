import java.util.HashMap;
import java.util.Map;

/**
 *
 * Given an array of integers, find two numbers such that they add up to a specific target number.

 The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

 You may assume that each input would have exactly one solution.

 Input: numbers={2, 7, 11, 15}, target=9
 Output: index1=1, index2=2
 *
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] a = {2, 7, 11, 15};
        int target = 17;
        TwoSum twoSum = new TwoSum();
        twoSum.TwoSum(a,target);
    }
    public int TwoSum(int[] a,int target){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            map.put(a[i],i+1);
        }
        int index1 = 0;
        int index2 = 0;
        for (int i : a) {
            int j = target - i;
            if(map.get(j) != null){
                index1 = map.get(i);
                index2 = map.get(j);
                System.out.println("index1 = " + index1 + " , index2 = " + index2);
                break;
            }
        }
        return 0;
    }
}
