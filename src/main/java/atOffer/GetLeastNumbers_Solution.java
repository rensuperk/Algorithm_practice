package atOffer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 题目描述
 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 */
public class GetLeastNumbers_Solution {

    public static void main(String[] args) {
        GetLeastNumbers_Solution getLeastNumbers_solution = new GetLeastNumbers_Solution();
        int[] input = {4,5,1,6,2,7,3,8};
        ArrayList<Integer> list = getLeastNumbers_solution.GetLeastNumbers_Solution(input, 4);
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }
    /**
     * 最小的k个数,容量为k的排序数组,如果比小就插入.
     * @param input
     * @param k
     * @return
     */
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if(k > input.length){
            return list;
        }
        if(k == 0){
            return list;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        for (int i = 0; i < input.length; i++) {
            int a = input[i];
            if(queue.size() != k){
                queue.offer(a);
            }else if(a < queue.peek()){
                queue.poll();
                queue.offer(a);
            }
            System.out.println("a = " + a);
            System.out.print("queue = ");
            for (Integer integer : queue) {
                System.out.print(integer+",");
            }
            System.out.println();
        }
            list.addAll(queue);

        return list;
    }
}
