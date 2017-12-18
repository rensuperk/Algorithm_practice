package atOffer;

import java.util.ArrayList;

/**
 * @author renkai
 * 题目描述
输入一个链表，从尾到头打印链表每个节点的值。
 *TODO
 */
public class PrintListFromTailToHead {
    
         public class ListNode {
             int val;
             ListNode next = null;
     
             ListNode(int val) {
                 this.val = val;
             }
         }
     
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
         if(listNode == null){
             return list;
         }
        list =  printListFromTailToHead( listNode, list);
        ArrayList<Integer> resultlist = new ArrayList<>();
        for (int i = list.size()-1; i >= 0; i--) {
            resultlist.add(list.get(i));
        }
        return resultlist;
    }

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode,ArrayList<Integer> list) {
         if(listNode == null){
             return list;
         }
         list.add(listNode.val);
        return printListFromTailToHead(listNode.next,list);
    }


}
