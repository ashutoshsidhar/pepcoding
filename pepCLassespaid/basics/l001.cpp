#include<iostream>
using namespace std;
int add(int a, int b){
    int c = a + b;
    return c;
}
int Substract(int a, int b){
    int c = a - b;
    return c;
}
int multi(int a, int b){
    int c = a * b;
    return c;
}
int divide(int a, int b){
    int c = a / b;
    return c;
}
void printz(){
    cout<<"*****"<<endl;
    cout<<"   *"<<endl;
    cout<<"  *"<<endl;
    cout<<" *"<<endl;
    cout<<"*****"<<endl;
}
void printntimes(int n){
    for(int i = 1; i <= n; i++){
        cout<<"Hello ";
    }
}
void printTableofN(int n){
    for (int i = 1 ; i <= 10 ; i++){
        cout << to_string(n) + " X " + to_string(i) + " = " + to_string(n*i) << endl;
    }
}
void printntimestable(int n){
    for(int i = 1 ; i<= n ; i++){
        printTableofN(i);
        cout<<endl;
    }
}
void oddeven(int a){
        if (a % 2 == 0){
            cout<< to_string(a) + " is even"<<endl;
        }
        else {
            cout<< to_string(a) + " is Odd"<<endl;
        }
    }
void ntimesoddeven(){
        int n ;
        cin >> n ;
        for(int i = 1 ; i <= n ; i++){
            int a ;
            cin >> a;
            oddeven(a);
        }
    }
bool isprime(int n){
        for(int i = 2 ; i*i <= n ; i++){
            if(n % i == 0) return false;
        }
        return true;
    }
void primes(){
        int n ;
        cin >> n ;
        for(int i = 1 ; i <= n ; i++){
            int t;
            cin>> t;
            if(isprime(t)){
                cout<<"is prime"<<endl;
            }
            else{
                cout<<"not prime"<<endl;
            }
        }
    }
void primetilln(int n , int t){
        for(int i = n ; i<= t; i++){
            if(isprime(i)){
                cout<<i<<endl;
            }
        }
    }
// void fibonaci(int n){
//     int a = 0;
//     int b = 1;
//     cout << a << endl;
//     cout << b << endl;
//     for(int i = a ; i<=n ; i++){
        
//         int c = a + b ;
//         cout << c << endl;
//         a = b ;
//         b = c ; 
//     }

// }
void printfibonacci(int n) {
        int a = 0;
        int b = 1;
        int sum;
        for (int i = 1; i <= n; i++) {
            cout<<a<<endl;
            sum = a + b;
            a = b;
            b = sum;

        }
    }
int countdigits(int n){
    int count = 0 ;
    while(n != 0){
        n /= 10 ;
        count ++;
    }
    return count;
}    
int revnum(int n){
    int ans = 0;
    while(n != 0){
        int last = n % 10 ;
        n /= 10;
        ans = ans*10 + last;
    }
    return ans;
}
int powerin10(int n){
    int power = 1 ;
    n /= 10;
    while(n != 0){
        n /= 10 ;
        power *= 10;
    }
    return power;
}
void digitsofnum(int n){
    int power = powerin10(n);
    while(power != 0){
        int num = n / power;
        int ld = num % 10;
        cout<< ld << endl;
        power /= 10 ;
    }
}
int gcd(int a, int b){
    int divident = a ;
    int divisor = b;
    while(divident % divisor != 0){
        int rem = divident % divisor;
        divident = divisor ;
        divisor = rem;
    }
    return divisor;
} 
int lcm(int a, int b,int g){
    return a*(b/g);
}
int rotate(int n, int r){
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
void pythatrip(int a, int b, int c){
    bool ans = (a*a + b*b == c*c || a*a + c*c == b*b || c*c + b*b == a*a);
    cout<<(boolalpha)<<ans;
}
// bool pythatrip(int a, int b, int c){
//     bool ans = (a*a + b*b == c*c || a*a + c*c == b*b || c*c + b*b == a*a);
//     return ans;
// }
void benjaminbulbs(int n){
    for(int i = 1 ; i*i <= n ; i++){
       cout<<i*i<<endl;
    }
}   
int main(){
    int a , b;
    cin >> a ; 
    cin >> b;
    // cout<<"Hello"<<endl;
    // cout<<"Pepcoders"<<endl;
    // cout<<add(a,b)<<endl;
    // cout<<Substract(a,b)<<endl;
    // cout<<multi(a,b)<<endl;
    // cout<<divide(a,b)<<endl;
    // printz();
    // printTableofN(a);
    // printntimestable(a);
    // oddeven(a);
    // ntimesoddeven();
    // primes();
    // primetilln(a);
    // fibonaci(a);
    // cout<<revnum(a)<<endl;
    int g = gcd(a,b);
    int l = lcm(a,b,g);
    cout<< g <<endl;
    cout << l <<endl;
    return 0;
}