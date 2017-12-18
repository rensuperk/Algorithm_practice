package leetCode; /**
 * Remove Duplicates from Sorted Array II
 Follow up for “Remove Duplicates”:
 What if duplicates are allowed at most twice?

 For example,
 Given sorted array A = [1,1,1,2,2,3],

 Your function should return length = 5, and A is now [1,1,2,2,3].
 分析：
    最多允许出现2次重复的
 */
public class RemoveDuplicatesfromSortedArrayII {
    public static void main(String[] args) {
        int[] ints = {1, 1, 1, 2, 2, 3, 3,};
        int i = removeDuplicatesfromSortedArrayII(ints);
        for (int i1 = 0; i1 < i; i1++) {
            System.out.println(ints[i1]);
        }
    }

    /**
     * 没啥思路就是判断
     * @param nums
     * @return
     */
    static int removeDuplicatesfromSortedArrayII(int[] nums){
        if(nums.length <= 2) return nums.length;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if( i>0 &&  i<nums.length -1 && nums[i] == nums[i-1] && nums[index] == nums[i+1]){
                continue;
            }
            nums[index++] = nums[i];
        }

        return index;
    }
    /**
     * 这个比较简洁，既然是排序的，那么显而易见隔两个数相等，三个数就相等
     * @param nums
     * @return
     */
    static int removeDuplicatesfromSortedArrayII2(int[] nums){
        int index = 2;
        for (int i = 2; i < nums.length; i++) {
            if(nums[index-2] != nums[i]){
                nums[index++] = nums[i];
            }
        }

        return index;
    }
}
