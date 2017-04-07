### [461.Hamming Distance](src/main/java/HammingDistance.java)
### [476. Number Complement](src/main/java/NumberComplement.java)


####[461.Hamming Distance](src/main/java/HammingDistance.java)

The Hamming distance 
between two integers is the number of positions at which the corresponding bits are different.
Given two integers x and y, calculate the Hamming distance.
Note:

``0 ≤ x, y < 231.``

Example:
```
    Input: x = 1, y = 4
    Output: 2
    Explanation:
    1   (0 0 0 1)
    4   (0 1 0 0)
           ↑   ↑
```
The above arrows point to positions where the corresponding bits are different.

分析,输入两个数,求数的汉明距离,都转成二进制的位数差

```

    /**
     * 最能理解的方法
     * @param x
     * @param y
     * @return
     */
    public static int hammingDistance(int x, int y) {
        int res = 0;
        for (int i = 0; i < 32; ++i) {
            if((x & (1 << i)) != (y & (1 << i))){
                ++res;
            }
        }
        System.out.println(res);
        return res;
    }

    /**
     * 先计算x异或y,然后再将每位为1的相加
     * @param x
     * @param y
     * @return
     */
    public static int hammingDistance2(int x, int y) {

        int sum = x ^ y ;
        int res = 0;
        for (int i = 0; i < 32; ++i) {
            if((sum & (1 << i))  == 1 << i){
                ++res;
            }
        }
        System.out.println(res);
        return res;
    }

    /**
     * 上个方法的改进,每次右移i位,与1与计算,结果累加
     * @param x
     * @param y
     * @return
     */
    public static int hammingDistance3(int x, int y) {

        int sum = x ^ y ;
        int res = 0;
        for (int i = 0; i < 32; ++i) {
            res += sum >> i & 1;
        }
        System.out.println(res);
        return res;
    }
    /**
     * 上个方法的改进,每次右移i位,结果为sum,sum&(sum-1),移除最右边的1,每移除1个就+1
     * @param x
     * @param y
     * @return
     */
    public static int hammingDistance4(int x, int y) {

        int sum = x ^ y ;
        int res = 0;
        while (sum >0){
            res++;
            sum = sum&(sum -1);
        }
        System.out.println(res);
        return res;
    }
    /**
     * 上个方法的改进
     * 递归写法
     * sum%2相当于比较最右边的数,x/2,y/2相当与向右移动一位
     * @param x
     * @param y
     * @return
     */
    public static int hammingDistance5(int x, int y) {
        int sum = x ^ y ;

        if(sum == 0) return 0;


        return sum % 2 + hammingDistance5(x/2 ,y/2);
    }

    public static void main(String[] args) {
        hammingDistance(2,5);
        hammingDistance2(2,5);
        hammingDistance3(2,5);
        hammingDistance4(2,5);
        int i = hammingDistance5(2, 5);
        System.out.println(i);

    }
```

#### [476. Number Complement](src/main/java/NumberComplement.java)
Given a positive integer, output its complement number. The complement strategy is to flip the bits of its binary representation.

Note:
```
The given integer is guaranteed to fit within the range of a 32-bit signed integer.
You could assume no leading zero bit in the integer’s binary representation.
```

Example 1:
```
Input: 5
Output: 2
Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you need to output 2.
```

Example 2:
```
Input: 1
Output: 0

Explanation: The binary representation of 1 is 1 (no leading zero bits), and its complement is 0. So you need to output 0.
```
```
    /**
     *思路,从高到底的遍历
     * 和同位数的1与计算,结果相同就改为false
     * 如果是true的话就是1,再与同位数的1异或计算就可以了
     *
     * @param num
     * @return
     */
    public static int findComplement(int num) {
        int res = num;
        boolean flag = true;
        for (int i = 31; i >= 0; i--) {
            if((num &(1<<i)) == (1<<i)){
                flag = false;

            }
            if(!flag){
                res ^= 1<<i;
            }
        }
        return res;
    }

    /**
     * 从num最低位开始翻转
     * 当前值小于等于1的时候停止
     *
     * @param num
     * @return
     */
    public static int findComplement2(int num) {
        int n = 1 - num % 2;
        return n + 2*(num <= 1 ? 0 : findComplement2(num / 2));
    }

    public static void main(String[] args) {
        int num = 5;
        System.out.println(findComplement(num));
        System.out.println(findComplement2(num));
    }

```






