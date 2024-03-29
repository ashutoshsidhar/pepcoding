#include<iostream>
#include<vector>
using namespace std;

void swap(vector<int>& arr, int i, int j) {
        cout<<"Swapping index " <<i  <<" and index " << j<<endl;
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
void sort01(vector<int>& arr){
    int n = arr.size();
    int pt = 0, itr = 0;
    while(itr<n){
        if(arr[itr] == 0){
            swap(arr, itr++, pt++);

        }
        else
            itr++;
    }
}

void input(vector<int>& arr){
    for(int i = 0; i<arr.size(); i++){
        cin>>arr[i];
    }
}

void print(vector<int>& arr){
    for(int i = 0; i<arr.size(); i++){
        cout<<arr[i]<<endl;
    }
}

int main(){
    int n, m;
    cin >> n;
    vector<int> A(n,0);
    input(A);

    sort01(A);
    print(A);
}