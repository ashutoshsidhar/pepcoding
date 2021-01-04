#include<iostream>
#include<vector>
using namespace std;
bool ispalindrome(string str ){
    int si = 0 , ei = str.length() - 1 ;
    while( si < ei ){
        if(str[si] != str[ei]) return false ;
    }
    return true ;
}
void getallsubstrings(string str){
    for(int i = 0 ; i < str.length(); i++ ){
        for(int len = 1 ; i + len <= str.length(); len++ ){
            cout<<str.substr( i , len ) << endl ;
        }
    }
}
void getallpalindromicsubstrings(string str){
        for(int i = 0 ; i < str.length(); i++ ){
            for(int len = 1 ; i + len <= str.length(); len++ ){
                string s = str.substr( i , len );
                if(ispalindrome(s)) cout<<s << endl ;
            }
        }
    }