import java.util.Scanner;

public class l004 {
    public static Scanner scn = new Scanner(System.in);

    public static void display2(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static int[] test1() {
        int n = scn.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = scn.nextInt();
        return arr;
    }

    public static int maximum(int[] arr) {
        int maxEle = -(int) 1e9; // -10^9
        for (int ele : arr) {
            if (ele > maxEle)
                maxEle = ele;
        }
        return maxEle;
    }

    public static int maximum2(int[] arr) {
        if (arr.length == 0)
            return -(int) 1e9;
        int maxEle = arr[0]; // -10^9
        for (int ele : arr) {
            if (ele > maxEle)
                maxEle = ele;
        }
        return maxEle;
    }

    public static int minimum(int[] arr) {
        int minEle = (int) 1e9; // 10^9
        for (int ele : arr) {
            if (ele < minEle)
                minEle = ele;
        }
        return minEle;
    }

    public static boolean findData(int[] arr, int data) {
        for (int ele : arr) {
            if (ele == data)
                return true;
        }

        return false;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // si = starting index, ei = ending index
    public static void reverse(int[] arr, int si, int ei) {
        while (si < ei) {
            swap(arr, si++, ei--);
        }
    }

    public static void inverse(int[] arr) {
        int[] ans = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ans[arr[i]] = i;
        }
    }

    public static void rotate(int[] arr, int k) {
        int n = arr.length;
        k = (k % n + n) % n;
        
        reverse(arr,0,n - 1);
        reverse(arr,0,k - 1);
        reverse(arr,k, n - 1);
    }

    public static void display(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void input(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
    }
      public static void sum2arr(int[] a , int[] b) {
        int n = a.length;
        int m = b.length;
        int r = Math.max(n, m) + 1;
        int[] ans = new int[r];
        int i = n - 1, j = m - 1, k = r - 1;
        int carry = 0;
        while (k >= 0) {
            int sum = carry + (i >= 0 ? a[i--] : 0) + (j >= 0 ? b[j--] : 0);
            ans[k--] += sum % 10;
            carry = sum / 10;
        }
        for (int l = 0; l < ans.length; l++) {
            if (l == 0 && ans[l] == 0) continue;
            System.out.println(ans[l]);
        }

    }
    public static void diff2arr(vector<int>& a,vector<int>& b){
    int n = a.size();
    int m = b.size();
    int r = m ;
    vector<int> ans(r , 0);
    int i = n - 1 , j = m - 1, k = r - 1 ;
    int borr = 0 ;
    while(k>=0){
        int sum = borr + (j >= 0 ? b[j--] : 0) - (i >= 0 ? a[i--] : 0);
        if(sum < 0){
            sum += 10;
            borr = -1;
        }else borr = 0;
        ans[k--] = sum ;
    }
    bool flag = false;
    for(int l = 0 ; l< ans.size() ; l++){
         if(!flag && ans[l] == 0) continue;
        flag = true ; 
        cout<< ans[l] << endl;
        
    }
}
    public static void main(String[] args) {
        int n = scn.nextInt();
        int[] a = new int[n];
        input(a);
        int m = scn.nextInt();
        int[] b = new int[m];
        input(b);
        sum2arr(a,b);
    }
}