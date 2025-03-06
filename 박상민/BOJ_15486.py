# 문제: https://www.acmicpc.net/problem/15486

import sys
input = lambda: sys.stdin.readline().rstrip()


N = int(input())
arr = []

for _ in range(N):
    t, p = map(int, input().split()) # 시간, 금액
    arr.append([t,p])

dp = [0]*(N+1)
for i in range(N-1, -1, -1): # 역순으로 진행
    t, p = arr[i]
    if i + t > N: #일자 초과 시
        dp[i] = dp[i+1]
    else:
        dp[i] = max(dp[i+1], p+dp[i+t])

print(max(dp))