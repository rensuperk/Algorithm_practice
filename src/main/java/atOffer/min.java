package atOffer;

import java.util.Objects;
import java.util.Stack;

/**
 * 题目描述
 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 *
 */
public class min {
    //["PSH3","MIN","PSH4","MIN","PSH2","MIN","PSH3","MIN","POP","MIN","POP","MIN","POP","MIN","PSH0","MIN"]
    public static void main(String[] args) {
        min min =new min();
        min.push(3);
        min.min();
        System.out.println( min.min());
        min.push(4);
        min.min();
        System.out.println( min.min());
        min.push(2);
        min.min();
        System.out.println( min.min());
        min.push(3);
        min.min();
        System.out.println( min.min());
        min.pop();
        min.min();
        System.out.println( min.min());
        min.pop();
        min.min();
        System.out.println( min.min());
        min.pop();
        min.min();
        System.out.println( min.min());
        min.push(0);
        min.min();
        System.out.println( min.min());

    }
    Stack<Integer> sta  = new Stack<>();
    Stack<Integer> min  = new Stack<>();
    public void push(int node) {
        sta.push(node);
        if( min.isEmpty() || sta.peek() <= min.peek()){
            min.push(node);
        }
    }

    public void pop() {
        Integer pop = sta.pop();
        if(! min.isEmpty() && pop  != null && Objects.equals(pop, min.peek())){
            min.pop();
        }

    }

    public Integer top() {

        return sta.isEmpty() ? null : sta.peek();
    }

    public Integer min() {

        return min.isEmpty() ? null : min.peek();
    }
}
