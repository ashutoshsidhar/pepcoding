public class l001{
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void moveToLast(int[] arr, int si, int ei) {
        for (int i = si + 1; i <= ei; i++) {
            if (arr[i - 1] > arr[i])
                swap(arr, i - 1, i);
        }
    }

    public static void bubble(int arr[], int n) {
        int ei = n - 1;
        for (int i = 0; i < n; i++) {
            moveToLast(arr, 0, ei - i);
        }

    }

//     public static void moveToStart(int[] arr, int si, int ei) {
//         for (int i = si + 1; i <= ei; i++) {
//             if (arr[si] > arr[i])
//                 swap(arr, si, i);
//         }
//     }

//     public static void selectionSort(int arr[]) {
//         int n = arr.length;
//         int ei = n - 1;
//         for (int i = 0; i < n - 1; i++) {
//             moveToStart(arr, i, ei);
//         }
//     }
// }
    public static void selectionsort(int arr[]) {
        int n = arr.length;

     
        for (int i = 0; i < n - 1; i++) {
        
            int minIdx = i;
            for (int j = i + 1; j < n; j++){

                System.out.println("Comparing " + arr[j] + " and " + arr[minIdx]);
                if (arr[j] < arr[minIdx])
                    minIdx = j;
            }
            System.out.println("Swapping " + arr[i] + " and " + arr[minIdx]);
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }
    }
    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        sort(arr);
        print(arr);
    }
}