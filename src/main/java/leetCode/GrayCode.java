package leetCode;import groovy.json.JsonOutput;

import java.util.ArrayList;
import java.util.List;

/**
 * The gray code is a binary numeral system where two successive values differ in only one bit.

 Given a non-negative integer n representing the total number of bits in the code,
 print the sequence of gray code. A gray code sequence must begin with 0.

 For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:

 00 - 0
 01 - 1
 11 - 3
 10 - 2
 Note:
 For a given n, a gray code sequence is not uniquely defined.

 For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.

 For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.
 解析
 可以看到n位的格雷码由两部分构成，一部分是n-1位格雷码，再加上 1<<(n-1)和n-1位格雷码的逆序
 由于是二进制，在最高位加0跟原来的数本质没有改变，所以取得上一位算出的格雷码结果，再加上逆序添1的方法就是当前这位格雷码的结果了。

 n = 0时，[0]

 n = 1时，[0,1]

 n = 2时，[00,01,11,10]

 n = 3时，[000,001,011,010,110,111,101,100]
 */
public class GrayCode {
    public static void main(String[] args) {
        GrayCode grayCode = new GrayCode();
        List<Integer> integers = grayCode.grayCode(4);
        System.out.println(JsonOutput.toJson(integers));
    }
    public List<Integer>  grayCode(int n){
        if(n == 0) {
            List<Integer> list = new ArrayList<>();
            list.add(0);
            return list;
        }
        List<Integer> list = grayCode(n-1);
        int addNum = 1 << (n-1);
        for (int i = list.size()-1; i >= 0 ; i--) {
            list.add(addNum + list.get(i));
        }
        return list;
    }

}
