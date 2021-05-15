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
     //leetcode 1035
     public int maxUncrossedLines(int[] A, int[] B) {
        int n = A.length;
        int m = B.length;
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++){
            for (int j = 0; j <= m; j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 0 ;
                    continue;
                }
                if (A[i - 1] == B[j - 1]){
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }
                else{
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[n][m];
    }
    public int minDistance_memo(String word1, String word2,int i ,int j, int[][] dp) {
        if(i == 0 || j == 0){
            return dp[i][j] = (i == 0)? j : i ;
         }
         if(dp[i][j] != -1){
             return dp[i][j];
         }
         int insert = minDistance_memo(word1, word2, i, j - 1, dp);
         int replace = minDistance_memo(word1, word2, i - 1 , j - 1, dp);
         int delete = minDistance_memo(word1, word2, i - 1 , j, dp);
         if (word1.charAt(i - 1) == word2.charAt(j - 1)){
            return dp[i][j] = replace;
        }
        else{
            return dp[i][j] = Math.min(Math.min(insert,replace),delete) + 1;
        }
    }
    public int minDistance(String s1, String s2){
        int n = s1.length(), m = s2.length();
        int[][] dp = new int[n + 1][m + 1];
        for(int[] d : dp){
            Arrays.fill(d, - 1);
        }
        return minDistance_memo(s1,s2,n,m,dp);
    }
    public int minDistance_tab(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n + 1][m + 1];
        for(int i = 0 ; i <=n ; i++){
            for(int j = 0 ; j <=m ; j++){
                if (i == 0 || j == 0) {
                    dp[i][j] = (i == 0 ? j : i);
                    continue;
                }
                 
                 int insert = dp[i][j - 1];
                 int replace = dp[i - 1][j - 1];
                 int delete = dp[i - 1][j];
                 if (word1.charAt(i - 1) == word2.charAt(j - 1)){
                    dp[i][j] = replace;
                }
                else{
                    dp[i][j] = Math.min(Math.min(insert,replace),delete) + 1;
                }
            }
        }
        return dp[n][m];
        // https://www.geeksforgeeks.org/edit-distance-and-lcs-longest-common-subsequence/?ref=rp
    // where we are allowed only two operations insert and delete, find edit
    // distance in this variation.

    public static int LCSS(String s1, String s2) {
        int N = s1.length(), M = s2.length();
        int[][] dp = new int[N + 1][M + 1];
        for (int n = 0; n <= N; n++) {
            for (int m = 0; m <= M; m++) {

                if (n == 0 || m == 0) {
                    dp[n][m] = 0;
                    continue;
                }

                if (s1.charAt(n - 1) == s2.charAt(m - 1))
                    dp[n][m] = dp[n - 1][m - 1] + 1;
                else
                    dp[n][m] = Math.max(dp[n - 1][m], dp[n][m - 1]);
            }
        }

        return dp[N][M];
    }

    public static void editDistanceVariation(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        int LCSS = LCSS(s1, s2);

        int ans = (n - LCSS) + (m - LCSS);
    }

    // https://practice.geeksforgeeks.org/problems/minimum-deletitions1648/1
    public static int LPSS(String str, int I, int J, int[][] dp) {
        int n = str.length();
        for (int gap = 0; gap < n; gap++) {
            for (int i = 0, j = gap; j < n; i++, j++) {
                if (i >= j) {
                    dp[i][j] = (i == j) ? 1 : 0;
                    continue;
                }

                if (str.charAt(i) == str.charAt(j))
                    dp[i][j] = dp[i + 1][j - 1] + 2;// LPSS(str, i + 1, j - 1, dp) + 2;
                else
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
            }
        }

        return dp[I][J];
    }

    public static void minDeleteToMakePlaindrome(String str) {
        int n = str.length();
        int[][] dp = new int[n][n];

        int ans = n - LPSS(str, 0, n - 1, dp);
    }
    }
    public static void main(String[] args){
        FreindsPairing();
    }
}