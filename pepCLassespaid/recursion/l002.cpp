#include <iostream>
#include <vector>

using namespace std;

void printSS(string str, int idx, string ans)
{
    if (idx == str.length())
    {
        cout << ans << endl;
        return;
    }

    printSS(str, idx + 1, ans + str[idx]);
    printSS(str, idx + 1, ans);
}

vector<string> subseq_03(string str, int idx)
{
    if (idx == str.length())
    {
        vector<string> base;
        base.push_back("");
        return base;
    }

    vector<string> recAns = subseq_03(str, idx + 1);

    vector<string> myAns(recAns); // nahi anne ki choise dekhli.

    char ch = str[idx];
    for (string s : recAns)
    {
        myAns.push_back(ch + s);
    }

    return myAns;
}
vector <string> getmazepaths(int sr, int sc, ont dr, int dc){
    if(sr == dr && sc == dc){
        vector<string> base;
        base.push_back("");
        return base;
    }
    vector<string> Myans;
    if(sc + 1 <= dc){
        vector<string> Horizontal = getmazepaths(sr,sc + 1,dr,dc);
        for ( string s: Horizontal){
            Myans.push_back("h" + s);
        }
    }
    if(sr + 1 <= dr){
        vector<string> Vertical = getmazepaths(sr + 1,sc,dr,dc);
        for ( string s: Vertical){
            Myans.push_back("v" + s);
        }
    }
    return Myans;
}
int main()
{
    string str = "abc";
    printSS(str, 0, "");

    vector<string> ans = subseq_03(str, 0);
    for (string s : ans)
        cout << s << " ";

    return 0;
}