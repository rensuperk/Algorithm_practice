//运用你所掌握的数据结构，设计和实现一个 LRU (最近最少使用) 缓存机制 。
//
//
//
// 实现 LRUCache 类：
//
//
// LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存
// int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
// void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上
//限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
//
//
//
//
//
//
// 进阶：你是否可以在 O(1) 时间复杂度内完成这两种操作？
//
//
//
// 示例：
//
//
//输入
//["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
//输出
//[null, null, null, 1, null, -1, null, -1, 3, 4]
//
//解释
//LRUCache lRUCache = new LRUCache(2);
//lRUCache.put(1, 1); // 缓存是 {1=1}
//lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
//lRUCache.get(1);    // 返回 1
//lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
//lRUCache.get(2);    // 返回 -1 (未找到)
//lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
//lRUCache.get(1);    // 返回 -1 (未找到)
//lRUCache.get(3);    // 返回 3
//lRUCache.get(4);    // 返回 4
//
//
//
//
// 提示：
//
//
// 1 <= capacity <= 3000
// 0 <= key <= 10000
// 0 <= value <= 105
// 最多调用 2 * 105 次 get 和 put
//
// Related Topics 设计 哈希表 链表 双向链表
// 👍 1572 👎 0

import java.util.HashMap;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;

//leetcode submit region begin(Prohibit modification and deletion)
@Slf4j
class LRUCache_146 {

    public static void main(String[] args) {
        //LRUCache lRUCache = new LRUCache(2);
        //lRUCache.put(1, 1); // 缓存是 {1=1}
        //lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        //lRUCache.get(1);    // 返回 1
        //lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        //lRUCache.get(2);    // 返回 -1 (未找到)
        //lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        //lRUCache.get(1);    // 返回 -1 (未找到)
        //lRUCache.get(3);    // 返回 3
        //lRUCache.get(4);    // 返回 4
    }
    class DLinkedNode {
        private int key;
        private int value;
        private DLinkedNode prev;
        private DLinkedNode next;
        public DLinkedNode() {
        }

        public DLinkedNode(int key,int value) {
            this.key = key;
            this.value = value;
        }
    }
    //容量
    private int capacity;
    //存储
    private Map<Integer, DLinkedNode> map = new HashMap<>();
    //头和尾的虚节点,不用判断null
    private DLinkedNode head,tail;

    private void addToHead(DLinkedNode node) {
        //将节点放入头节点的后面节点
        //重定向4个指针
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void remove(DLinkedNode node) {
        //删除链表的节点,重定向两个节点
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }
    private DLinkedNode removeTail(){
        //删除尾部虚节点前面的那个节点
        //返回删除的节点,用于map的删除
        DLinkedNode node = tail.prev;
        remove(node);
        return node;
    }

    public LRUCache_146(int capacity) {
        this.capacity = capacity;
        //初始化两个虚节点
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkedNode node = map.get(key);
        if (node != null) {
            //删除节点,添加到头部
            remove(node);
            addToHead(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        DLinkedNode node = map.get(key);
        if (node != null) {
            //如果已经存在,更新value值,删除节点添加到头部
            node.value = value;
            remove(node);
            addToHead(node);
            map.put(key,node);
            return;
        }
        //如果不存在,新增节点添加都头部
        node = new DLinkedNode(key,value);
        addToHead(node);
        map.put(key, node);
        //如果值大于容量,就删除尾部节点
        if (map.size() > capacity) {
            DLinkedNode remove = removeTail();
            map.remove(remove.key);
        }
    }
    // 第一种方法,使用linkedHashMap;
    //    private int capacity;
    //    private LinkedHashMap<Integer,Integer> map = new LinkedHashMap();
    //
    //    public LRUCache(int capacity) {
    //        this.capacity = capacity;
    //    }
    //
    //    public int get(int key) {
    //        if (map.containsKey(key)){
    //            Integer value = map.get(key);
    //            resetList(key,value);
    //            return value;
    //        }
    //        return -1;
    //    }
    //
    //    public void put(int key, int value) {
    //        if (map.containsKey(key)){
    //            resetList(key,value);
    //            return;
    //        }
    //        if (map.size() >= capacity) {
    //            int top = map.keySet().iterator().next();
    //            map.remove(top);
    //        }
    //        map.put(key,value);
    //    }
    //    private void resetList(Integer key,Integer value){
    //        map.remove(key);
    //        map.put(key,value);
    //    }


// 第二种方法 超时...
//    class DLinkedNode {
//        private int key;
//        private DLinkedNode prev;
//        private DLinkedNode next;
//
//        public DLinkedNode() {
//        }
//
//        public DLinkedNode(int key) {
//            this.key = key;
//        }
//    }
//
//    private int capacity;
//    private Map<Integer, Integer> map = new HashMap<>();
//    private DLinkedNode current;
//
//    private void addToTail(int key) {
//        DLinkedNode next = new DLinkedNode(key);
//        if (current == null) {
//            current = next;
//            return;
//        }
//        current.next = next;
//        current.next.prev = current;
//        current = current.next;
//    }
//
//    private void remove(int key) {
//        DLinkedNode index = current;
//        while (index != null) {
//            if (index.key == key) {
//                if (index.prev != null) {
//                    index.prev.next = index.next;
//                }
//                if (index.next != null){
//                    index.next.prev = index.prev;
//                }
//                if (current.key == key){
//                    current = index.prev;
//                }
//                return;
//            }
//            index = index.prev;
//        }
//    }
//
//    private void removeTop() {
//        DLinkedNode index = current;
//        while (index != null) {
//            if (index.prev == null) {
//                if (index.next != null){
//                    index.next.prev = null;
//                }
//                map.remove(index.key);
//            }
//            index = index.prev;
//        }
//    }
//
//    public LRUCache(int capacity) {
//        this.capacity = capacity;
//    }
//
//    public int get(int key) {
//        if (map.containsKey(key)) {
//            Integer value = map.get(key);
//            remove(key);
//            addToTail(key);
//            return value;
//        }
//        return -1;
//    }
//
//    public void put(int key, int value) {
//        if (map.containsKey(key)) {
//            remove(key);
//            addToTail(key);
//            map.put(key,value);
//            return;
//        }
//        if (map.size() >= capacity) {
//            removeTop();
//        }
//        map.put(key, value);
//        addToTail(key);
//    }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)
