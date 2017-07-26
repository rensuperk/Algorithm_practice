/**
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

 Do not allocate extra space for another array, you must do this in place with constant memory.

 For example,
 Given input array A = [1,1,2],

 Your function should return length = 2, and A is now [1,2].

 */
public class RemoveDuplicatesfromSortedArray {
    public static void main(String[] args) {
        int[] ints = {1, 1, 2, 2, 3, 3};
        int[] array = removeDuplicatesfromSortedArray(ints);
        for (int arg : array) {
            System.out.println(arg);
        }
    }

    /**
     * 这个理解有问题，解法很蠢而且不符合要求。
     * @param array
     * @return
     */
    static int[] removeDuplicatesfromSortedArray(int[] array){
        int reCount = 0;
        int[] ints = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            if(i < array.length-1 && array[i] == array[i+1] ){
                reCount ++ ;
                continue;
            }
            ints[i-reCount] = array[i];
        }
        int[] re = new int[array.length - reCount];
        for (int i = 0; i < re.length; i++) {
            re[i] = ints[i];
        }
        return re;
    }

    /**
     *
     * @param array
     * @return
     */
    static int removeDuplicatesfromSortedArray2(int[] array){
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if(array[i] != array[index]){
                //比较不相等就进入下一个，index是不重复的数量。先设置值再自增
              array[++index] = array[i];
            }
        }
        //因为从0开始的所以结果+1
        return index + 1;
    }

    /**
     * 因为没学过STL算法，所以略去别的算法
     */
}
