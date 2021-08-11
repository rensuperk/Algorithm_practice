//在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个
//整数，判断数组中是否含有该整数。
//
//
//
// 示例:
//
// 现有矩阵 matrix 如下：
//
//
//[
//  [1,   4,  7, 11, 15],
//  [2,   5,  8, 12, 19],
//  [3,   6,  9, 16, 22],
//  [10, 13, 14, 17, 24],
//  [18, 21, 23, 26, 30]
//]
//
//
// 给定 target = 5，返回 true。
//
// 给定 target = 20，返回 false。
//
//
//
// 限制：
//
// 0 <= n <= 1000
//
// 0 <= m <= 1000
//
//
//
// 注意：本题与主站 240 题相同：https://leetcode-cn.com/problems/search-a-2d-matrix-ii/
// Related Topics 数组 二分查找 分治 矩阵
// 👍 415 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class FindNumberIn2DArray_240 {

    public static void main(String[] args) {
        FindNumberIn2DArray_240 findNumberIn2DArray_240 = new FindNumberIn2DArray_240();
        int[][] matrix = {{1,1}};
        System.out.println(findNumberIn2DArray_240.findNumberIn2DArray(matrix,2));
    }
    //注意x是横坐标,y是纵坐标,我弄反了好几次
    //还可以写个递归版本的,不过一般情况尽量少写递归
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int x = 0; int y = matrix.length-1;
        while (y >=0 && x < matrix[0].length){
            if (matrix[y][x] > target){
                y--;
            }else if (matrix[y][x]< target){
                x++;
            }else{
                return true;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
