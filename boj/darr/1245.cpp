#include <iostream>
#include <queue>
#include <math.h>
#include<utility>

using namespace std;

int n,m;
int dx[8] = {0, 0, -1, 1, -1, 1, -1, 1};
int dy[8] = {-1, 1, 0, 0, -1, 1, 1, -1};
int mountain[101][71];
bool check[101][71];

bool checkIsMountainBud(int x, int y) {
    bool flag = true;

    for(int i=0; i<8; i++) {
        int positionX = x + dx[i];
        int positionY = y + dy[i];
        if(min(positionX, positionY) < 0 || positionX >= n || positionY >= m) continue;
        if(mountain[positionX][positionY] > mountain[x][y]) flag = false;
        if(check[positionX][positionY]) continue;
        if(mountain[positionX][positionY] == mountain[x][y]) {
            check[positionX][positionY] = true;
            flag = checkIsMountainBud(positionX, positionY) ? flag : false;
        }
    }

    return flag;
}

int main() {
    cin>>n>>m;
    
    int answer = 0;

    for(int i=0; i<n; i++) {
        for(int j=0; j<m; j++) {
            cin>>mountain[i][j];
        }
    }

    for(int i=0; i<n; i++) {
        for(int j=0; j<m; j++) {
            if(mountain[i][j] == 0) continue;
            if(check[i][j] == true) continue;
            check[i][j] = true;
            if(checkIsMountainBud(i, j)) {
                answer++;
            }
        }
    }

    cout<<answer<<endl;
    return 0;
}