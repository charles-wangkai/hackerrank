#include <bits/stdc++.h>
using namespace std;
using my_pair = pair<string, int>;

vector<my_pair> translation(unordered_map<string, my_pair> words) {
    vector<my_pair> khalani;
    int m;
    cin >> m;
    string s;
    while(m--) {
        cin >> s;
        if(words.find(s) != words.end()){
            khalani.push_back(words[s]);
        }
    }
    
    sort(khalani.begin(), khalani.end(), [](my_pair e1, my_pair e2){return e1.second > e2.second;});

    return khalani;
}

int main() {
    int n, weights;
    cin >> n;
    
    string s1, s2;
    unordered_map<string, my_pair> words;
    while(n--){
        cin >> s1 >> s2 >> weights;
        words[s1] = make_pair(s2, weights);
    }
    
    vector<my_pair> answer = translation(words);

    for(auto x : answer){
        cout << x.first << " ";
    }
    cout << endl;
    
    return 0;
}
