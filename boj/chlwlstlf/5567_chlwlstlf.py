# 결혼식 (실2)

from re import L
import sys
from collections import deque
input = sys.stdin.readline

# 입력 & 그래프 만들기
N = int(input())
M = int(input())
graph = [[] for _ in range(N+1)]
for i in range(M):
  a, b = map(int, input().split())
  graph[a].append(b)
  graph[b].append(a)

def bfs(v):
  q = deque()
  q.append(v)
  visited[v] = 1
  while q:
    v = q.popleft()
    for i in graph[v]:
      if visited[i] == 0 and visited[v] <= 2:
        visited[i] = visited[v]+1
        q.append(i)  

visited = [0]*(N+1)
bfs(1)
print(N - visited.count(0))