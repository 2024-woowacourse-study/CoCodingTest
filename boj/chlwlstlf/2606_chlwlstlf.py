# 바이러스 (실3)

import sys
input = sys.stdin.readline

# 입력 & 그래프 생성
N = int(input())
M = int(input())
graph = [[] for _ in range(N+1)]
for i in range(M):
  a, b = map(int, input().split())
  graph[a].append(b)
  graph[b].append(a)

# dfs
def dfs(v):
  global cnt
  cnt += 1
  visited[v] = 1
  for i in graph[v]:
    if visited[i] == 0:
      visited[i] = 1
      dfs(i)

# dfs 호출
visited = [0]*(N+1)
cnt = 0
dfs(1)
print(cnt-1)