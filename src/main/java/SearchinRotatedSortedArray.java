/**
 * Search in Rotated Sorted Array
 Suppose a sorted array is rotated at some pivot unknown to you beforehand.

 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

 You are given a target value to search. If found in the array return its index, otherwise return -1.

 You may assume no duplicate exists in the array.

 标签: Array Binary Search

 分析
    确定两个边界
 */
public class SearchinRotatedSortedArray {
    public static void main(String[] args) {
        System.out.println(7/2);
        System.out.println(searchinRotatedSortedArray(new int[]{0,1,2,3,4,5,6,7},8));
        System.out.println(searchinRotatedSortedArray(new int[]{5,6,7,8,0,1,2,3,4},7));
    }
    static int searchinRotatedSortedArray(int[] nums,int target){
        if(nums.length == 0 )return -1;
        return searchinRotatedSortedArray(nums,0,nums.length-1,target);
    }
    static int searchinRotatedSortedArray(int[] nums,int start,int last,int target){
        int m = (start+last)/2;
        if(nums[m] == target) return m;
        if(start >= last) return  -1;
        if(nums[last] > nums[m]){//后半部分是顺序的
            if(target > nums[m] && target <= nums[last]){
                return searchinRotatedSortedArray(nums,m+1,last,target);
            }else {
                return searchinRotatedSortedArray(nums,start,m-1,target);
            }
        }else {//前半部分是顺序的
            if(target >= nums[start] && target < nums[m]){
                return searchinRotatedSortedArray(nums,start,m-1,target);
            }else {
                return searchinRotatedSortedArray(nums,m+1,last,target);
            }
        }
    }
}
