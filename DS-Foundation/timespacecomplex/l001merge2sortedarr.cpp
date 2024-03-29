#include<iostream>
#include<vector>
using namespace std;
vector<int> merge2sorted(vector<int> A,vector<int> B){
    if(A.size() == 0 || B.size() == 0){
        return A.size() != 0 ? A : B ;
    }
    int n = A.size();
    int m = B.size();
    vector<int> ans(n+m,0);
    int i = 0 , j = 0 , k = 0 ;
    while(i < n && j < m){
        if(A[i] < B[j]){
          ans[k++] = A[i++];  
        }
        else{
            ans[k++] = B[j++];
        }
    }
    while(i < n){
      ans[k++] = A[i++];  
    }
    while(j < m){
      ans[k++] = B[j++];  
    }
    return ans;
}
void input(vector<int> &arr){
    for(int i = 0 ; i < arr.size(); i++){
        cin >> arr[i];
    }
}
void output(vector<int> &arr){
    for(int i = 0 ; i < arr.size(); i++){
        cout << arr[i] << endl;
    }
}
int main(){
    int n; 
    cin >> n;    
    vector<int> A(n,0);
    input(A);
    int m; 
    cin >> m;    
    vector<int> B(m,0);
    input(B);
    vector<int> ans = merge2sorted(A,B);
    output(ans);
}