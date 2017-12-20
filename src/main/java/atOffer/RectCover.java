package atOffer;

/**
 * 题目描述
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 */
public class RectCover {
    /**
     * 这也是个裴波那契数列
     * @param target
     * @return
     */
    public int RectCover(int target) {
        if(target <= 0){
            return 0;
        }
        if(target == 1){
            return 1;
        }
        int f1 = 1;
        int f2 = 0;
        int fn = 0;
        for (int i = 1; i <= target; i++) {
            fn = f1+f2;
            f2 = f1;
            f1 = fn;
        }
        return fn;
    }
}
