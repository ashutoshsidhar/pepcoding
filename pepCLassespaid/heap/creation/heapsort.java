public class heapsort{
    public static void swap(int[] arr, int i,int j){
        int temp = arr[i];
        arr[i] = arr[j] ;
        arr[j] = temp; 
    }
    public static boolean compareto(int a , int b , boolean isMax){
        if(isMax)
          return a > b ;
        else
            return  a < b ;  
    }
    public static void heapify(int pi ,int[] arr, int li ,boolean isMax){
        int maxIdx = pi;
        int lci = 2 * pi + 1 ;
        int rci = 2 * pi + 2 ;
        if(lci <= li && compareto(arr[lci], arr[maxIdx], isMax))
            maxIdx = lci;
        if(rci <= li && compareto(arr[lci], arr[maxIdx], isMax))
            maxIdx = rci;
        if(pi !=maxIdx){
            swap(arr, maxIdx, pi);
            heapify(maxIdx, arr, li, isMax);
        }    
    }
    public static void display(int[] arr){
        for(int ele : arr)
            System.out.print(ele + " ");
        System.out.println();
    }
    public static void main(String[] args){
        int[] arr = { 10, 20, 30, -2, -3, -4, 5, 6, 7, 8, 9, 22, 11, 13 };
        int N = arr.length;
        boolean ismax = true;
        for(int i = N - 1 ; i >= 0 ; i--)
            heapify(i, arr, N - 1 , ismax);
        int li = N - 1 ;
        while(li >= 0){
            swap(arr,0,li--);
            heapify(0, arr, li, ismax);
        }
        display(arr);
    }
}