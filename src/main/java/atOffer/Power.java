package atOffer;

/**
 * 题目描述
 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 */
public class Power {
    public static void main(String[] args) {
        Power power = new Power();
        power.Power1(2d,-1);
    }
    /**
     * 常规方法
     * @param base
     * @param exponent
     * @return
     */
    public double Power(double base, int exponent) {
        double result = 1d;
        if(exponent == 0){
            return 1;
        }
        if(exponent > 0 ){
            for (int i = 1; i <= exponent; i++) {
                result *=base;
            }
        }else {
            for (int i = 1; i <= -exponent; i++) {
                result *=1/base;
            }
        }
        return result;
    }

    /**
     * 优化方法
     * @param base
     * @param exponent
     * @return
     */

    public double Power2(double base, int exponent) {
        if(exponent == 0){
            return 1;
        }
        if(exponent > 0){
            return Power1( base,  exponent);
        }else {
            return 1/Power1( base,  -exponent);
        }
    }
    public double Power1(double base, int exponent) {
        if(exponent == 0){
            return 1;
        }
        if(exponent == 1){
            return base;
        }

        double result = Power1(base,exponent >> 1);
        result *=result;
        if((exponent & 1) == 1){
            result *=base;
        }
        return result;
    }
}
