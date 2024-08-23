#include <iostream>
#include <algorithm>

using namespace std;

int n, m;

bool isValid(int amount[], int n, int m, int midAmount) {
    int count = 1; // 첫 번째 인출
    int currentAmount = midAmount;

    for (int i = 0; i < n; i++) {
        if (currentAmount >= amount[i]) {
            currentAmount -= amount[i];
        } else {
            count++;
            currentAmount = midAmount - amount[i];
            if (currentAmount < 0) return false; // 인출 금액이 하루 지출보다 작다면 불가능
        }
    }
    return count <= m;
}

int main() {
    cin >> n >> m;
    int amount[n];
    int maxAmount = 0;
    int sumAmount = 0;

    for (int i = 0; i < n; i++) {
        cin >> amount[i];
        maxAmount = max(amount[i], maxAmount);
        sumAmount += amount[i];
    }

    int minAmount = maxAmount;
    int answer = sumAmount;

    while (minAmount <= sumAmount) {
        int mid = (minAmount + sumAmount) / 2;

        if (isValid(amount, n, m, mid)) {
            answer = mid;
            sumAmount = mid - 1;
        } else {
            minAmount = mid + 1;
        }
    }

    cout << answer << endl;
    return 0;
}
