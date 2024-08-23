#include <iostream>
#include <math.h>
#include <vector>

using namespace std;

int n, k;
int answer = 0;
int energy[21];

void dfs(int process, vector<int> vec) {
    if(process == n) {
        int total = 0;
        int sum = 0;

        for(int i=0; i<vec.size(); i++) {
            if(vec[i] == -1) {
                total += max(0, sum - k);
                sum = 0;
            } else {
                sum += vec[i];
                if(sum >= k) {
                    total += sum - k;
                    sum = 0;
                }
            }
        }
        total += max(0, sum - k);
        answer = max(answer, total);

        return;
    }
    vector<int> vec2(vec);
    vec.push_back(-1);
    vec2.push_back(energy[process]);
    dfs(process + 1, vec);
    dfs(process + 1, vec2);
}

int main() {
    cin>>n>>k;

    for(int i=0; i<n; i++) {
        cin>>energy[i];
    }

    vector<int> vec;
    dfs(0, vec);

    cout<<answer<<endl;
}