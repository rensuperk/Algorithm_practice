/**
 * Single Number
 Given an array of integers, every element appears twice except for one. Find that single one.

 Note:
 Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */
public class SingleNumber {
    public int singleNumber(int[] a){
        int x =0;
        //对于任何数x，都有x^x=0，x^0=x
        for (int i = 0; i < a.length; i++) {
            x ^= a[i];
        }
        return x;
    }
}
