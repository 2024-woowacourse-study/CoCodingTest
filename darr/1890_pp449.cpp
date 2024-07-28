#include <iostream>

using namespace std;

int main() {
    int n;
    cin>>n;
    int gameBoard[n][n];
    long long movingBoard[n][n];
    fill(&movingBoard[0][0], &movingBoard[n-1][n], 0);
    movingBoard[0][0] = 1;

    for(int i=0; i<n; i++) {
        for(int j=0; j<n; j++) {
            int val;
            cin>>val;
            gameBoard[i][j] = val;
        }
    }

    for(int i=0; i<n; i++) {
        for(int j=0; j<n; j++) {
            if(movingBoard[i][j] == 0) continue;
            int moveCount = gameBoard[i][j];
            if(moveCount == 0) continue;
            if(moveCount + i < n) {
                movingBoard[moveCount + i][j] += movingBoard[i][j];
            }

            if(moveCount + j < n) {
                movingBoard[i][moveCount + j] += movingBoard[i][j];
            }
        }
    }

    cout<<movingBoard[n-1][n-1]<<endl;
    return 0;
}