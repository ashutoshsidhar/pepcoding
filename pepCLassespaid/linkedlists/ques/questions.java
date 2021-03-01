public class questions {
    public class Node {
        int data;
        Node next;
    }

    Node head = null;
    Node tail = null;

    public int mid() {
        Node slow = head;
        Node fast = head;
        // while(fast != null && fast.next != null) // 2nd mid of even length linkedlist
        while (fast.next != null && fast.next.next != null) { // 1mid of even length linkedlist
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow.data;
    }

    public void reversePI(){
        Node curr = head;
          Node prev = null;
          while (curr != null) {
              Node forw = curr.next; // backup
  
              curr.next = prev; // link
  
              prev = curr; // move
              curr = forw;
          }
          
          tail = head;
          head = prev;
      }
      private Node getNodeAt(int idx) {
        Node temp = head;
        for (int i = 0; i < idx; i++) {
          temp = temp.next;
        }
        return temp;
      }
      public void reverseDI(){
          int i = 0;
          int j = size - 1 ;
          while(i < j){
              Node in = getNodeAt(i);
              Node jn = getNodeAt(j);
              int temp = in.data;
              in.data = jn.data;
              jn.data = temp;

              i++;
              j--;
          } 
      }
      private void displayReverseHelper(Node node){
        if(node == null){
          return;
        }
        displayReverseHelper(node.next);
        System.out.print(node.data + " ");
      }
      private void reversePRHelper(Node node){
        if(node == tail){
          return;
        }
        reversePRHelper(node.next);
        node.next.next = node;
      }
  
      public void reversePR(){
        reversePRHelper(head);
        Node temp = head;
        head = tail;
        tail = temp;
        tail.next = null;
      }
    }
    public int kthFromLast(int k){
        Node slow = head;
        Node fast = head;
        for(int i = 0; i < k; i++){
          fast = fast.next;
        }
  
        while(fast != null && fast != tail){
          slow = slow.next;
          fast = fast.next;
        }
  
        return slow.data;
    }
    public static LinkedList mergeTwoSortedLists(LinkedList l1, LinkedList l2) {
        LinkedList ml = new LinkedList();
  
        Node A = l1.head;
        Node B = l2.head;
        while (A != null && B != null) {
          if (A.data < B.data) {
            ml.addLast(A.data);
            A = A.next;
          } else {
            ml.addLast(B.data);
            B = B.next;
          }
        }
  
        while (A != null) {
          ml.addLast(A.data);
          A = A.next;
        }
  
        while (B != null) {
          ml.addLast(B.data);
          B = B.next;
        }
  
        return ml;
    }
    public static Node midnode(Node head){
      Node slow = head;
      Node fast = head;
      while(fast.next != null && fast.next.next != null){
          fast = fast.next.next;
          slow = slow.next;
      }
      return slow ;
  }

  public static LinkedList mergeSort(Node head, Node tail){
   if(head == tail){
       LinkedList base = new LinkedList();
       base.addLast(head.data);
       return base;
   }
   Node m = midnode(head);
   Node Head1 = head;
   Node Tail1 = m;
   Node Head2 = m.next;
   Node Tail2 = tail;
   m.next = null;
   LinkedList FH = mergeSort(Head1,Tail1);
   LinkedList SH = mergeSort(Head2,Tail2);
   m.next = Head2;
   return mergeTwoSortedLists(FH,SH);
   
   
  }
  // Add 2 lists recursive method
  public static int addTwoLists(Node FH, Node SH, int FS, int SS, LinkedList res){
      if(FH == null && SH == null){
        return 0;
      }

      int carry = 0;
      int data = 0;
      if(FS > SS){
        carry = addTwoLists(FH.next, SH, FS - 1, SS, res);
        data = carry + FH.data;
      } else if(FS < SS){
        carry = addTwoLists(FH, SH.next, FS, SS - 1, res);
        data = carry + SH.data;
      } else {
        carry = addTwoLists(FH.next, SH.next, FS - 1, SS - 1, res);
        data = carry + FH.data + SH.data;
      }

      carry = data / 10;
      data = data % 10;

      res.addFirst(data);
      return carry;
    }

    public static LinkedList addTwoLists(LinkedList one, LinkedList two) {
      LinkedList res = new LinkedList();

      int carry = addTwoLists(one.head, two.head, one.size, two.size, res);
      if(carry > 0){
        res.addFirst(carry);
      }

      return res;
    }
    //add 2 lists reverse pi method
    public static LinkedList addTwoLists(LinkedList one, LinkedList two) {
      one.reversePI();
      two.reversePI();
      LinkedList Ans = new LinkedList();
      Node c1 = one.head;
      Node c2 = two.head;
      int carry = 0;
      while(c1 != null || c2 != null || carry != 0){
          int sum = (c1 != null ? c1.data : 0) + (c2 != null ? c2.data : 0) + carry;
          carry = sum / 10 ;
          sum = sum % 10 ;
          Ans.addFirst(sum);
          if(c1 != null) c1 = c1.next;
          if(c2 != null) c2 = c2.next;
          
      }
      one.reversePI();
      two.reversePI();
      
      return Ans;
      
    }

}