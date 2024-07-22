#include <iostream>

using namespace std;

int main() {
    int n;
    int answer = 0;
    cin >> n;

    while(n % 5 != 0) {
        if(n < 3) {
            cout << -1 << endl;
            return 0;
        }
        answer += 1;
        n -= 3;
    }
    answer += n / 5;

    cout<<answer<<endl;

    return 0;
}