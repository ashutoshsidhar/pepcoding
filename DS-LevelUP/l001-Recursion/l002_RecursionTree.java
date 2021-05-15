public class l002_RecursionTree{
    public static int permutationwithInf(int[] arr,int tar,String ans){
        if(tar == 0){
            System.out.println(ans);
            return 1;
        }
        int count = 0 ;
        for(int ele : arr){
            if(tar - ele >=0){
                count += permutationwithInf(arr, tar - ele, ans + ele);
            }
        }
        return count;
    }
    public static int combinationswithInf(int[] arr,int tar,int idx,String ans){
        if(tar == 0){
            System.out.println(ans);
            return 1;
        }
        int count = 0;

        for(int i = idx; i < arr.length; i++){
            if(tar - arr[i] >=0){
                count += combinationswithInf(arr, tar - arr[i], i , ans + arr[i]);

            }
        }
        return count;
    }
    public static int combinationswithSingleCoin(int[] arr,int tar,int idx,String ans){
        if(tar == 0){
            System.out.println(ans);
            return 1;   
        }
        int count = 0;

        for(int i = idx; i < arr.length; i++){
            if(tar - arr[i] >= 0){
                count += combinationswithSingleCoin(arr, tar - arr[i], i + 1 , ans + arr[i]);

            }
        }
        return count;
    }
    public static int permutationWithInfi_subSeq(int[] arr, int tar, String ans) {

    }

    public static int combinationWithInfi_subSeq(int[] arr, int tar, int idx, String ans) {

    }

    public static int combinationWithSingle_subSeq(int[] arr, int tar, int idx, String ans) {

    }
    public static void main(String[] args){
        int[] arr = {2, 3, 5, 7};
        int tar = 10;
        System.out.println("Permutation with infinite coins :");
        System.out.println(permutationwithInf(arr, tar, ""));
        System.out.println("Combination with infinite coins :");
        System.out.println(combinationswithInf(arr, tar, 0, ""));
        System.out.println("Combination with Single coin :");
        System.out.println(combinationswithSingleCoin(arr, tar, 0, ""));
    }
}