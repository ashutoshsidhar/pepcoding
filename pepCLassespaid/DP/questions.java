import java.util.Arrays;

import javax.print.event.PrintEvent;

public class questions {
    public static void print(int[] arr) {
        for (int ele : arr)
            System.out.print(ele + " ");
        System.out.println();
    }

    // 62
    public int mazePath_HDV_DP(int SR, int SC, int er, int ec, int[][] dir, int[][] dp) {

        for (int sr = er; sr >= 0; sr--) {
            for (int sc = ec; sc >= 0; sc--) {
                if (sr == er && sc == ec) {
                    dp[sr][sc] = 1;
                    continue;
                }

                int count = 0;
                for (int d = 0; d < dir.length; d++) {
                    int r = sr + dir[d][0];
                    int c = sc + dir[d][1];
                    if (r >= 0 && c >= 0 && r <= er && c <= ec) {
                        count += dp[r][c];// mazePath_HDV(r, c, er, ec, dir, dp);
                    }
                }

                dp[sr][sc] = count;
            }
        }

        return dp[SR][SC];
    }

    public int uniquePaths(int n, int m) {
        int[][] dp = new int[n][m];
        int[][] dir = { { 1, 0 }, { 0, 1 } };

        return mazePath_HDV_DP(0, 0, n - 1, m - 1, dir, dp);
    }

    // 63
    public int mazePath_HDV_DP(int SR, int SC, int er, int ec, int[][] dir, int[][] dp, int[][] obstacleGrid) {

        for (int sr = er; sr >= 0; sr--) {
            for (int sc = ec; sc >= 0; sc--) {
                if (sr == er && sc == ec) {
                    dp[sr][sc] = 1;
                    continue;
                }

                int count = 0;
                for (int d = 0; d < dir.length; d++) {
                    int r = sr + dir[d][0];
                    int c = sc + dir[d][1];
                    if (r >= 0 && c >= 0 && r <= er && c <= ec && obstacleGrid[r][c] == 0) {
                        count += dp[r][c];// mazePath_HDV(r, c, er, ec, dir, dp);
                    }
                }

                dp[sr][sc] = count;
            }
        }

        return dp[SR][SC];
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length, m = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1 || obstacleGrid[n - 1][m - 1] == 1)
            return 0;

        int[][] dp = new int[n][m];
        int[][] dir = { { 1, 0 }, { 0, 1 } };

        return mazePath_HDV_DP(0, 0, n - 1, m - 1, dir, dp, obstacleGrid);
    }
    // Friends Pairing
    public static int FreindsPairing_memo(int n, int[] dp){
        if(n <= 1){
            return dp[n] = 1 ;
        }
        if(dp[n] != 0){
            return dp[n];
        }
        int single = FreindsPairing_memo(n - 1, dp);
        int pairup = FreindsPairing_memo(n - 2, dp) * (n - 1) ;
        return dp[n] = single + pairup;
    }
    public static int FreindsPairing_dp(int N, int[] dp){
        for(int n = 0 ; n <= N; n++){
            if(n <= 1){
                dp[n] = 1 ;
                continue;
            }

            int single = dp[n - 1];
            int pairup = dp[n - 2];
            dp[n] = single + pairup;
        }
        return dp[N];
    }
    public static int FreindsPairing_opti(int n){
        int a = 1;
        int b = 1;
        for(int i = 2 ; i < n ; n++){
            int sum = b + a * (i - 1);
            a = b;
            b = sum;
        } 
        return b;
    }
    public static void FreindsPairing(){
        int n = 10;
        int[] dp = new int[n + 1];
        // System.out.println(FreindsPairing_dp(n,dp));
        // print(dp);
        System.out.println(FreindsPairing_opti(n) + " ");
    }
    //goldmine ques
    public static void goldmine_memo(int[][] arr,int r ,int c , int[][] dp, int[][] dir){
        
    }
    public static void goldmine_memo(int[][] arr){
        int n = arr.length;
        int m = arr[0].length;
        int[][] dir = {{ 0 , 1 },{ 1 , 1 },{ -1 , 1 }};
        int[][] dp = new int[n][m];
        for(int[] d : dp)
            Arrays.fill(d, -1);
        int maxGold = 0;
        for(int i = 0 )
    }
    public static int longestPalindromeSubseq(String s) {
        
    }
    public static void main(String[] args){
        FreindsPairing();
    }
}