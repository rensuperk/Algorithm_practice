/**
 *Follow up for “Search in Rotated Sorted Array”:
 What if duplicates are allowed?

 Would this affect the run-time complexity? How and why?

 Write a function to determine if a given target is in the array.

 分析
    如果数组有重复的情况，那顺序就不行了,同时注意两个边界，怎么算的我也不知道
 */
public class SearchinRotatedSortedArrayII {
    public static void main(String[] args) {
    }
    static boolean searchinRotatedSortedArrayII(int[] A, int target){
        int first = 0, last = A.length;
        while (first != last) {
             int mid = (first + last) / 2;
            if (A[mid] == target)
            return true;
            if (A[first] < A[mid]) {
                if (A[first] <= target && target < A[mid])
                last = mid;
                else
                first = mid + 1;
            } else if (A[first] > A[mid]) {
                if (A[mid] < target && target <= A[last-1])
                first = mid + 1;
                else
                last = mid;
            } else
            //skip duplicate one
            first++;
        }
        return false;
    }
}
