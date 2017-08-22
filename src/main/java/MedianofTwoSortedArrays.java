import java.lang.annotation.ElementType;
import java.util.Arrays;

/**
 * Median of Two Sorted Arrays
 There are two sorted arrays A and B of size m and n respectively.
 Find the median of the two sorted arrays.
 The overall run time complexity should be O(log (m+n)).

 解析：找到两个有序数列中的中间数
 时间复杂度O(log(m+n))
 两个数组合并找中间数就可以，但是时间复杂度不符合要求
 分析

 这是一道非常经典的题。这题更通用的形式是，给定两个已经排序好的数组，找到两者所有元素中第$k$大的元素。

 $O(m+n)$的解法比较直观，直接merge两个数组，然后求第$k$大的元素。

 不过我们仅仅需要第$k$大的元素，是不需要“排序”这么复杂的操作的。可以用一个计数器，记录当前已经找到第$m$大的元素了。
 同时我们使用两个指针{pA}和{pB}，分别指向A和B数组的第一个元素，使用类似于merge sort的原理，如果数组A当前元素小，
 那么{pA++}，同时{m++}；如果数组B当前元素小，那么{pB++}，同时{m++}。最终当$m$等于$k$的时候，就得到了我们的答案，
 $O(k)$时间，$O(1)$空间。但是，当$k$很接近$m+n$的时候，这个方法还是$O(m+n)$的。

 有没有更好的方案呢？我们可以考虑从$k$入手。如果我们每次都能够删除一个一定在第$k$大元素之前的元素，那么我们需要进行$k$次。
 但是如果每次我们都删除一半呢？由于A和B都是有序的，我们应该充分利用这里面的信息，类似于二分查找，也是充分利用了“有序”。

 假设A和B的元素个数都大于$k/2$，我们将A的第$k/2$个元素（即{A[k/2-1]}）和B的第$k/2$个元素（即{B[k/2-1]}）进行比较，
 有以下三种情况（为了简化这里先假设$k$为偶数，所得到的结论对于$k$是奇数也是成立的）：

 \item {A[k/2-1] == B[k/2-1]}
 \item {A[k/2-1] > B[k/2-1]}
 \item {A[k/2-1] < B[k/2-1]}

 如果{A[k/2-1] < B[k/2-1]}，意味着{A[0]}到{A[k/2-1}的肯定在$A \cup B$的top k元素的范围内，
 换句话说，{A[k/2-1}不可能大于$A \cup B$的第$k$大元素。留给读者证明。

 因此，我们可以放心的删除A数组的这$k/2$个元素。同理，当{A[k/2-1] > B[k/2-1]}时，可以删除B数组的$k/2$个元素。

 当{A[k/2-1] == B[k/2-1]}时，说明找到了第$k$大的元素，直接返回{A[k/2-1]}或{B[k/2-1]}即可。

 因此，我们可以写一个递归函数。那么函数什么时候应该终止呢？

 \item 当A或B是空时，直接返回{B[k-1]}或{A[k-1]}；
 \item 当{k=1}是，返回{min(A[0], B[0])}；
 \item 当{A[k/2-1] == B[k/2-1]}时，返回{A[k/2-1]}或{B[k/2-1]}
 */
public class MedianofTwoSortedArrays {
    public static void main(String[] args) {
        MedianofTwoSortedArrays arrays = new MedianofTwoSortedArrays();
//        int arraysMedian = arrays.getMedian(new int[]{1, 2, 3}, new int[]{4, 5, 6, 7});
//        int arraysMedian2 = arrays.getMedian2(new int[]{1, 2, 3},3, new int[]{4, 5, 6, 7},4);
        double arraysMedian3 = arrays.findMedianSortedArrays(new int[]{1, 2, 3}, new int[]{4, 5, 6, 7});
        System.out.println(arraysMedian3);

    }

    /**
     * 这个时间复杂度为O(m+n)不符合要求
     * @param a
     * @param b
     * @return
     */
    public int getMedian(int[] a,int[] b){
        int[] c = new int[a.length+b.length];
        int i = 0;
        int j =0;
        while (i < a.length && j < b.length){
            if(a[i] < b[j]){
                c[i+j] = a[i];
                i++;
            }else {
                c[i+j] = b[j];
                j++;
            }
        }
        while (i < a.length){
            c[i+j] =a[i];
            i++;
        }
        while (j < b.length){
            c[i+j] =b[j];
            j++;
        }
        for (int i1 : c) {
            System.out.println(i1);
        }
        return c[c.length/2];
    }


    public int findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length, left = (m + n + 1) / 2, right = (m + n + 2) / 2;
        return (findKth(nums1, nums2, left) + findKth(nums1, nums2, right)) / 29;
    }
    int findKth(int[] nums1, int[] nums2, int k) {
        int m = nums1.length, n = nums2.length;
        if (m > n) return findKth(nums2, nums1, k);
        if (m == 0) return nums2[k - 1];
        if (k == 1) return Math.min(nums1[0], nums2[0]);
        int i = Math.min(m, k / 2), j = Math.min(n, k / 2);
        if (nums1[i - 1] > nums2[j - 1]) {
            return findKth(nums1, Arrays.copyOfRange(nums2, j, n), k - j);
        } else {
            return findKth(Arrays.copyOfRange(nums1, i, m), nums2, k - i);
        }
    }
}
