#include <iostream>
#include <vector>
using namespace std;
void input(vector<vector<int>>& arr){
    int n = arr.size();
    int m = arr[0].size();
    for(int i = 0 ; i < n ; i++){
        for(int j = 0 ; i < m ; j++){
            cin >> arr[i][j] ;
        }
    }
}
void display1(vector<vector<int>>& arr){
    int n = arr.size();
    int m = arr[0].size();
    for(int i = 0 ; i < n ; i++){
        for(int j = 0 ; i < m ; j++){
            cout << arr[i][j] << " ";
        }
        cout << endl ;
    }
}
void display(vector<vector<int>>& arr){
    for(vector<int> ar : arr)
        for(int e : ar)
            cout<< e << " " ;
        cout<< endl ;
    }
int maxele(vector<vector<int>>& arr){
    int maxel = -(int)1e9;
    for(vector<int> ar : arr)
        for(int e : ar)
           maxel = max(maxel,e);
    return maxel ;
    }
int minele(vector<vector<int>>& arr){
    int minel = -(int)1e9;
    for(vector<int> ar : arr)
        for(int e : ar)
           minel = min(minel,e);
    return minel ;
}
 bool find(vector<vector<int>>& arr, int data){
    for(vector<int> ar : arr)
        for(int e : ar)
           if(e == data) return true ;
    return false ;
}

int main(){
    int n;
    int m;
    cin >> n >> m ;
    vector<vector<int>> arr(n , vector<int>(m,0)) ;
    input(arr);
    display1(arr);
    // cout<<" max element is : " <<maxelement(arr) << endl;
    return 0 ;


}