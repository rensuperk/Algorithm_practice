package atOffer;

/**
 * 题目描述
 * 输入一个整数数组，
 * 实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于位于数组的后半部分，
 * 并保证奇数和奇数，
 * 偶数和偶数之间的相对位置不变。
 */
public class ReOrderArray {
    public static void main(String[] args) {
        ReOrderArray reOrderArray = new ReOrderArray();
        int[] array = {1,2,3,4,5,6,7,8,9,10};
        reOrderArray.reOrderArray(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
        }

    }
    /**
     * 思路应该是用两个指针，第一个指到偶数，第二个就开始查找第一个奇数，然后依次后移，把奇数替换到第一个指针的位置上
     * @param array
     */
    public void reOrderArray(int [] array) {
        if(array == null || array.length == 0 ||array.length == 0 ){
            return;
        }
        int start = 0;
        int start2= 0;
        int flag = 0;
        while ((start <= array.length -1)){
            System.out.println("sart = " + start);

            while (start < array.length && !isEvent(array[start])){
                //从左边扫描，直到遇到偶数
                start++;
            }
            start2 = start+1;
            System.out.println("start = " +start + ",array[start] = " + array[start]);
            //从第二个指针开始扫描，直到遇到奇数
            while (start2 < array.length && isEvent(array[start2])){
                start2++;
            }
            System.out.println("start2 = " +start2);
            //把奇数放到位置上去，然后把偶数往后移动，这样才能保证位置
            if(start2 < array.length){
                flag = array[start2];
                for (int i = start2; i > start; i--) {
                    array[i] = array[i-1];
                }
                array[start] = flag;
            }else {
                break;
            }

            for (int i = 0; i < array.length; i++) {
                System.out.print(array[i]+",");
            }
            System.out.println("");
        }
    }

    /**
     * 是否是偶数
     * @param n
     * @return
     */
    public boolean isEvent(int n){
        return ((n & 1)==0);
    }

}
