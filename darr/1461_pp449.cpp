#include <iostream>
#include <vector>
#include <queue>
#include <math.h>
#include <stdlib.h>

using namespace std;

int main() {
    int n,m;
    priority_queue<int> minus_pq;
    priority_queue<int> plus_pq;
    int maxMove = 0;
    int answer = 0;
    cin>>n>>m;

    for(int i=0; i<n; i++) {
        int val;
        cin>>val;
        val > 0 ? plus_pq.push(val) : minus_pq.push(-val);
    }

    while(plus_pq.empty() == false) {
        int currentMaxMove = plus_pq.top();
        for(int i=0; i<m; i++) {
            if(plus_pq.empty()) break;
            plus_pq.pop();
        }
        answer += currentMaxMove * 2;
        maxMove = max(maxMove, currentMaxMove);
    }

    while(minus_pq.empty() == false) {
        int currentMaxMove = minus_pq.top();
        for(int i=0; i<m; i++) {
            if(minus_pq.empty()) break;
            minus_pq.pop();
        }
        answer += currentMaxMove * 2;
        maxMove = max(maxMove, currentMaxMove);
    }

    cout<<answer-maxMove<<endl;
    return 0;
}