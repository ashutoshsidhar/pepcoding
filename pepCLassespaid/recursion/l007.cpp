#include <iostream>
#include <vector>

using namespace std;
void printDecreasing(int n)
{
    if (n == 0)
        return;

    cout << n << endl;
    printDecreasing(n - 1);
}

void printIncreasing(int n)
{
    if (n == 0)
        return;

    printIncreasing(n - 1);
    cout << n << endl;
}

void printIncDec(int n)
{
    if (n == 0)
        return;
    cout << n << endl;
    printIncDec(n - 1);
    cout << n << endl;
}

void printIncDec(int n)
{
    if (n == 0)
        return;
    if (n % 2 != 0)
        cout << n << endl;
    printIncDec(n - 1);
    if (n % 2 == 0)
        cout << n << endl;
}

int factorial(int n)
{
    return n == 0 ? 1 : n * factorial(n - 1);
}

int factoriallong(int n){
    int recAns = 1;
    if(n > 0) recAns = n * factorial(n-1);
    
    return recAns ;
}
int power(int a, int b)
{
    return b == 0 ? 1 : a * power(a, b - 1);
}

int powerBtr(int a, int b)
{
    if (b == 0)
        return 1;
    int smallAns = powerBtr(a, b / 2);
    smallAns *= smallAns;
    return b % 2 == 0 ? smallAns : smallAns * a;
}

int powerBtr2(int a, int b)
{
    if (b == 0)
        return 1;
    int smallAns = powerBtr2(a, b / 2) * powerBtr2(a, b / 2);
    return b % 2 == 0 ? smallAns : smallAns * a;
}

int fibo(int n)
{
    if (n <= 1)
        return n;

    return fibo(n - 1) + fibo(n - 2);
}

int tribonacci(int n)
{
    if (n <= 2)
        return n == 2 ? 1 : n;

    return tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3);
}

// Recursion With Array

void display(int arr[], int idx, int n)
{
    if (idx == n)
    {
        return;
    }

    cout << arr[idx] << endl;
    display(arr, idx + 1, n);
}

void reverseDisplay(int arr[], int idx, int n)
{
    if (idx == n)
    {
        return;
    }

    reverseDisplay(arr, idx + 1, n);
    cout << arr[idx] << endl;
}

int maxOfArray(int arr[], int idx,int n) {
    if (idx == n) return -1e9;

    return max(arr[idx], maxOfArray(arr, idx + 1,n));
}
int firstIndex(int arr[], int idx, int x, int n)
{
    if (idx == n)
        return -1;

    if (arr[idx] == x)
        return idx;
    return firstIndex(arr, idx + 1, x, n);
}
int LastIndex(int arr[], int idx, int x, int n)
{
    if (idx == n)
        return -1;
    int LI = LastIndex(arr, idx + 1, x, n);
    if ( LI == -1){
        if (arr[idx] == x){
            return idx;
        }
        else return -1 ;
    }
    else return LI ;
}
int main()
{
    int n,d;
    cin >> n;
    int arr[n];
    for (int i = 0; i < n; i++)
        cin >> arr[i];
    display(arr, 0, n);
    cin >> d;
    int p = firstIndex(arr, 0, d, n);
    cout << p << endl;
}