### [461. Hamming Distance](md/461.Hamming Distance.md)
### [476. Number Complement](src/main/java/NumberComplement.java)
### [339. Nested List Weight Sum](src/main/java/NestedListWeightSum.java)






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

#### [339. Nested List Weight Sum](src/main/java/NestedListWeightSum.java)
Given a nested list of integers, return the sum of all integers in the list weighted by their depth.

Each element is either an integer, or a list -- whose elements may also be integers or other lists.

Example 1:
```
Given the list [[1,1],2,[1,1]], return 10. (four 1's at depth 2, one 2 at depth 1)
```
Example 2:
```
Given the list [1,[4,[6]]], return 27. (one 1 at depth 1, one 4 at depth 2, and one 6 at depth 3; 1 + 4*2 + 6*3 = 27)
```





