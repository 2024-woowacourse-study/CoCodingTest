# 점프 (실1)

import sys
input = sys.stdin.readline

N = int(input())
arr = [list(map(int, input().split())) for _ in range(N)]

answer = [[0]*N for _ in range(N)]
answer[0][0] = 1

for i in range(N):
  for j in range(N):
    if i == N-1 and j == N-1:
      print(answer[i][j])
      continue
    if i+arr[i][j] < N:
      answer[i+arr[i][j]][j] += answer[i][j]
    if j+arr[i][j] < N:
      answer[i][j+arr[i][j]] += answer[i][j]
