/**
 * Given a non-negative number represented as an array of digits, plus one to the number.

 The digits are stored such that the most significant digit is at the head of the list.
 */
public class PlusOne {
    public int[] plusOne(int[] a){
        for (int i = a.length-1; i >= 0; i--) {
            //小于9的情况就+1跳出
            if(a[i] < 9){
                a[i]++;
                break;
            }else {
                //等于9的情况进1
                a[i] = 0;
            }
        }
        if(a[0] == 0){
            int[] newa = new int[a.length + 1];
            newa[0] = 1;
            for (int i = 1; i < newa.length; i++) {
                newa[i] = a[i-1];
            }
            return newa;
        }
        return a;
    }
}
