package atOffer;

/**
 * The lookup of two dimensional array 二维数组的查找
 * 时间限制：1秒 空间限制：32768K
 * 题目描述
 * 在一个二维数组中，
 * 每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class FindI {

    public static void main(String[] args) {
        int [][] array ={{1,2,8,9},{4,7,10,13}};
        int [][] array1 ={{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        int target = 5;
        FindI findI = new FindI();
        findI.Find(target,array1);
    }
    public boolean Find(int target, int [][] array) {
        if(array == null){
            return false;
        }
        int rows = array.length;
        if(rows == 0){
            return false;
        }
        int columns = array[0].length;
        if(columns == 0){
            return false;
        }
        int row = 0;
        int column =columns -1;
        while (row < rows && column >= 0){
            System.out.println("array[row][column] = " +array[row][column] + ",row = " + row + ",column = " + column);
            if(target  == array[row][column]){
                return true;
            }
            if(target < array[row][column]){
                column--;
                continue;
            }
            if(target > array[row][column]){
                row++;
                continue;
            }

        }
        return false;
    }
}
