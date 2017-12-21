package atOffer;

/**
 * 链表中倒数第k个结点
 * 题目描述
 输入一个链表，输出该链表中倒数第k个结点。
 */
public class FindKthToTail {

    public static void main(String[] args) {
        ListNode linkNode = new ListNode(1);
        linkNode.next =  new ListNode(2);
        linkNode.next.next =  new ListNode(3);
        linkNode.next.next.next =  new ListNode(4);
        linkNode.next.next.next.next =  new ListNode(5);

        FindKthToTail findKthToTail = new FindKthToTail();
        findKthToTail.FindKthToTail(linkNode,6);

    }
    /**
     * 思路还是用两个指针，第一个开始，过了第k个，第二个指针开始，当第一个到头的时候，就是第k个节点了
     * @param head
     * @param k
     * @return
     */
    public ListNode FindKthToTail(ListNode head,int k) {
        if(k <= 0){
            return null;
        }
        if(head == null ){
            return null;
        }
        int i = 1;
        ListNode node = head;
        ListNode flag =head;
        while (node.next != null){

            if(i >= k){
                flag = flag.next;
            }
            node = node.next;
            i++;
        }
        if(k > i){
            return null;
        }
        return flag;
    }
}
