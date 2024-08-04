#include <iostream>
#include <vector>
#include <set>
#include <algorithm>

using namespace std;

int main() {
    int n,m;
    cin>>n>>m;
    set<int> s;
    vector<int> friends[n+1];
    int checked[n+1];
    fill_n(checked, n+1, 0);

    for(int i=0; i<m; i++) {
        int friend1, friend2;
        cin>>friend1>>friend2;

        friends[friend1].push_back(friend2);
        friends[friend2].push_back(friend1);
    }

    checked[1] = 1;
    for(int i=0; i<friends[1].size(); i++) {
        int sangunFriend = friends[1][i];
        s.insert(sangunFriend);

        for(int j=0; j<friends[sangunFriend].size(); j++) {
            int sangunFriendFriend = friends[sangunFriend][j];

            if(checked[sangunFriendFriend] == 1) continue;
            checked[sangunFriendFriend] = 1;

            s.insert(sangunFriendFriend);
        }
    }

    cout<<s.size()<<endl;
    return 0;
}