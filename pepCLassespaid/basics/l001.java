import java.util.Scanner;
public class l001{
    public static Scanner scn = new Scanner(System.in);
    public static int add(int a, int b){
        int c = a + b;
        return c;
    }
        public static int Substract(int a, int b){
        int c = a - b;
        return c;
    }
    public static int multi(int a, int b){
        int c = a * b;
        return c;
    }
    public static int divide(int a, int b){
        int c = a / b;
        return c;
    }
    public static void printz(){
        System.out.println("*****");
        System.out.println("   *");
        System.out.println("  *");
        System.out.println(" *");
        System.out.println("*****");
    }
    public static void printntimes(int n){
    for(int i = 1; i <= n; i++){
        System.out.println("Hello ");
        }
    }
    public static void printTableofN(int n){
    for (int i = 1 ; i <= 10 ; i++){
        System.out.println(n + " X " + i + " = " + n*i) ;
        }
    }
    public static void printntimestable(int n){
    for(int i = 1 ; i<= n ; i++){
        printTableofN(i);
        System.out.println(" ");
        }
    }
    public static void oddeven(int a){
        if (a % 2 == 0){
            System.out.println( a + " is even");
        }
        else {
            System.out.println( a + " is Odd");
        }
    }
    public static void ntimesoddeven(){
        int n = scn.nextInt();
        for(int i = 1 ; i <= n ; i++){
            int a = scn.nextInt();
            oddeven(a);
        }
    }
    public static boolean isprime(int n){
        for(int i = 2 ; i*i <= n ; i++){
            if(n % i == 0) return false;
        }
        return true;
    }
    public static void primes(){
        int n = scn.nextInt();
        for(int i = 1 ; i <= n ; i++){
            int t = scn.nextInt();
            if(isprime(t)){
                System.out.println("is prime");
            }
            else{
                System.out.println("not prime");
            }
        }
    }
    public static void primetilln(int n, int t){
        for(int i = n ; i<= t; i++){
            if(isprime(i)){
                System.out.println(i);
            }
        }
    }
    public static void printfibonacci(int n) {
        int a = 0;
        int b = 1;
        int sum;
        for (int i = 1; i <= n; i++) {
            System.out.println(a);
            sum = a + b;
            a = b;
            b = sum;

        }
    }
    public static int countdigits(int n){
    int count = 0 ;
    while(n != 0){
        n /= 10 ;
        count ++;
    }
    return count;
    }    
    public static int revnum(int n){
        int ans = 0;
        while(n != 0){
            int last = n % 10 ;
            n /= 10 ;
            ans = ans*10 + last;
        }
        return ans;
    }
    public static int powerin10(int n){
    int power = 1 ;
    n /= 10;
    while(n != 0){
        n /= 10 ;
        power *= 10;
        }
    return power;
    }
    public static void digitsofnum(int n){
    int power = powerin10(n);
    while(power != 0){
        int num = n / power;
        int ld = num % 10;
        System.out.println(ld)
        power /= 10 ;
        }
    }
    public static int gcd(int a, int b){
    int divident = a ;
    int divisor = b;
    while(divident % divisor != 0){
        int rem = divident % divisor;
        divident = divisor ;
        divisor = rem;
        }
    return divisor;
    } 
    public static int lcm(int a, int b,int g){
    return a*(b/g);
    }
    public static int rotate(int n, int r){
    int len = countdigits(n);
    r %= len;
    if(r<0) r += len;
    int mul = 1;
    int div = 1;
    for(int i = 1 ; i<= len ; i++){
        if(i <= r) div *= 10;
        else mul *=10;
    } 
    int a = n % div;
    int b = n / div;
    return a * mul + b; 
}
   
public static boolean pythatrip(int a, int b, int c){
    boolean ans = (a*a + b*b == c*c || a*a + c*c == b*b || c*c + b*b == a*a);
    return ans;
}
public static void benjaminbulbs(int n){
    for(int i = 1 ; i*i <= n ; i++){
        System.out..println(i*i);
    }
}
    public static void main(String[] args){
        int a = scn.nextInt();
        // int b = scn.nextInt();
        // System.out.println("Hello");
        // System.out.println("Pepcoders");
        // System.out.println(add(a,b));
        // System.out.println(Substract(a,b));
        // System.out.println(multi(a,b));
        // System.out.println(divide(a,b));
        // printz();
        // printTableofN(25);
        // printntimes(5);
        // printntimestable(a);
        // oddeven(a);
        // ntimesoddeven();   
        // primes();
        // primetilln(a);
        System.out.println(revnum(a));

    }
}