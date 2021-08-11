//把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2
//] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。
//
// 示例 1：
//
// 输入：[3,4,5,1,2]
//输出：1
//
//
// 示例 2：
//
// 输入：[2,2,2,0,1]
//输出：0
//
//
// 注意：本题与主站 154 题相同：https://leetcode-cn.com/problems/find-minimum-in-rotated-sor
//ted-array-ii/
// Related Topics 数组 二分查找
// 👍 376 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class MinArray_154 {
    //    public int minArray(int[] numbers) {
    //        for (int i = 1; i < numbers.length; i++) {
    //            if (numbers[i]<numbers[i-1]) {
    //                return numbers[i];
    //            }
    //        }
    //        return numbers[0];
    //    }
    //二分查找,要和有边界比较,左边接没有意义
        public int minArray(int[] numbers) {
           int low = 0;
           int high = numbers.length-1;
           while (low< high){
               int mid = low+(high-low)/2;
               if (numbers[mid] > numbers[high]){
                   low = mid+1;
               }else if (numbers[mid] < numbers[high]){
                   high = mid;
               }else {
                    high-=1;
               }
           }
           return numbers[low];
        }
    public static void main(String[] args) {
        MinArray_154 a = new MinArray_154();
        int[] nums = {1,3,3};
        a.minArray(nums);

    }

}
//leetcode submit region end(Prohibit modification and deletion)
