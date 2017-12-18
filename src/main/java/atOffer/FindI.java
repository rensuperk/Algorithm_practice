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
    public boolean Find(int target, int [][] array) {
        if(array.length == 0){
            return false;
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if(target == array[i][j]){
                    return true;
                }
            }
        }
        return false;
    }
}
