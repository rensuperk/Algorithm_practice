package atOffer;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */
public class PrintMinNumber {

    public static void main(String[] args) {
        PrintMinNumber printMinNumber = new PrintMinNumber();
        int[] i = {3334,3,3333332};
        String s = printMinNumber.PrintMinNumber2(i);
        System.out.println(s);
    }
    /**
     * 我想的办法是把所有组合一起，然后找最小的，这个方法肯定很笨
     * @param numbers
     * @return
     */
    public String PrintMinNumber(int [] numbers) {
        if(numbers == null || numbers.length == 0){
            return "";
        }
        if(numbers.length == 1){
            return String.valueOf(numbers[0]);
        }
        PriorityQueue<BigDecimal> queue = new PriorityQueue<BigDecimal>(new Comparator<BigDecimal>() {
            @Override
            public int compare(BigDecimal o1, BigDecimal o2) {
                return o1.compareTo(o2);
            }
        });
        PrintMinNumber(numbers,0,queue);
        return queue.poll().toString();
    }

    private void PrintMinNumber(int[] numbers, int i, PriorityQueue<BigDecimal> queue) {
        if(i>=(numbers.length-1)){
            StringBuilder sb = new StringBuilder();
            for (int i1 = 0; i1 < numbers.length; i1++) {
                sb.append(numbers[i1]);
            }
            queue.offer(new BigDecimal(sb.toString()));
        }else {
            for (int i1 = i; i1 < numbers.length; i1++) {
                swap(numbers,i,i1);
                queue.offer(cover(numbers));
                PrintMinNumber(numbers,i+1,queue);
                swap(numbers,i,i1);
            }
        }
    }
    private void swap(int[] numbers,int i,int j){
        if(i<numbers.length && j < numbers.length){
            int temp = numbers[i];
            numbers[i] = numbers[j];
            numbers[j] = temp;
        }
    }
    private BigDecimal cover(int[] numbers){
        StringBuilder sb = new StringBuilder();
        for (int i1 = 0; i1 < numbers.length; i1++) {
            sb.append(numbers[i1]);
        }
        return new BigDecimal(sb.toString());
    }


    public String PrintMinNumber2(int [] numbers) {
        if(numbers == null || numbers.length == 0){
            return "";
        }
        if(numbers.length == 1){
            return String.valueOf(numbers[0]);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int number : numbers) {
            list.add(number);
        }
        Collections.sort(list,new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String s01 = o1 + "" + o2;
                String s02 = o2 + "" + o1;
                return s01.compareTo(s02);
            }
        });

        String s = "";
        for (Integer integer : list) {
            s+=integer;
        }
        return s;
    }

}
