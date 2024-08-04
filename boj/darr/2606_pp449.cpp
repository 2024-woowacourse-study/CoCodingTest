#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int main() {
    int computerNum, computerPair;
    int answer = -1;
    cin >> computerNum >> computerPair;
    vector<int> graph[computerNum + 1];
    int check[computerNum + 1];
    fill_n(check, computerNum + 1, 0);
    queue<int> q;

    for(int i=0; i<computerPair; i++) {
        int n1, n2;
        cin>>n1>>n2;
        graph[n1].push_back(n2);
        graph[n2].push_back(n1);
    }

    q.push(1);

    while(q.empty() == false) {
        int num = q.front();
        q.pop();
        if(check[num] == 1) continue;
        check[num] = 1;
        answer += 1;
        for(int i=0; i<graph[num].size(); i++) {
            q.push(graph[num][i]);
        }
    }

    cout<<answer<<endl;
    return 0;
}