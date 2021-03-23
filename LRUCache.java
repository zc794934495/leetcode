class LRUCache {
    class LinkedNode {
        int key;
        int val;
        LinkedNode prev;
        LinkedNode next;
        public LinkedNode() {

        }
        public LinkedNode(int key,int val) {
            this.key = key;
            this.val = val;
        }
    }
    private Map<Integer,LinkedNode> map = new HashMap<>();
    private int size;
    private int capacity;
    private LinkedNode head,tail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new LinkedNode();
        tail = new LinkedNode();
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        LinkedNode node = map.get(key);
        if(node == null) {
            return -1;
        }
        moveToHead(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        LinkedNode node = map.get(key);
        if(node == null) {
            LinkedNode newNode = new LinkedNode(key,value);
            map.put(key,newNode);
            addToHead(newNode);
            size++;
            if(size > capacity) {
                LinkedNode tail = removeTail();
                map.remove(tail.key);
                size--;
            }
        }else {
            node.val = value;
            moveToHead(node);
        }
    }

    private void addToHead(LinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next = node;
        node.next.prev = node;
    }

    private void removeNode(LinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToHead(LinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    private LinkedNode removeTail() {
        LinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }
}