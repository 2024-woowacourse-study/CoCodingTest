# 용돈 관리 (실2)

import sys
input = sys.stdin.readline

N, M = map(int, input().split())
arr = [int(input()) for _ in range(N)]

start = max(arr)
end = sum(arr)
result = (start+end)//2

while start <= end:
  mid = (start+end)//2
  total = mid
  cnt = 1 #처음에 통장에서 인출하고 시작하니까 0이 아닌 1로 초기화
  for i in range(N):
    if arr[i] <= total:
      total -= arr[i]
    else:
      cnt += 1
      total = mid-arr[i]
  if cnt <= M:
    result = mid
    end = mid-1
  else:
    start = mid+1

print(result)
