import java.util.ArrayList;

public class l001{
    public static class Node {
        int data = 0;
        Node left = null;
        Node right = null;

        Node(int data) {
            this.data = data;
        }
    }
    public static void preorder(Node root,ArrayList<Integer> ans){
        if(root == null) return ;
        ans.add(root.data);
        preorder(root.left,ans);
        preorder(root.right,ans);
    }
    public static void inorder(Node root,ArrayList<Integer> ans){
        if(root == null) return ;
        inorder(root.left,ans);
        ans.add(root.data);
        inorder(root.right,ans);
    }
    public static void postorder(Node root,ArrayList<Integer> ans){
        if(root == null) return ;
        postorder(root.left,ans);
        postorder(root.right,ans);
        ans.add(root.data);
    }
    public static void traversal(Node root){
        ArrayList<Integer> ans = new ArrayList<>();
        preorder(root, ans);
        inorder(root, ans);
        postorder(root, ans);
    }
    public static int size(Node root){
        if(root == null) return 0;
        int left = size(root.left);
        int right = size(root.right);
        return left + right + 1 ;
    }
    public static int heightedge(Node root){
        if(root == null) return -1;
        int leftheight = heightedge(root.left);
        int righteight = heightedge(root.right);
        return Math.max(leftheight,righteight) + 1 ;
    }
    public static int heightnode(Node root){
        if(root == null) return 0;
        int leftheight = heightedge(root.left);
        int righteight = heightedge(root.right);
        return Math.max(leftheight,righteight) + 1 ;
    }
    public static int Maximum(Node root){
        if(root == null) return -(int)1e8;
        int leftmax = Maximum(root.left);
        int rightmax = Maximum(root.right);
        return Math.max(Math.max(leftmax,rightmax),root.data) ;
    }
    public static int minimum(Node root){
        if(root == null) return -(int)1e8;
        int leftmin = minimum(root.left);
        int rightmin = minimum(root.right);
        return Math.min(Math.min(leftmin,rightmin),root.data) ;
    }
    public static int sum(Node root){
        if(root == null) return 0;
        int leftsum = sum(root.left);
        int rightsum = sum(root.right);
        return leftsum + rightsum + root.data ;
    }
    // public static boolean finddata(Node root, int data){
    //     if(root == null) return false; // false
    //     if(root.data == data) return true;
    //     boolean left = finddata(root.left,data);
    //     if(left) return true;
    //     else{
    //         boolean right = finddata(root.right,data);
    //         if(right) return true;
    //     }
    // }
    public static boolean finddata(Node root, int data){
        if (root = null) return false ;
        boolean res = root.data == data ;
        return res || finddata(root.left,data) || finddata(root.right,data) ;
    }
    public static boolean findData2(Node root, int data) {
        if (root == null)
            return false;

        if (root.data == data)
            return true;

        boolean left = findData(root.left, data);
        if (left)
            return true;

        boolean right = findData(root.right, data);
        if (right)
            return true;

        return false;
    }

    public static boolean rootToNodePath(Node root, int data, ArrayList<Node> ans) {
        if (root == null)
            return false;
        boolean res = (root.data == data) || rootToNodePath(root.left, data, ans)
                || rootToNodePath(root.right, data, ans);

        if (res)
            ans.add(root);
        return res;
    }

    public static void printAtKDepth(Node root, int k,Node block, ArrayList<Integer> ans) {
        if(root == null || root.data == block || k < 0) return;

        if(k == 0){
            ans.add(root.data);
            return;
        }

        printAtKDepth(root.left, k - 1, block , ans);
        printAtKDepth(root.right, k - 1, block, ans);
    }
    public ArrayList<Integer> distanceK(Node root, Node target, int k) {
        ArrayList<Node> path = new ArrayList<>();
        rootToNodePath(root, target.data, path);

        Node block = null;
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < path.size(); i++) {
            printAtDepthK(path.get(i), block, k - i, ans);
            block = path.get(i);
        }

        return ans;
    }

    public static void printSingleChildNodes(Node node, Node parent) {
        if (node == null)
            return;
        if (parent != null && (parent.left == null || parent.right == null)) {
            System.out.println(node.data);
        }

        printSingleChildNodes(node.left, node);
        printSingleChildNodes(node.right, node);
    }

    public static Node removeLeaves(Node node){
        if(node == null) return null;
        if(node.left == null && node.right == null) return null;
        
        node.left = removeLeaves(node.left);
        node.right = removeLeaves(node.right);
        return node; 
    }

    public static void removeLeaves2(Node node,??){
         
    }

}
