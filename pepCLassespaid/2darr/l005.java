import java.util.Scanner;
public class l005{
    public static Scanner scn = new Scanner(System.in); 
    public static void input(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = scn.nextInt();
            }
        }
    }

    public static void display1(int[][] arr){
        int n = arr.length;
        int m = arr[0].length;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; i < m ; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void display(int[][] arr){
        for(int[] ar : arr)
            for(int e : ar)
                System.out.print(e + " ");
            System.out.println();
    }
    public static int maxele(int[][] arr){
        int maxel = -(int)1e9;
        for(int[] ar : arr)
            for(int e : ar)
               maxel = Math.max(maxel,e)
        return maxel ;
    }
    public static int minele(int[][] arr){
        int minel = -(int)1e9;
        for(int[] ar : arr)
            for(int e : ar)
               minel = Math.min(minel,e)
        return minel ;
    }
    public static boolean find(int[][] arr, int data){
        for(int[] ar : arr)
            for(int e : ar)
               if(e == data) return true ;
        return false ;
    }
    public static int rotatematrixby90d(int[][] arr){
        int n = arr.length;
        int[][] newarr = new int[n][n];
        for(int i = 0 ; i < n ; i++){
            for(int k = 0 ; k <= i ; k++){
                for(int j = n - 1 ; j >= 0 ; j--){
                    
                    newarr[i][k] = arr[j][i];
                } 
            }
        }
        return newarr;
    }
    public static void spiraltrav(int[][] arr){
        int n = arr.length;
        
    }
    public static void main(String[] args) throws Exception{
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] arr = new int[n][m];
        input(arr);
        display(arr);

    }
}