import java.util.ArrayList;

public class l006{
    public static boolean ispalindrome(String str ){
        int si = 0 , ei = str.length() - 1 ;
        while( si < ei ){
            if(str.charAt(si++) != str.charAt(ei--)) return false ;
        }
        return true ;
    }
    public static void getallsubstrings(String str){
        for(int i = 0 ; i < str.length(); i++ ){
            for(int len = 1 ; i + len <= str.length(); len++ ){
                System.out.println(str.substring( i , i + len ));
            }
        }
    }
    public static void getallpalindromicsubstrings(String str){
        for(int i = 0 ; i < str.length(); i++ ){
            for(int len = 1 ; i + len <= str.length(); len++ ){
                String s = str.substring( i , i + len );
                if(ispalindrome(s)) System.out.println(s);
            }
        }
    }
    public static String stringcomp(String str){
        if(str.length() <= 1) return str;
        StringBuilder sb = new StringBuilder();
        sb.append(str.charAt(0));
        for(int i = 1 ; i <= str.length() ; i++ ){
            int count = 1 ;
            while( i < str.length() && str.charAt(i - 1) == str.charAt(i) ){
                count ++ ;
                i ++ ;
            }
            if(count != 1) sb.append(count);
            if(i < str.length()) sb.append(str.charAt(i));
        }
        return sb.toString();
    }
    public static String stringcomp1(String str){
        int count = 1 ;
        if(str.length() <= 1) return str;
        StringBuilder sb = new StringBuilder();
        sb.append(str.charAt(0));
        for(int i = 1 ; i <= str.length() ; i++ ){
            while( i < str.length() && str.charAt(i - 1) == str.charAt(i) ){
                count ++ ;
                i ++ ;
            }
            // if(count ! = 1) sb.append(count);
            if(i < str.length()) sb.append(str.charAt(i));
        }
        return sb.toString();
    }
    public static String toggle(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= 'a' && ch <= 'z')
                sb.append((char) (ch - 'a' + 'A'));
            else
                sb.append((char) (ch - 'A' + 'a'));
        }

        return sb.toString();
    }
    public static String stringdiff(String str){
        if(str.length() <= 1) return str;
        StringBuilder sb = new StringBuilder();
        sb.append(str.charAt(0));
        for(int i = 1 ; i < str.length() ; i++ ){
            char ch1 = str.charAt(i - 1);
            char ch2 = str.charAt(i);
            sb.append(ch2 - ch1);
            sb.append(ch2);
        }
        return sb.toString();
    }
    public static ArrayList<String> subseqe(String str){
        ArrayList<String> ans = new ArrayList<>();
        ans.add("");
        for(int i = 0 ; i < str.length() ; i++){
            char ch = str.charAt(i);
            int size = ans.size();
            for(int j = 0 ; j < size ; j++ ){
                ans.add(ans.get(j) + ch);
            }
        }
        return ans;
    }
    public static void permutations(String str) {
        ArrayList<String> ans = new ArrayList<>();
        ans.add("");
         for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            ArrayList<String> myAns = new ArrayList<>();
            
            for(String s : ans){
                for(int j=0;j<=s.length();j++){
                    myAns.add(s.substring(0,j) + ch + s.substring(j));
                }
            }
            
            ans = myAns;
         }
         
         System.out.println(ans);
    }
    public static boolean isprime(int n){
        for(int i = 2 ; i*i <= n ; i++){
            if(n % i == 0) return false;
        }
        return true;
    }
    public static void remprimes(ArrayList<Integer> al){
        ArrayList<Integer> ans = new ArrayList<>();
        for(int ele : al){
            if(!isprime(ele)) ans.add(ele);
        }
        al.clear();
        for(int ele : ans){
            al.add(ele);
        }       
    }

    public static ArrayList<Integer> allPrimes(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 2; i * i <= n; i++) {
            if (isprime(i))
                list.add(i);
        }
        return list;
    }

    public static void powerForm(int num, ArrayList<Integer> list) {
        System.out.print(num + " -> ");
        int idx = 0;
        while (idx < list.size() && num > 1) {
            int count = 0;
            while (num % list.get(idx) == 0 && num > 1) {
                num /= list.get(idx);
                count++;
            }

            if (count > 0)
                System.out.print(list.get(idx) + "^" + count + " ");
            idx++;
        }

        if (num > 1)
            System.out.print(num + "^" + 1 + " ");
        System.out.println();
    }

    public static void exponForm(int[] query) {
        ArrayList<Integer> list = allPrimes(1000000);
        // System.out.println(list);
        for (int ele : query) {
            powerForm(ele, list);
        }
    }

    public static void main(String[] args) {
        int[] arr = { 11, 97, 197, 339, 55, 498, 44, 39, 454545, 23, 2312, 676, 256, 555, 222222 };
        exponForm(arr);

    }
}