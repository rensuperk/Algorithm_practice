package leetCode;import java.util.HashMap;
import java.util.Map;

/**
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

 For example,
 Given [100, 4, 200, 1, 3, 2],
 The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

 Your algorithm should run in O(n) complexity.
 */
public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] ints = {100, 4, 200, 1, 3, 2};
        LongestConsecutiveSequence sequence = new LongestConsecutiveSequence();
        int i = sequence.LongestConsecutiveSequence(ints);
        System.out.println(i);
    }
    public int LongestConsecutiveSequence(int[] a ){
        Map<Integer, Boolean> used = new HashMap<Integer, Boolean>();
        for (int i : a) {
            used.put(i,false);
        }
        int longest  = 0;
        for (int i : a) {
            if(used.get(i)) continue;
            int length = 1;
            used.put(i,true);
            for (int j = i+1; used.get(j) != null && used.get(j); j++) {
                used.put(j,true);
                length ++ ;
            }
            for (int j = i-1; used.get(j) != null && used.get(j); j--) {
                used.put(j,true);
                length ++ ;
            }
            longest = Math.max(longest,length);
        }
        return longest;
    }
}
