import com.sun.media.sound.RIFFInvalidDataException;

/**
 * There are N children standing in a line. Each child is assigned a rating value.

 You are giving candies to these children subjected to the following requirements:

 Each child must have at least one candy.
 Children with a higher rating get more candies than their neighbors.
 What is the minimum candies you must give?
 解析：
    给最少的糖果问题
    孩子都有排名
    排名高的比两边的多
    每个孩子最少一个

 这个和水池的问题一样，小朋友i拿到的糖果受他左右两侧的分数影响



 */
public class Candy {
    public int candy(int[] rateing){
        if(rateing == null || rateing.length == 0){
            return 0;
        }
        int[] l = new int[rateing.length];
        int[] r = new int[rateing.length];
        l[0] = 1;
        for (int i = 1; i < rateing.length; i++) {
            if(rateing[i] > rateing[i - 1]){
                l[i] = l[i - 1] + 1;
            }else {
                l[i] = 1;
            }
        }
        r[rateing.length-1] = l[rateing.length-1];
        for (int i = rateing.length-2; i >= 0 ; i--) {
                if(rateing[i] > rateing[i+1]){
                    r[i] = r[i+1] +1;
                }else {
                    r[i] = 1;
                }
        }
        int res = 0;
        for (int i = 0; i < rateing.length; i++) {
            res += Math.max(l[i],r[i]);
        }
        return res;
    }
}
