# 꿈틀꿈틀 호석 애벌레 - 기능성 (실1)

import sys
input = sys.stdin.readline

N, K = map(int, input().split())
arr = list(map(int, input().split()))

def dfs(total, result, depth):
  if depth == N:
    answer.append(result)
    return
  if total+arr[depth] >= K:
    r = total+arr[depth]-K
    dfs(0, result+r, depth+1) #에너지 계산하고 0으로 초기화
  else:
    if total == 0:
      dfs(0, result, depth+1) #이전 값이 0일땐 안 먹는 경우로 존재
    dfs(total+arr[depth], result, depth+1)

answer = []
dfs(0, 0, 0)
print(max(answer))
