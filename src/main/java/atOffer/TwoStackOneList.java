package atOffer;

import java.util.Stack;

/**
 * 题目描述
 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。

 */
public class TwoStackOneList {
    public static void main(String[] args) {

        TwoStackOneList twoStackOneList = new TwoStackOneList();
        twoStackOneList.push(1);
        twoStackOneList.push(2);
        twoStackOneList.push(3);
        int pop = twoStackOneList.pop();
        System.out.print(pop + ",");
        int pop1 = twoStackOneList.pop();
        System.out.print(pop1 + ",");
        twoStackOneList.push(4);
        int pop2 = twoStackOneList.pop();
        System.out.print(pop2 + ",");
        twoStackOneList.push(5);
        int pop3 = twoStackOneList.pop();
        System.out.print(pop3 + ",");
        int pop4 = twoStackOneList.pop();
        System.out.print(pop4);
    }

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        if(!stack2.isEmpty()){
            while (!stack2.isEmpty()){
                stack1.push(stack2.pop());
            }
        }
        stack1.push(node);
        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
    }

    public int pop() {
        return stack2.pop();
    }
}
