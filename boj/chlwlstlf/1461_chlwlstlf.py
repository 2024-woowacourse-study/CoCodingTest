# 도서관 (골4)

import sys
input = sys.stdin.readline

N, M = map(int, input().split())
arr = list(map(int, input().split()))

result = []

# 음수 M개씩 묶기
arr.sort()
for i in range(N):
  if i%M == 0 and arr[i] < 0:
    result.append(abs(arr[i]))

# 양수 M개씩 묶기
arr.sort(reverse=True)
for i in range(N):
  if i%M == 0 and arr[i] > 0:
    result.append(arr[i])

# 제일 큰 수 빼고 다 x2한 값을 더하기
result.sort(reverse=True)
answer = result[0]
for i in range(1, len(result)):
  answer += result[i]*2

print(answer)
