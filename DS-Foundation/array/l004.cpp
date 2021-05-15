#include <iostream>
#include <vector>
using namespace std;

void display(vector<int> &arr)
{
    for (int i = 0; i < arr.size(); i++)
    {
        cout << arr[i] << " ";
    }
}

void test1()
{
    int n;
    cin >> n;
    vector<int> arr(n, 0);

    for (int i = 0; i < n; i++)
        cin >> arr[i];

    display(arr);
}

int maximum(vector<int> &arr)
{
    int maxEle = -(int)1e9; // -10^9
    for (int ele : arr)
    {
        if (ele > maxEle)
            maxEle = ele;
    }
    return maxEle;
}

int maximum2(vector<int> &arr)
{
    if (arr.size() == 0)
        return -(int)1e9;
    int maxEle = arr[0]; // -10^9
    for (int ele : arr)
    {
        if (ele > maxEle)
            maxEle = ele;
    }
    return maxEle;
}

int minimum(vector<int> &arr)
{
    int minEle = (int)1e9; // 10^9
    for (int ele : arr)
    {
        if (ele < minEle)
            minEle = ele;
    }
    return minEle;
}

bool findData(vector<int> &arr, int data)
{
    for (int i = 0; i < arr.size(); i++)
    {
        if (arr[i] == data)
            return true;
    }

    return false;
}

void swap(vector<int> &arr, int i, int j)
{
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
}

// si = starting index, ei = ending index
void reverse(vector<int> &arr, int si, int ei)
{
    while (si < ei)
    {
        swap(arr, si++, ei--);
        // swap(arr[si++],arr[ei--]);
    }
}


void input(vector<int> &arr)
{
    for (int i = 0; i < arr.size(); i++)
    {
        cin >> arr[i];
    }
}
void sum2arr(vector<int>& a,vector<int>& b){
    int n = a.size();
    int m = b.size();
    int r = max(n,m) + 1 ;
    vector<int> ans(r , 0);
    int i = n - 1 , j = m - 1, k = r - 1 ;
    int carry = 0 ;
    while(k>=0){
        int sum = carry + (i >= 0 ? a[i--] : 0) + (j >= 0 ? b[j--] : 0);
        ans[k--] += sum % 10;
        carry = sum / 10;
    }
    for(int l = 0 ; l< ans.size() ; l++){
         if(l == 0 && ans[l] == 0) continue;
        cout<< ans[l] << endl;
    }

}
void diff2arr(vector<int>& a,vector<int>& b){
    int n = a.size();
    int m = b.size();
    int r = m ;
    vector<int> ans(r , 0);
    int i = n - 1 , j = m - 1, k = r - 1 ;
    int borr = 0 ;
    while(k>=0){
        int sum = borr + (j >= 0 ? b[j--] : 0) - (i >= 0 ? a[i--] : 0);
        if(sum < 0){
            sum += 10;
            borr = -1;
        }else borr = 0;
        ans[k--] = sum ;
    }
    bool flag = false;
    for(int l = 0 ; l< ans.size() ; l++){
         if(!flag && ans[l] == 0) continue;
        flag = true ; 
        cout<< ans[l] << endl;
        
    }
}
int main()
{
    // test1();
    int n; cin >> n;
    vector<int> arr(n,0);
    
    input(arr);
    reverse(arr,0,n-1);
    display(arr);

    return 0;
}