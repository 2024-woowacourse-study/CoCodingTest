# 설탕 배달 (실4)

import sys
input = sys.stdin.readline

N = int(input())

dp = [-1]*(5001)
dp[3] = 1
dp[5] = 1

for i in range(3, N+1):
  if dp[i-3] != -1:
    dp[i] = dp[i-3]+1
  if dp[i-5] != -1:
    dp[i] = dp[i-5]+1
print(dp[N])