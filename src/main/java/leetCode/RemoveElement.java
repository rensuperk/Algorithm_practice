package leetCode; /**
 * Given an array and a value, remove all instances of that value in place and return the new length.

 The order of elements can be changed. It doesn’t matter what you leave beyond the new length.
 */
public class RemoveElement {
    public static void main(String[] args) {

    }

    public int RemoveElement(int[] a,int target){
        int j = 0;
        for (int i : a) {
            if(i == target)continue;
            a[j] = a[i];
            j++;
        }
        return j;
    }
}
