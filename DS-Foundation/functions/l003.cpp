#include<iostream>
using namespace std;
long decimaltoanybase(long n, long b){
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
long anybasetodecimal(long n, long b){
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
long anybasetoanybase(long n, long a, long b){
        long ans1 = anybasetodecimal(n,a);
        long ans2 = decimaltoanybase(ans1,b);
        return ans2;
    }
int main(){
    long  n ; 
    long  a ;
    long  b ;
    cin >> n ; 
    cin >> a >> b ;
    cout<<anybasetoanybase(n,a,b);
}