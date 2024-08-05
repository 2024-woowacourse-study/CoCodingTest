# 농장 관리 (골5)

import sys
from collections import deque
input = sys.stdin.readline

# 입력
N, M = map(int, input().split())
max_height = 0
arr = []
for i in range(N):
  m = list(map(int, input().split()))
  max_height = max(max_height, max(m))
  arr.append(m)

# bfs: isTop은 봉우리인지 아닌지 여부
def bfs(x, y, h):
  isTop = True
  q = deque()
  q.append((x, y))
  visited[x][y] = 1
  
  while q:
    x, y = q.popleft()
    for i in range(8):
      nx = x+dx[i]
      ny = y+dy[i]
      if 0 <= nx < N and 0 <= ny < M and visited[nx][ny] == 0:
        if arr[nx][ny] > h:
          isTop = False
        if arr[nx][ny] == h:
          visited[nx][ny] = 1
          q.append((nx, ny))
  return isTop

# bfs 호출
dx = [1, -1, 0, 0, 1, 1, -1, -1]
dy = [0, 0, 1, -1, 1, -1, 1, -1]
visited = [[0]*M for _ in range(N)]
answer = 0
for h in range(1, max_height+1):
  for i in range(N):
    for j in range(M):
      if arr[i][j] == h and visited[i][j] == 0:
        if bfs(i, j, h):
          answer += 1
      
print(answer)