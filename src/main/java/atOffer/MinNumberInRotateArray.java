package atOffer;

/**
 * 题目描述
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。 NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */
public class MinNumberInRotateArray {
    public static void main(String[] args) {
        int[] array = {3,4,5,1,2};
        int[] array2 = {6501,6828,6963,7036,7422,7674,8146,8468,8704,8717,9170,9359,9719,9895,9896,9913,9962,154,293,334,492,1323,1479,1539,1727,1870,1943,2383,2392,2996,3282,3812,3903,4465,4605,4665,4772,4828,5142,5437,5448,5668,5706,5725,6300,6335};

        MinNumberInRotateArray minNumberInRotateArray = new MinNumberInRotateArray();
        int i = minNumberInRotateArray.minNumberInRotateArray2(array2);
        System.out.println(i);
    }
    public int minNumberInRotateArray(int [] array) {
        if(array==null || array.length == 0 ){
            return 0;
        }
        int pre = array[0];
        for (int i = 1; i < array.length; i++) {
            if(pre > array[i]){
                return array[i];
            }
        }
        return 0;
    }

    /**
     *二分查找的实现,这个问题有问题，但是我还没找到问题在哪
     */
    public int minNumberInRotateArray2(int [] array) {
        if(array==null || array.length == 0 ){
            return 0;
        }

        return minNumberInRotateArray2(array, 0, array.length-1);
    }
    public int minNumberInRotateArray2(int [] array,int start,int end) {
        if(start > end){
            return array[0];
        }
        if(start == end){
            return array[start];
        }
        if(array[start] > array[start + 1] ){
            return array[start + 1];
        }
        if( array[end] < array[end - 1]){
            return array[end - 1];
        }
        return minNumberInRotateArray2(array,start+1,end-1);
    }


    public int minNumberInRotateArray3(int [] array) {
        return 0;
    }
}
