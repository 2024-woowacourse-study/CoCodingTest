# DFS와 BFS (실2)

import sys
from collections import deque
input = sys.stdin.readline

# 입력 & 그래프 생성
N, M, V = map(int, input().split())
graph = [[] for _ in range(N+1)]
for i in range(M):
  a, b = map(int, input().split())
  graph[a].append(b)
  graph[b].append(a)

for i in range(N+1):
  graph[i].sort()


# dfs
visited1 = [0]*(N+1)
def dfs(v):
  dfsAnswer.append(v)
  visited1[v] = 1
  for i in graph[v]:
    if visited1[i] == 0:
      dfs(i)

# bfs
visited2 = [0]*(N+1)
def bfs(v):
  visited2[v] = 1
  q = deque()
  q.append(v)
  while q:
    v = q.popleft()
    bfsAnswer.append(v)
    for i in graph[v]:
      if visited2[i] == 0:
        visited2[i] = 1
        q.append(i)

# 호출
dfsAnswer = []
dfs(V)
print(*dfsAnswer)

bfsAnswer = []
bfs(V)
print(*bfsAnswer)