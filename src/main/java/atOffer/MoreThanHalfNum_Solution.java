package atOffer;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 题目描述
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。
 * 如果不存在则输出0。
 */
public class MoreThanHalfNum_Solution {

    public static void main(String[] args) {
        MoreThanHalfNum_Solution moreThanHalfNum_solution = new MoreThanHalfNum_Solution();
        int[] a = {1,2,3,2,4,2,2,2,3};
        int i = moreThanHalfNum_solution.MoreThanHalfNum_Solution3(a);
        System.out.println(i);
    }
    public int MoreThanHalfNum_Solution(int [] array) {
        int length = array.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            Integer integer = map.get(array[i]);
            if(integer == null){
                integer=0;
            }
                integer++;
                if(integer > length/2){
                    return array[i];
                }
                map.put(array[i],integer);

        }
        return 0;
    }


    /**
     * 思路排好序，如果有一个数字超过一半，那么就肯定中间的数字
     * 然后再判断中间数字出现的次数。
     * @param array
     * @return
     */
    public int MoreThanHalfNum_Solution2(int [] array) {
        Arrays.sort(array);
        int count=0;
         
        for(int i=0;i<array.length;i++){
            if(array[i]==array[array.length/2]){
                count++;
            }
        }
        if(count>array.length/2){
            return array[array.length/2];
        }else{
            return 0;
        }
         
    }
    /**
     * 一个数字出现的次数超过数组长度的一半，也就是说它出现的次数比其他所有数字出现次数的和还要多。因此我们可以考虑在遍历数组的时候保存两个值：一个是数组中的一个数字，一个是次数。当我们遍历到下一个数字的时候，如果下一个数字和我们之前保存的数字相同，则次数加1；如果下一个数字和我们之前保存的数字不同，则次数减1。如果次数为零，我们需要保存下一个数字，并把次数设为1。由于我们要找的数字出现的次数比其他所有数字出现的次数之和还要多，那么要找的数字肯定是最后一次把次数设为1时对应的数字。
     * @param array
     * @return
     */
    public int MoreThanHalfNum_Solution3(int [] array) {
        int times = 1;
        int res = array[0];

        for(int i=1;i<array.length;i++){
            if(times == 0){
                res=array[i];
                times = 1;
            }else if(res == array[i]){
                times ++ ;
            }else {
                times -- ;
            }
        }
        times = 0;
        for (int i = 0; i < array.length; i++) {
            if(array[i] == res){
                times ++;
            }
        }
        return times>array.length/2 ? res:0;

    }
}
