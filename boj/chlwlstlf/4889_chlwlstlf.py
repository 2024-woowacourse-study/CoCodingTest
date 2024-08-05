# 안정적인 문자열 (실1)

import sys
input = sys.stdin.readline

case = 1
while True:
  S = input().rstrip()
  if '-' in S:
    break
  stack = []
  cnt = 0
  for s in S:
    if s == '{':
      stack.append(s)
    elif stack: # } 인데 stack에 값이 있을 경우
      stack.pop()
    else: # } 인데 stack이 비어있는 경우
      cnt += 1
      stack.append('{') # 나중에 } 만나면 사라지게 하기 위해
  print(f'{case}. {cnt+len(stack)//2}')
  case += 1