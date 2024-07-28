#include <iostream>
#include <vector>
#include <queue>
#include <math.h>

using namespace std;

struct User {
    int x;
    int y;
    int z;
    int life;
    int umbrella;
    int moveCount;
};

int main() {
    int n, h, d;
    int answer = 99999999;
    queue<User> q;
    int dx[4] = {-1, 1, 0, 0};
    int dy[4] = {0, 0, -1, 1};

    cin>>n>>h>>d;

    char square[11][n][n];
    int checked[11][n][n];
    fill(&checked[0][0][0], &checked[10][n-1][n], 0);

    for(int i=0; i<n; i++) {
        string s;
        cin>>s;
        for(int j=0; j<s.size(); j++) {
            if(s[j] == 'S') {
                User user = {i, j, 0, h , 0, 0};
                q.push(user);
            }
            square[0][i][j] = s[j];
        }
    }

    while(!q.empty()) {
        User user = q.front();
        q.pop();
        if(checked[user.z][user.x][user.y]) continue;
        checked[user.z][user.x][user.y] = 1;

        for(int i=0; i<4; i++) {
            int positionX = user.x + dx[i];
            int positionY = user.y + dy[i];
            int positionZ = user.z;
            int moveCount = user.moveCount + 1;
            if(positionX < 0 || positionX >= n || positionY < 0 || positionY >= n) continue;
            if(square[positionZ][positionX][positionY] == 'E') {
                answer = min(answer, moveCount);
                break;
            }
        
            int userLife = user.life;
            int userUmbrella = user.umbrella;
            if(square[positionZ][positionX][positionY] == 'U') {
                userUmbrella = userUmbrella > 0 ? d : d-1;

                checked[positionZ][positionX][positionY] = 1;
                square[positionZ][positionX][positionY] = '.';

                for(int j=0; j<n; j++) {
                    for(int k=0; k<n; k++) {
                        square[positionZ+1][j][k] = square[positionZ][j][k];
                    }
                }

                User newUser = {positionX, positionY, positionZ+1, userLife, userUmbrella, moveCount};
                q.push(newUser);
                continue;
            }
            else if(userUmbrella != 0) userUmbrella--;
            else userLife--;
            if(userLife == 0) continue;

            User newUser = {positionX, positionY, positionZ, userLife, userUmbrella, moveCount};
            q.push(newUser);
        }
    }

    int ans = answer == 99999999 ? -1 : answer;
    cout<<ans<<endl;
    return 0;
}