package leetCode;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

 For example,
 Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.



 The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!
    解析
    一点的体积就是左右两边最高点较低的一点和本点的差
 */
public class TrappingRainWater {
    int trappingRainWater(int[] a){
        if(a.length == 0 || a == null){
            return 0;
        }
        int i,max,total = 0;
        int[] left = new int[a.length];
        int[] right = new int[a.length];
        left[0] = a[0];
        max = a[0];
        //每个元素的左侧最高值
        for ( i = 1; i < a.length; i++) {
            left[i] = Math.max(max,a[i]);
            max = Math.max(max,a[i]);
        }
        right[a.length-1] = a[a.length-1];
        max = a[a.length-1];
        //每个元素右侧最高值
        for (i = a.length-1; i > 0 ; i--) {
            right[i] = Math.max(max,a[i]);
            max = Math.max(max,a[i]);
        }
        //计算面积
        for ( i = 0; i < a.length; i++) {
            int b = Math.min(left[i],right[i])-a[i];
            if(b > 0)
                total += b;
        }
        return total;
    }
}
