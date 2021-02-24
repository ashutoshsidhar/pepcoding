#include<iostream>
#include<vector>
using namespace std;
void print(vector<int> &arr){
    for(int i = 0 ; i < arr.size(); i++){
        cout << arr[i] << " ";
    }
    cout << endl ;
}
vector<int> merge2sorted(vector<int> A,vector<int> B){
    if(A.size() == 0 || B.size() == 0){
        return A.size() != 0 ? A : B ;
    }
    int n = A.size();
    int m = B.size();
    cout <<"Merging these two arrays "<<endl;
    cout<<"left array -> ";
    print(A);
    cout<<"right array -> ";
    print(B);
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
vector<int> mergesort(vector<int> &arr, int si , int ei){
    if(si == ei){
        vector<int> base;
        base.push_back(arr[si]);
        return base;
    }
    int mid = (si + ei) / 2 ;
    vector<int> A = mergesort(arr, si , mid);
    vector<int> B = mergesort(arr, mid+1 , ei);
    return merge2sorted(A , B);
}
vector<int> mergesort(vector<int> &arr){
    return mergesort(arr , 0 , arr.size() - 1);
}
void input(vector<int> &arr){
    for(int i = 0 ; i < arr.size(); i++){
        cin >> arr[i];
    }
}

int main(){
    int n; 
    cin >> n;    
    vector<int> A(n,0);
    input(A);
    // int m; 
    // cin >> m;    
    // vector<int> B(m,0);
    // input(B);
    vector<int> ans = mergesort(A);
    cout << "Sorted Array -> ";
    print(ans);
}