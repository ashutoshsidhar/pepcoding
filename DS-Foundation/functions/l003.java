import java.util.Scanner;
public class l003{
    public static Scanner scn = new Scanner(System.in);
    public static long decimaltoanybase(long n, long b){
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
    public static long binaryadd(long n, long a){
        long carry = 0 ;
        long res = 0;
        long power = 1 ;
        while(n !=0 || a != 0 || carry != 0){
            long sum = 0 ; 
            sum += carry + n % 10 + a % 10 ;
            n /= 10 ;
            a /= 10 ;
            long ld = sum % 2;
            carry = sum / 2;
            res += ld * power ;
            power *= 10 
        }
        
        return res ;
    }
    public static long anyadd(long n, long a, long b){
        long carry = 0 ;
        long res = 0;
        long power = 1 ;
        while(a !=0 || b != 0 || carry != 0){
            long sum = 0 ; 
            sum += carry + a % 10 + b % 10 ;
            b /= 10 ;
            a /= 10 ;
            long ld = sum % n;
            carry = sum / n;
            res += ld * power ;
            power *= 10 ;
        }
        return res;
    }    
    public static void main(String[] args){
        long n = scn.nextLong();
        long a = scn.nextLong();
        long b = scn.nextLong();
        // System.out.println(decimaltoanybase(n,b));
        // System.out.println(binaryadd(n,a));
        System.out.println(anyadd(n,a,b));
    }
}