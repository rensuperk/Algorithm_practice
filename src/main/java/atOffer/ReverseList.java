package atOffer;

/**
 * 反转链表
 * 题目描述
 输入一个链表，反转链表后，输出链表的所有元素。
 */
public class ReverseList {

    public static void main(String[] args) {
        ListNode linkNode = new ListNode(1);
        linkNode.next =  new ListNode(2);
        linkNode.next.next =  new ListNode(3);
        linkNode.next.next.next =  new ListNode(4);
        linkNode.next.next.next.next =  new ListNode(5);

        ReverseList findKthToTail = new ReverseList();
        ListNode node = findKthToTail.ReverseList(linkNode);

        while (node != null){
            System.out.println(node.val);
            node = node.next;
        }

    }
    /**
     * 思路·没
     * @param head
     * @return
     */
    public ListNode ReverseList(ListNode head) {
        ListNode pre = null;
        ListNode next = null;
        if(head == null || head.next == null){
            return head;
        }
        while (head != null){
            //保存next节点
           next = head.next;
           //反转
           head.next = pre;
           //后移
           pre = head;
           head = next;
        }

        return pre;
    }
}
