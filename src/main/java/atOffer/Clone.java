package atOffer;

/**
 * 题目描述
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */
public class Clone {

    public static void main(String[] args) {
        Clone clone = new Clone();
        RandomListNode a = new RandomListNode(1);
        RandomListNode b = new RandomListNode(2);
        RandomListNode c = new RandomListNode(3);
        RandomListNode d = new RandomListNode(4);
        RandomListNode e = new RandomListNode(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        a.random = c;
        b.random = e;
        d.random = b;
        RandomListNode clone1 = clone.Clone(a);

    }
    /**
     * 第一步把复制链表放入下个节点
     * 特殊指针指向的节点就是复制出来的节点
     * 奇数节点和偶数节点分开
     * @param pHead
     * @return
     */
    public RandomListNode Clone(RandomListNode pHead) {
        cloneNodes(pHead);
        randomNodes(pHead);
        RandomListNode splite = splite(pHead);
        return splite;
    }

    /**
     * 复制链表
     * @param pHead
     * @return
     */
    private void cloneNodes(RandomListNode pHead) {
        RandomListNode pNode = pHead;
        while (pNode != null){
            RandomListNode cloneNode = new RandomListNode(pNode.label);
            cloneNode.next = pNode.next;
            cloneNode.random = null;
            pNode.next = cloneNode;
            pNode = cloneNode.next;
        }
    }

    /**
     * 复制特殊指针
     */
    private void randomNodes(RandomListNode pHead){
        RandomListNode pNode = pHead;
        while (pNode != null){
            RandomListNode clone = pNode.next;
            if(pNode.random != null){
                clone.random = pNode.random.next;
            }
            pNode = clone.next;
        }
    }
    /**
     * 打断链表
     *
     */
    private RandomListNode splite(RandomListNode pHead){
        RandomListNode pNode = pHead;
        RandomListNode pCloneHead = null;
        RandomListNode pCloneNode = null;
        if(pNode != null){
            pCloneNode = pNode.next;
            pCloneHead = pCloneNode;
            pNode.next = pCloneNode.next;
            pNode = pNode.next;
        }
        while (pNode != null){
            pCloneNode.next = pNode.next;
            pCloneNode = pCloneNode.next;
            pNode.next = pCloneNode.next;
            pNode = pNode.next;
        }
        return pCloneHead;

    }
}
