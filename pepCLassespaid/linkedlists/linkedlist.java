public class linkedlist{
    private class Node{
        private Node head = null ;
        private Node tail = null ;
        private int SizeofLL = 0 ;
        public boolean isempty(){
            return this.SizeofLL = 0 ;
        }
        public boolean size(){
            return this.SizeofLL;
        }
         // Exceptions
    public void EmptyException() throws Exception {
        if (this.sizeOfLL == 0) {
            throw new Exception("LinkedList is Empty: -1 pepcoding");
        }
    }

    public void IndexOutOfBoundSizeExclusiveException(int idx) throws Exception {
        if (idx < 0 || idx >= this.sizeOfLL)
            throw new Exception("Index Out Of Bound : -1");
    }

    public void IndexOutOfBoundSizeInclusiveException(int idx) throws Exception {
        if (idx < 0 || idx > this.sizeOfLL)
            throw new Exception("Index Out Of Bound : -1");
    }
    // get
        public int getFirst() throws Exception {
            EmptyException();
            return this.head.data;
    
        }
    
        public int getLast() throws Exception {
            EmptyException();
            return this.tail.data;
        }
    
        private Node getNodeAt(int idx) {
    
        }
    
        public int getAt(int idx) {
            IndexOutOfBoundSizeExclusiveException(idx);
            Node node = getNodeAt(idx);
            return node.data;
        }
    // ADD
        private void addfirstnode(Node node) {
            if(this.head == null){
                this.head = node;
                this.tail = node;
            }
            else{
                node.next = this.head;
                this.head = node;
            }
            this.SizeofLL++;
        }
        public void addfirst(int data){
            Node node = new Node(data);
            addfirstnode(node);
        }
        private void addlastnode(Node node) {
            if(this.head == null){
                this.head = node;
                this.tail = node;
            }
            else{
                this.tail.next = node;
                this.tail = node;
            }
            this.SizeofLL++;
        }
        public void addLast(int data){
            Node node = new Node(data);
            addlastnode(node);
        }
        private void addAtNode(int idx, Node node) {
            if (idx == 0)
                addFirstNode(node);
            else if (idx == this.sizeOfLL)
                addLastNode(node);
            else {
                Node prev = getNodeAt(idx - 1);
                Node forw = prev.next;
    
                prev.next = node;
                node.next = forw;
    
                this.sizeOfLL++;
            }
        }
    
        public void addAt(int idx, int data) {
            IndexOutOfBoundSizeInclusiveException(idx);
            Node node = new Node(data);
            addAtNode(idx, node);
        }
    // Remove
        private Node removeFirstNode() {
            Node removeNode = this.head;
            if (this.sizeOfLL == 1) {
                this.head = null;
                this.tail = null;
            } else {
                Node forw = this.head.next;
                removeNode.next = null;
                this.head = forw;
            }
    
            this.sizeOfLL--;
            return removeNode;
        }
    
        public int removeFirst() throws Exception {
            EmptyException();
            Node node = removeFirstNode();
            return node.data;
        }
    
        private Node removeLastNode() {
            Node removeNode = this.tail;
            if (this.sizeOfLL == 1) {
                this.head = null;
                this.tail = null;
            } else {
                Node secondLastNode = getNodeAt(this.sizeOfLL - 2);
                this.tail = secondLastNode;
                this.tail.next = null;
            }
    
            this.sizeOfLL--;
            return removeNode;
    
        }
    
        public int removeLast() {
            EmptyException();
            Node node = removeLastNode();
            return node.data;
        }

    }
}