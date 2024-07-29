# 죽음의 비 (골3)

import sys
from collections import deque
input = sys.stdin.readline

# 입력
N, H, D = map(int, input().split())
arr = [list(map(str, input().rstrip())) for _ in range(N)]

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

# bfs
def bfs(x, y):
  q = deque()
  q.append((x, y, H, 0, 0))
  arr[x][y] = '.'
  visited = [[0]*N for _ in range(N)]
  visited[x][y] = H
  while q:
    x, y, h, d, cnt = q.popleft()
    for i in range(4):
      nx = x + dx[i]
      ny = y + dy[i]
      if 0 <= nx < N and 0 <= ny < N:
        nh = h
        nd = d-1 if d > 0 else 0

        if arr[nx][ny] == '.':
          nh = h if d > 0 else h-1
        elif arr[nx][ny] == 'U':
          nh = h
          nd = D-1
        elif arr[nx][ny] == 'E':
          print(cnt+1)
          return

        if nh > 0 and visited[nx][ny] < nh+nd: #nh+nd가 visited보다 크면 갱신해줌→더 크면 더 멀리까지 갈 수 있음
          visited[nx][ny] = nh+nd
          q.append((nx, ny, nh, nd, cnt+1))
  print(-1)

# bfs 호출
for i in range(N):
  for j in range(N):
    if arr[i][j] == 'S':
      bfs(i, j)
      exit()
