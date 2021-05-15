import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class questions{
    public static Scanner scn = new Scanner(System.in);
    //leetcode242
    //my way
    public boolean isAnagram(String s, String t) {
        boolean status = true;
        if(s.length() != t.length()){
            return false;
        }
        else{
            char[] a1 = s.toCharArray();
            char[] a2 = t.toCharArray();
            Arrays.sort(a1);
            Arrays.sort(a2);
            status = Arrays.equals(a1, a2);
            return status;
        }   
    }
    //sir way
    public boolean isAnagram2(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        int[] freq = new int[26];
        for(int i = 0 ; i < s.length();i++){
            freq[s.charAt(i) - 'a']++;
            freq[t.charAt(i) - 'a']--;
        }
        for(int i = 0 ; i < 26 ; i++) if(freq[i] !=0) return false;

        return true;
    }


    //leetcode49
    public static String RLES(String str){ // run length encoded String
        int[] freq = new int[26];
        for(int i = 0 ; i < str.length(); i++)
            freq[str.charAt(i) - 'a']++;
        StringBuilder sb =new StringBuilder();
        for(int i = 0 ; i < 26; i++)
            if(freq[i] != 0){
                sb.append((char)(i + 'a'));
                sb.append(freq[i]);
            }
        return sb.toString();
    }
    public List<List<String>> groupAnagrams(String[] str){
        HashMap<String,ArrayList<String>> map = new HashMap<>();
        for(String s : str){
            String rles = RLES(s);
            map.putIfAbsent(rles, new ArrayList<>());
            map.get(rles).add(s);
        }
        List<List<String>> ans = new ArrayList<>();
        for(String key : map.keySet())
            ans.add(map.get(key));
        return ans;
    }
}