import java.util.ArrayList;

public class bst {
    public static class Node {
        int data = 0;
        Node left = null;
        Node right = null;

        Node(int data) {
            this.data = data;
        }
    }

    public static Node constructTree(int[] arr, int si, int ei) {
        if (si > ei)
            return null;

        int mid = (si + ei) / 2;
        Node node = new Node(arr[mid]);

        node.left = constructTree(arr, si, mid - 1);
        node.right = constructTree(arr, mid + 1, ei);

        return node;
    }

    public static Node constructTree(int[] arr){
        return constructTree(arr, 0, arr.length - 1);
    }

    public static int size(Node root){
        if(root == null) return 0;
        int left = size(root.left);
        int right = size(root.right);
        return left + right + 1 ;

    }
    public static int sum(Node root){
        if(root == null) return 0;
        int leftsum = sum(root.left);
        int rightsum = sum(root.right);
        return leftsum + rightsum + root.data ;
    }

    public static int height(Node root){
        if(root == null) return -1;
        int leftheight = height(root.left);
        int righteight = height(root.right);
        return Math.max(leftheight,righteight) + 1 ;

    }

    public static int maximum(Node node){
        Node curr = node;
        while(curr.right != null){
            curr = curr.right;
        }
        return curr.data;
    }

    public static int minimum(Node node){
        Node curr = node;
        while(curr.left != null){
            curr = curr.left;
        }
        return curr.data;
    }

    public static boolean find(Node node,int data){
        while (node != null) { 
            if (data > node.data) 
                node = node.right;  
            else if (data < node.data) 
                node = node.left; 
            else
                return true; 
        } 
        return false; 
    } 
    public static Node add(Node node, int data){
        if (node == null) {
            Node node0 = new Node(data);
            return node0;
          }
      
          if (data > node.data) {
            node.right = add(node.right, data);
            return node;
          } else if (data < node.data) {
            node.left = add(node.left, data);
            return node;
          } else {
            return node;
          }
    }
    public static int lca(Node node, int d1, int d2) {
        if(node.data < d1 && node.data < d2){
            return lca(node.right, d1, d2);
        }
        else if(node.data > d1 && node.data > d2){
            return lca(node.left, d1, d2);
        }else {
            return (find(node,d1) && find(node,d1)) ? node.data : null;
        }
      } 
      public static Node remove(Node node, int data) {
        if(node == null) return null;
        
        if(node.data > data){
            node.left = remove(node.left, data);
            
        }
        else if(node.data < data){
            node.right = remove(node.right, data);
            
        }
        else{
            if(node.left == null || node.right == null)
                return node.left !=null ? node.left : node.right ;
            
            int max = maximum(node.left);
            node.data = max;
            node.right = remove(node.left, max);
        }
        return node;
      }
      public static void inorder(Node node , ArrayList<Integer> list){
          if ( node == null) return;
          inorder(node.left, list);
          list.add(node.data);
          inorder(node.right, list);

      }
      public static void targetsumpair(Node node, int TS ){
          ArrayList<Integer> list = new ArrayList<>();
          inorder(node, list);
          int i = 0 , j = list.size() - 1 ;
          while(i < j){
              int sum = list.get(i) + list.get(j);
              if(sum < TS) i++;
              else if (sum > TS) j--;
              else{
                  System.out.println(list.get(i) + " " + list.get(j));
                  i++;
                  j--;
              }
          }
      }
}