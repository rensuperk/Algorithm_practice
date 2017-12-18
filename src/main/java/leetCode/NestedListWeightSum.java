package leetCode; /**
 * Created by renkai on 2017/4/7.
 */
public class NestedListWeightSum {

    /**
     * 调用递归一层一层的往里计算就行了
     * @param t
     * @return
     */
    public static int depthSum(Object[] t){
        int result = 0;

        for (Object vector : t) {
            result += getsum(vector,1);
        }
        return result;
    }
    public static int getsum(Object t,int lev){
        int result = 0;

        if(t instanceof Integer) {
            return (Integer) t * lev;
        }
        if(t instanceof Object[]){
            for (Object vector : (Object[]) t) {
                result += getsum(vector,lev+1);
            }
        }
        return result;
    }

    /**
     * 对上个方法的改进
     * @param t
     * @return
     */
    public static int depthSum2(Object[] t){
        return getsum2(t,1);
    }
    public static int getsum2(Object[] t,int lev){
            int result = 0;
            for (Object vector :  t) {
                result += vector instanceof Integer
                        ? (Integer) vector * lev
                            : vector instanceof Object[]
                                ? getsum2((Object[]) vector,lev +1)
                                    : 0;
            }
            return result;
    }


    public static void main(String[] args) {
        Object[] t =new Object[]{1,2,3,4,new Object[]{1,2,3,new Object[]{2}}};
        System.out.println(depthSum(t));
        System.out.println(depthSum2(t));
    }

}
