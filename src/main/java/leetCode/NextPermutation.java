package leetCode;import groovy.json.JsonOutput;

import java.util.Arrays;

/**


 Next Permutation
 Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

 If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

 The replacement must be in-place, do not allocate extra memory.

 Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 1,2,3 → 1,3,2
 3,2,1 → 1,2,3
 1,1,5 → 1,5,1

 解析：
    题目求下一个字典序，如果是最大的字典序，那就回到初始的状态。
    右侧n位为降序的话，只需要将n+1位替换位右侧中比n+1位大1的元素，然后将右侧n位升序排列，就是下一个最大的值
    如果所有位数都是降序排列，那么就倒置数组。
 */
public class NextPermutation {
    public static void main(String[] args) {
        NextPermutation nextPermutation = new NextPermutation();
        int[] ints = nextPermutation.NextPermutation(new int[]{3,2,1,4});
        System.out.println(JsonOutput.toJson(ints));
    }
    public int[] NextPermutation(int[] a){
        if(a.length <= 1) return a;
        int i,j=a.length;
        for (i = a.length-2; i >=0; i--) {
            if(a[i+1] > a[i]){
                for (j = a.length-1; j >= i ; j--) {
                    if(a[j] > a[i]) break;
                }
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                break;
            }
        }
        if(j == 0){
            Arrays.sort(a);
        }else {
            Arrays.sort(a,i+1,a.length);
        }

        return a;
    }
}
