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
string compression1(string str)
{
    if (str.length() <= 1)
        return str;
    string ans = "";
    ans += str[0];

    for (int i = 1; i <= str.length(); i++)
    {
        int count = 1;
        while (i < str.length() && str[i-1] == str[i])
        {
            count++;
            i++;
        }

        // if (count != 1)
        //     ans += to_string(count);
        if (i < str.length())
            ans += str[i];
    }

    return ans;
}

string compression2(string str)
{
    if (str.length() <= 1)
        return str;
    string ans = "";
    ans += str[0];

    for (int i = 1; i <= str.length(); i++)
    {
        int count = 1;
        while (i < str.length() && str[i-1] == str[i])
        {
            count++;
            i++;
        }

        if (count != 1)
            ans += to_string(count);
        if (i < str.length())
            ans += str[i];
    }

    return ans;
}
string togglestring(string str){
    string s = "";
    for(int i = 0 ; i < str.length(); i++ ){
        int ch = str[i] ;
        if(ch >= 'a' && ch <= 'z'){
            s = ch + 'A' - 'a' ;
        }
        else {
           s = ch + 'a' - 'A' ;
        } 
    }
    return s ;
}