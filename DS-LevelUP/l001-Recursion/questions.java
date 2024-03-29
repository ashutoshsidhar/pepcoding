import java.util.Arrays;
import java.util.ArrayList;

public class questions {
    int mod = (int) 1e9 + 7;

    // https://practice.geeksforgeeks.org/problems/special-matrix4201/1#F
    public int dfs(int sr, int sc, int er, int ec, boolean[][] block, int[][] dp) {
        if (sr == er && sc == ec)
            return dp[sr][sc] = 1;

        if (dp[sr][sc] != -1)
            return dp[sr][sc];
        int count = 0;
        if (sc + 1 <= ec && !block[sr][sc + 1])
            count = (count % mod + dfs(sr, sc + 1, er, ec, block, dp) % mod) % mod;
        if (sr + 1 <= er && !block[sr + 1][sc])
            count = (count % mod + dfs(sr + 1, sc, er, ec, block, dp) % mod) % mod;

        return dp[sr][sc] = count;
    }

    public int FindWays(int n, int m, int[][] blocked_cells) {
        n++;
        m++;
        boolean[][] block = new boolean[n][m];

        for (int[] b : blocked_cells)
            block[b[0]][b[1]] = true;

        if (block[1][1] || block[n - 1][m - 1])
            return 0;

        int[][] dp = new int[n][m];
        for (int[] d : dp)
            Arrays.fill(d, -1);

        return dfs(1, 1, n - 1, m - 1, block, dp);
    }

    public static int floodFill(int sr, int sc, int er, int ec, int[][] dir, String[] Sdir, int[][] vis, String psf,
            ArrayList<String> res) {

        if (sr == er && sc == ec) {
            res.add(psf);
            return 1;
        }

        int count = 0;
        vis[sr][sc] = 0;
        for (int d = 0; d < dir.length; d++) {
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];

            if (r >= 0 && c >= 0 && r <= er && c <= ec && vis[r][c] == 1) {
                count += floodFill(r, c, er, ec, dir, Sdir, vis, psf + Sdir[d], res);
            }
        }

        vis[sr][sc] = 1;
        return count;
    }

    public static ArrayList<String> findPath(int[][] mat, int n) {
        int[][] dir = { { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 } };
        String[] Sdir = { "L", "R", "U", "D" };

        // System.out.println(floodFill(0, 0, n - 1, m - 1, dir, Sdir, vis, ""));
        ArrayList<String> res = new ArrayList<>();
        if (mat[0][0] == 0 || mat[n - 1][n - 1] == 0)
            return res;
        int ans = floodFill(0, 0, n - 1, n - 1, dir, Sdir, mat, "", res);

        Collections.sort(res);
        return res;
    }
    //leetcode 39=============================================================================
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        combinationswithinfy(candidates, 0, target, 0, temp, result);
        return result;
    }
    private void combinationswithinfy(int[] candidates, int start, int target, int sum,List<Integer> list, List<List<Integer>> result){
        if(sum > target){
            return;
        }

        if(sum == target){
            result.add(new ArrayList<>(list));
            return;
        }

        for(int i=start; i<candidates.length; i++){
            list.add(candidates[i]);
            combinationswithinfy(candidates, i, target, sum+candidates[i], list, result);
            list.remove(list.size()-1);
        }
    }
    // 40
    public int combinationSum2(int[] arr, int tar, int idx, List<Integer> smallAns, List<List<Integer>> res) {
        if (tar == 0) {
            List<Integer> base = new ArrayList<>(smallAns);
            res.add(base);
            return 1;
        }

        int count = 0;
        boolean[] vis = new boolean[51];
        for (int i = idx; i < arr.length; i++) {
            if (!vis[arr[i]] && tar - arr[i] >= 0) {

                vis[arr[i]] = true;

                smallAns.add(arr[i]);
                count += combinationSum2(arr, tar - arr[i], i + 1, smallAns, res);
                smallAns.remove(smallAns.size() - 1);
            }
        }

        return count;
    }

    public int combinationSum2_01(int[] arr, int tar, int idx, List<Integer> smallAns, List<List<Integer>> res) {
        if (tar == 0) {
            List<Integer> base = new ArrayList<>(smallAns);
            res.add(base);
            return 1;
        }

        int count = 0;
        int prev = -1;
        for (int i = idx; i < arr.length; i++) {
            if (prev != arr[i] && tar - arr[i] >= 0) {
                smallAns.add(arr[i]);
                count += combinationSum2_01(arr, tar - arr[i], i + 1, smallAns, res);
                smallAns.remove(smallAns.size() - 1);
            }

            if (tar - arr[i] < 0)
                break;

            prev = arr[i];
        }

        return count;
    }

    public int combinationSum2_03(int[] arr, int tar, int idx, List<Integer> smallAns, List<List<Integer>> res) {
        if (tar == 0 || idx >= arr.length) {
            if (tar == 0) {
                List<Integer> base = new ArrayList<>(smallAns);
                res.add(base);
                return 1;
            }
            return 0;
        }

        int count = 0;
        if (tar - arr[idx] >= 0) {
            smallAns.add(arr[idx]);
            count += combinationSum2_03(arr, tar - arr[idx], idx + 1, smallAns, res);
            smallAns.remove(smallAns.size() - 1);
        }

        idx++;
        while (idx < arr.length && arr[idx - 1] == arr[idx]) {
            idx++;
        }

        count += combinationSum2_03(arr, tar, idx, smallAns, res);
        return count;
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> smallAns = new ArrayList<>();

        Arrays.sort(candidates);

        combinationSum2(candidates, target, 0, smallAns, res);

        return res;
    }

    // 77
    public int combine(int n, int k, int idx, List<Integer> smallAns, List<List<Integer>> res) {
        if (k == 0) {
            List<Integer> base = new ArrayList<>(smallAns);
            res.add(base);
            return 1;
        }

        int count = 0;
        for (int i = idx; i <= n; i++) {
            smallAns.add(i);
            count += combine(n, k - 1, i + 1, smallAns, res);
            smallAns.remove(smallAns.size() - 1);
        }

        return count;
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> smallAns = new ArrayList<>();

        combine(n, k, 1, smallAns, res);

        return res;
    }

    // 216
    public int combinationSum3(int tar, int k, int idx, List<Integer> smallAns, List<List<Integer>> res) {
        if (k == 0 || tar == 0) {
            if (tar == 0 && k == 0) {
                List<Integer> base = new ArrayList<>(smallAns);
                res.add(base);
                return 1;
            }
            return 0;
        }

        int count = 0;
        for (int i = idx; i <= 9; i++) {
            if (tar - i >= 0) {
                smallAns.add(i);
                count += combinationSum3(tar - i, k - 1, i + 1, smallAns, res);
                smallAns.remove(smallAns.size() - 1);
            } else
                break;
        }

        return count;
    }

    public List<List<Integer>> combinationSum3(int k, int tar) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> smallAns = new ArrayList<>();

        combinationSum3(tar, k, 1, smallAns, res);

        return res;
    }
     // 46

    // tel = total no of elements.
    public int permute(int[] arr, int tel, List<Integer> smallAns, List<List<Integer>> res) {
        if (tel == 0) {
            List<Integer> base = new ArrayList<>(smallAns);
            res.add(base);
            return 1;
        }

        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > -11) { // -11, as per constraints.
                int val = arr[i];
                arr[i] = -11;
                smallAns.add(val);

                count += permute(arr, tel - 1, smallAns, res);

                smallAns.remove(smallAns.size() - 1);
                arr[i] = val;
            }
        }
        return count;
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> smallAns = new ArrayList<>();

        permute(nums, nums.length, smallAns, res);

        return res;
    }

    // 47
    public int permuteUnique(int[] arr, int tel, List<Integer> smallAns, List<List<Integer>> res) {
        if (tel == 0) {
            List<Integer> base = new ArrayList<>(smallAns);
            res.add(base);
            return 1;
        }

        int count = 0;
        int prev = -12;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > -11 && prev != arr[i]) { // -11, as per constraints.
                int val = arr[i];
                arr[i] = -11;
                smallAns.add(val);

                count += permuteUnique(arr, tel - 1, smallAns, res);

                smallAns.remove(smallAns.size() - 1);
                arr[i] = val;

                prev = arr[i];
            }
        }
        return count;
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> smallAns = new ArrayList<>();

        Arrays.sort(nums);
        permuteUnique(nums, nums.length, smallAns, res);

        return res;
    }
    public static int divsum(int[] arr,int idx,int sum1 , String s1,int sum2 , String s2){
        if(idx == arr.length){
            if(sum1 == sum2){
                System.out.println(s1 + "=" + s2);
                return 1;
            }
            return 0;
        }
        int count = 0 ;
        count += divsum(arr, idx + 1, sum1 + arr[idx], s1 + arr[idx], sum2, s2);
        count += divsum(arr, idx + 1, sum1, s1, sum2 + arr[idx], s2 + arr[idx]);
        return count;
    }
}