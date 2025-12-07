class LRUCache {
    class Node {
        int key;
        int val;
        Node next, back;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.next = null;
            this.back = null;
        }
    }

    Map<Integer, Node> mp;
    int capacity;

    // node val, dist

    private Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.mp = new HashMap<>();

        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        tail.back = head;
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

    public int get(int key) {
        if (!mp.containsKey(key)) {
            return -1;
        }

        Node node = mp.get(key);
        deleteNode(node);
        insertAfterHead(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (mp.containsKey(key)) {
            Node oldNode = mp.get(key);
            deleteNode(oldNode);
            mp.remove(key);
        }

        if (mp.size() == capacity) {
            Node lastNode = tail.back;
            deleteNode(lastNode);
            mp.remove(lastNode.key);
        }

        Node newNode = new Node(key, value);
        insertAfterHead(newNode);
        mp.put(key, newNode);

    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */