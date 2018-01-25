package atOffer;

/**
 * 题目描述
 * 把只包含因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 */
public class GetUglyNumber_Solution {
    public static void main(String[] args) {
        GetUglyNumber_Solution getUglyNumber_solution = new GetUglyNumber_Solution();

        System.out.println(getUglyNumber_solution.GetUglyNumber_Solution2(11));
    }
    /**
     * 这个时间复杂度太大了
     * @param index
     * @return
     */
    public int GetUglyNumber_Solution(int index) {
        if(index <= 0){
            return 0;
        }
        int num = 0;
        int uglyFount = 0;
        while (uglyFount < index){
            num++;
            if(isUgly(num)){
                uglyFount++;
            }
        }
        return num;
    }
    public int GetUglyNumber_Solution2(int index) {
        if(index <= 0){
            return 0;
        }
        int[] ugNums = new int[index];
        ugNums[0] = 1;
        int nextUg =1;
        int p2 = 0;
        int p3 =0;
        int p5 =0;
        while (nextUg < index){
            ugNums[nextUg] = Math.min(ugNums[p2]*2,Math.min(ugNums[p3]*3,ugNums[p5]*5));
            if ((ugNums[p2]*2) == ugNums[nextUg]){
                ++p2;
            }
            if ((ugNums[p3]*3) == ugNums[nextUg]){
                ++p3;
            }
            if ((ugNums[p5]*5) == ugNums[nextUg]){
                ++p5;
            }
            nextUg ++ ;
        }
        return ugNums[nextUg-1];
    }
    private boolean isUgly(int num){
        while (num%2 == 0){
            num /=2;
        }while (num%3 == 0){
            num /=3;
        }while (num%5 == 0){
            num /=5;
        }
        return num == 1 ? true: false;
    }

}
