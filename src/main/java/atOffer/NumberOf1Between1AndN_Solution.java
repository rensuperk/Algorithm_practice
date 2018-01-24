package atOffer;

/**
 * 题目描述
 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数。
 */
public class NumberOf1Between1AndN_Solution {
    public static void main(String[] args) {
        NumberOf1Between1AndN_Solution numberOf1Between1AndN_solution = new NumberOf1Between1AndN_Solution();
        int i = numberOf1Between1AndN_solution.NumberOf1Between1AndN_Solution(1);
        System.out.println(i);
    }
    /**
     * 这题我也没辙，遍历转成字符串来算，这个太傻了
     * @param n
     * @return
     */
    public int NumberOf1Between1AndN_Solution(int n) {
        int k = 0;
        for (int i = 1; i < n+1; i++) {
            String s = String.valueOf(i);
            k += NumberOf1Between1AndN_SolutionHelp(s);
        }
        return k;
    }
    private int NumberOf1Between1AndN_SolutionHelp(String s){
        int k = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '1'){
                k++;
            }
        }
        return k;
    }

    /**
     * 这个思路看不太懂，
     * 如果希望不用计算每个数字的1的个数，那就只能去寻找1在数字中出现的规律了。为了找到规律，我们不妨用一个稍微大一点的数字比如21345作为例子来分析。我们把从1到21345的所有数字分为两段，一段是从1到1345，另一段是从1346到21345。
     我们先看从1346到21345中1出现的次数。1的出现分为两种情况。首先分析1出现在最高位（本例中是万位）的情况。从1346到21345的数字中，1出现在10000～19999这10000个数字的万位中，一共出现了10000（104）个。
     值得注意的是，并不是对所有5位数而言在万位出现的次数都是10000个。对于万位是1的数字比如输入12345，1只出现在10000～12345的万位，出现的次数不是104次，而是2346次，也就是除去最高数字之后剩下的数字再加上1（即2345＋1=2346次）。
     接下来分析1出现在除最高位之外的其他四位数中的情况。例子中1346～21345这20000个数字中后4位中1出现的次数是2000次。由于最高位是2，我们可以再把1346～21345分成两段，1346～11345和11346～21345。每一段剩下的4位数字中，选择其中一位是1，其余三位可以在0～9这10个数字中任意选择，因此根据排列组合原则，总共出现的次数是2×103=2000次。
     至于从1到1345中1出现的次数，我们就可以用递归求得了。这也是我们为什么要把1～21345分成1～1345和1346～21345两段的原因。因为把21345的最高位去掉就变成1345，便于我们采用递归的思路。
     * @param n
     * @return
     */
    public int NumberOf1Between1AndN_Solution2(int n) {
        if (n < 1)
            return 0;
        int len = getLenOfNum(n);
        if (len == 1)
            return 1;
        int tmp = (int) Math.pow(10, len - 1);
        int first = n / tmp;
        int firstOneNum = first == 1 ? n % tmp + 1 : tmp;
        int otherOneNUm = first * (len - 1) * (tmp / 10);
        return firstOneNum + otherOneNUm + NumberOf1Between1AndN_Solution(n % tmp);
    }
 
            private int getLenOfNum(int n) {
        int len = 0;
        while (n != 0) {
            len++;
            n /= 10;
        }
        return len;
    }
}
