#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>

using namespace std;

int dfs_check[1001];
int bfs_check[1001];

void dfs(vector<int> graph[1001], int start) {
    if(dfs_check[start] == 1) return;
    dfs_check[start] = 1;
    cout<<start<<" ";
    for(int i=0; i<graph[start].size(); i++) {
        dfs(graph, graph[start][i]);
    }
}

void bfs(vector<int> graph[1001], int start) {
    queue<int> q;

    for(int i=0; i<graph[start].size(); i++) {
        q.push(graph[start][i]);
    }

    cout<<start<<" ";
    bfs_check[start] = 1;

    while(q.empty() == false) {
        int val = q.front();
        q.pop();
        if(bfs_check[val] == 1) continue;
        bfs_check[val] = 1;
        cout<<val<<" ";
        for(int i=0; i<graph[val].size(); i++) {
            q.push(graph[val][i]);
        }
    }
}

int main() {
    int n,m,v;
    cin>>n>>m>>v;
    vector<int> graph[1001];

    for(int i=0; i<m; i++) {
        int n1, n2;
        cin>>n1>>n2;
        graph[n1].push_back(n2);
        graph[n2].push_back(n1);
        sort(graph[n1].begin(), graph[n1].end());
        sort(graph[n2].begin(), graph[n2].end());
    }

    dfs(graph, v);
    cout<<endl;
    bfs(graph, v);

    return 0;
}