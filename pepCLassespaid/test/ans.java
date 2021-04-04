import java.util.*;
public class ans{
    public static void printfibopattern(int n){  // q 1
        int a = 0;
        int b = 1;
        int sum = 0 ;
        for(int r = 1 ; r <= n; r++){
            for(int cst = 1; cst <= r;cst++ ){
                System.out.print(a + "\t");
                sum = a + b ;
                a = b ;
                b = sum ;
                
            }
            System.out.println();
        }
    }
    //============================================================================
    public static long decimaltoanybase(long n, long b){   // q 2
        int power =1  ;
        int res = 0 ;
        while(n != 0){
            long rem = n % b ;
            n /= b ;
            res += rem * power; 
            power *= 10 ;
        }
        return res;
    }
    public static long anybasetodecimal(long n, long b){
        int power =1  ;
        int res = 0 ;
        while(n != 0){
            long rem = n % 10 ;
            n /= 10 ;
            res += rem * power; 
            power *= b ;
        }
        return res;
    }
    public static long anybasetoanybase(long n, long a, long b){
        long ans1 = anybasetodecimal(n,a);
        long ans2 = decimaltoanybase(ans1,b);
        return ans2;
    }
    //============================================================================
    public static String solve(int d ,int k) { // q 3
        int c = 0;
        for (int i = 1; (i*i) <= d; i++) {
            if (issq(d - (i * i)))
                c += 4;
  }
  return c <= k ? "possible" : "impossible";
}
    public static boolean issq(double number)    
    {   
        double sqrt=Math.sqrt(number);   
        return ((sqrt - Math.floor(sqrt)) == 0);   
    }
    //============================================================================
    public static ArrayList<String> getMazePathsmultiMoves(int sr, int sc, int dr, int dc) { // Que 5

        if (sr == dr && sc == dc) {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        ArrayList<String> myAns = new ArrayList<>();
        for (int jump = 1; sc + jump <= dc; jump++) {
            ArrayList<String> Horizontal = getMazePathsmultiMoves(sr, sc + jump, dr, dc);
            for (String s : Horizontal) {
                myAns.add("H" + jump + s);
            }
        }

        for (int jump = 1; sr + jump <= dr; jump++) {
            ArrayList<String> Vertical = getMazePathsmultiMoves(sr + jump, sc, dr, dc);
            for (String s : Vertical) {
                myAns.add("V" + jump + s);
            }
        }

        for (int jump = 1; sr + jump <= dr && sc + jump <= dc; jump++) {
            ArrayList<String> Digonal = getMazePathsmultiMoves(sr + jump, sc + jump, dr, dc);
            for (String s : Digonal) {
                myAns.add("D" + jump + s);
            }
        }

        return myAns;
    }
    public static int numberofelements(int x,int y){
        ArrayList<String> ans = new ArrayList<>();
           ans =  getMazePathsmultiMoves(1,1,x,y);
        int count = 0;
        for(int i = 0; i < ans.size(); i++){
            count = count + 1;
        }
        return count;
        
    }
    
     public static void getMazePaths_multiMoves(int sr, int sc, int dr, int dc, String ans) {
        if (sr == dr && sc == dc) {
            System.out.println(ans);
            return;
        }

        for (int jump = 1; sc + jump <= dc; jump++)
            getMazePaths_multiMoves(sr, sc + jump, dr, dc, ans + 'H' + jump);
        for (int jump = 1; sr + jump <= dr; jump++)
            getMazePaths_multiMoves(sr + jump, sc, dr, dc, ans + 'V' + jump);
        for (int jump = 1; sr + jump <= dr && sc + jump <= dc; jump++)
            getMazePaths_multiMoves(sr + jump, sc + jump, dr, dc, ans + 'D' + jump);

    }
    //============================================================================
}