package atOffer;

public class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }

    public RandomListNode(int label, RandomListNode next, RandomListNode random) {
        this.label = label;
        this.next = next;
        this.random = random;
    }
}
