#include<iostream>
using namespace std;
void pattern1(int row){
        int nst = 1 ;
        for(int r = 1 ; r <= row; r++){
            for(int cst = 1; cst <= nst;cst++ ){
                cout<<"*\t";
            }
            nst ++;
            cout<<endl;
        }
    }
void pattern2(int row){
        int nst = row ;
        for(int r = 1 ; r <= row; r++){
            for(int cst = nst; cst >= r;cst--){
                cout<<"*\t";
            }
            cout<<endl;
        }
    }
void pattern3(int row){
        int nst = 1 ;
        int nsp = row - 1;
        for(int r = 1 ; r <= row; r++){
            for(int csp = 1; csp<=nsp;csp++){
                cout<<"\t";
            }
            for(int cst = 1; cst <= r;cst++ ){
                cout<<"*\t";
            }
            nst ++;
            nsp --;
            cout<<endl;
        }
    }
void pattern4(int row){
        int nst = row ;
        int nsp = 0;
        for(int r = 1 ; r <= row; r++){
            for(int csp = 1; csp<=nsp;csp++){
                cout<<"\t";
            }
            for(int cst = nst; cst >= r;cst-- ){
                cout<<"*\t";
            }
            
            // nst --;
            nsp ++;
            cout<<endl;
        }
    }
void pattern7(int row){
        // int nst = row ;
        int nsp = 0;
        for(int r = 1 ; r <= row; r++){
            for(int csp = 1; csp<=nsp;csp++){
                cout<<"\t";
            }
                cout<<"*\t";
            // nst --;
            nsp ++;
            cout<<endl;
        }
    }
void pattern8(int row){
        // int nst = row ;
        int nsp = row-1;
        for(int r = 1 ; r <= row; r++){
            for(int csp = nsp; csp>=r;csp--){
                cout<<"\t";
            }
            
                cout<<"*\t";
            
            
           
            cout<<endl;
        }
    }
void pattern9(int row){
        for(int i = 1 ; i <= row; i++){
            for(int j = 1; j<=row;j++){
                if(i == j || i + j == row + 1  ) cout<<"*\t";
                else cout<<"\t";
            }            
            cout<<endl;
        }
    }
void pattern9_01(int row){
        int p = row + 1 ;
        for(int i = 1 ; i <= row; i++){
            for(int j = 1; j<=row;j++){
                if((i + j) == p -2 || (i + j) == p || (i + j) == p +2 ) cout<<"*\t";
                else cout<<"\t";
            }            
            cout<<endl;
        }
    }
void pattern5(int row){
        int nst = 1; // no of star.
        int nsp = row / 2;
        for(int r = 1;r <= row; r++){
            for(int csp = 1;csp <= nsp;csp++){
                cout<<"\t";
            }
    
            for(int cst = 1;cst <= nst;cst++){
                cout<<"*\t";
            }
    
            if(r <= row / 2){
                nsp--;
                nst+=2;
            }else{
                nsp++;
                nst-=2;
            }
    
            cout<<endl;
        }
    }
    void pattern6(int row){
        int nsp = 1; 
        int nst = (row + 1) / 2;
        for(int r = 1;r <= row; r++){
            for(int cst = 1;cst <= nst;cst++){
                cout<<"*\t";
            }
    
            for(int csp = 1;csp <= nsp;csp++){
                cout<<"\t";
            }
            for(int cst = 1;cst <= nst;cst++){
                cout<<"*\t";
            }
    
            if(r <= row / 2){
                nst--;
                nsp+=2;
            }else{
                nst++;
                nsp-=2;
            }
    
            cout<<endl;
        }
    }                 

int main(){
    int r;
    cin >> r;
    // pattern1(r);
    // cout<<endl;
    // pattern2(r);
    // cout<<endl;
    // pattern3(r);
    // cout<<endl;
    // pattern4(r);
    // cout<<endl;
    // pattern7(r);
    // cout<<endl;
    // pattern8(r);
    // cout<<endl;
    // pattern9(r);
    // cout<<endl;
    // pattern9_01(r);
    pattern6(r);

}