
class LRUCache {
    class Node {
        int key, val;
        Node next, back;

        Node(int key1, int val1) {
            this.key = key1;
            this.val = val1;
            this.next = null;
            this.back = null;
        }
    }

    HashMap<Integer, Node> mp;
    int capacity;

    private Node head, tail; // dummy head and tail

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.mp = new HashMap<>();

        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        tail.back = head;
    }

    public void put(int key, int value) {
        Node temp = new Node(key, value);

        if (mp.containsKey(key)) {
            Node oldNode = mp.get(key);
            deleteNode(oldNode);
            mp.remove(key);
        }

        if (mp.size() == capacity) {
            // Remove LRU from back (tail.prev)
            Node lru = tail.back;
            deleteNode(lru);
            mp.remove(lru.key);
        }

        Node newNode = new Node(key, value);
        insertAfterHead(newNode);
        mp.put(key, newNode);
    }

    public int get(int key) {
        if (!mp.containsKey(key)) {
            return -1;
        }

        Node node = mp.get(key);

        deleteNode(node);
        insertAfterHead(node);

        return node.val;
    }

    public void insertAfterHead(Node curNode) {
        Node frontNode = head.next;

        head.next = curNode;
        curNode.back = head;
        curNode.next = frontNode;
        frontNode.back = curNode;
    }

    public void deleteNode(Node curNode) {
        Node prevNode = curNode.back;
        Node frontNode = curNode.next;

        prevNode.next = frontNode;
        frontNode.back = prevNode;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */