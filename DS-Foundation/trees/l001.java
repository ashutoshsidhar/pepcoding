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
        if (root == null) return false ;
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
            printAtKDepth(path.get(i), block, k - i, ans);
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

    public static void removeLeaves(Node node, Node par) {
        if (node == null)
            return;
        if (node.left == null && node.right == null) {
            if (par.left == node)
                par.left = null;
            else
                par.right = null;

            return;
        }

        removeLeaves(node.left, node);
        removeLeaves(node.right, node);
    }

    public static Node removeLeaves2(Node node) {
        if (node.left == null && node.right == null)
            return null;
        removeLeaves(node, null);

        return node;
    }

    public static Node prev = null;

    public static boolean isBST(Node node) {
        if (node == null)
            return true;

        boolean leftRes = isBST(node.left);
        if (!leftRes)
            return false;

        if (prev != null && prev.data > node.data)
            return false;
        prev = node;

        boolean rightRes = isBST(node.right);
        if (!rightRes)
            return false;

        return true;
    }

    public static class isBSTSolPair {
        int maxEle = -(int) 1e8;
        int minEle = (int) 1e8;
        boolean isBST = true;

        boolean isBal = true;
        int height = -1;

        int largestBSTSize = 0;
        Node largestBSTNode = null;

        int totalNoOfBST = 0;
    }

    public isBSTSolPair isBST_(Node node) {
        if (node == null) {
            // isBSTSolPair base = new isBSTSolPair();
            // return base;

            return new isBSTSolPair();
        }

        isBSTSolPair left = isBST_(node.left);
        isBSTSolPair right = isBST_(node.right);

        isBSTSolPair myRes = new isBSTSolPair();
        myRes.isBST = false;
        if (left.isBST && right.isBST && left.maxEle < node.data && node.data < right.minEle) {
            myRes.isBST = true;
            myRes.maxEle = Math.max(node.data, right.maxEle);
            myRes.minEle = Math.min(node.data, left.minEle);
        }

        return myRes;
    }

    public static class isBalPair {
        int height = -1;
        boolean balanceTree = true;
    }

    public static isBalPair isBal_(Node node) {
        if (node == null)
            return new isBalPair();

        isBalPair left = isBal_(node.left);
        if (!left.balanceTree)
            return left;

        isBalPair right = isBal_(node.right);
        if (!right.balanceTree)
            return right;

        isBalPair myRes = new isBalPair();
        myRes.balanceTree = false;
        if (left.balanceTree && right.balanceTree && Math.abs(left.height - right.height) <= 1) {
            myRes.balanceTree = true;
            myRes.height = Math.max(left.height, right.height) + 1;
        }

        return myRes;
    }

    public static boolean isBal(Node node) {
        isBalPair ans = isBal_(node);
        return ans.balanceTree;
    }

    public static isBSTSolPair allsolution(Node node) {
        if (node == null) {
            return new isBSTSolPair();
        }

        isBSTSolPair left = allsolution(node.left);
        isBSTSolPair right = allsolution(node.right);

        isBSTSolPair ans = new isBSTSolPair();

        ans.isBST = left.isBST && right.isBST && left.maxEle < node.data && node.data < right.minEle;
        ans.isBal = left.isBal && right.isBal && Math.abs(left.height - right.height) <= 1;

        ans.maxEle = Math.max(node.data, right.maxEle);
        ans.minEle = Math.min(node.data, left.minEle);
        ans.height = Math.max(left.height, right.height) + 1;

        ans.totalNoOfBST = left.totalNoOfBST + right.totalNoOfBST + (ans.isBST ? 1 : 0);

        if (ans.isBST) {
            ans.largestBSTNode = node;
            ans.largestBSTSize += left.largestBSTSize + right.largestBSTSize + 1;
        } else {
            if (left.largestBSTSize > right.largestBSTSize) {
                ans.largestBSTNode = left.largestBSTNode;
                ans.largestBSTSize = left.largestBSTSize;
            } else {
                ans.largestBSTNode = right.largestBSTNode;
                ans.largestBSTSize = right.largestBSTSize;
            }
        }
        return ans;
    }
    public static Node LCA(Node node, int p, int q) {
        ArrayList<Node> list1 = new ArrayList<>();
        ArrayList<Node> list2 = new ArrayList<>();

        rootToNodePath(node, p, list1);
        rootToNodePath(node, q, list2);

        int i = list1.size() - 1;
        int j = list2.size() - 1;

        Node lca = null;
        while (i >= 0 && j >= 0) {
            if (list1.get(i) != list2.get(j))
                break;

            lca = list1.get(i);
            i--;
            j--;
        }

        return lca;
    }
    

}
