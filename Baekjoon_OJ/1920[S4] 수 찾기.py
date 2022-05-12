# 이분탐색 사용 (제출한 답)
import sys
input = sys.stdin.readline

n = int(input())
n_list = list(map(int, input().split()))
n_list.sort()

m = int(input())
m_list = list(map(int, input().split()))

def sol(start, end, target):
    if start > end:
        return None
    mid = (start + end) // 2

    if n_list[mid] == target:
        return mid

    elif n_list[mid] > target:
        return sol(start, mid-1, target)
    else:
        return sol(mid+1, end, target)

for i in range(len(m_list)):
    res = sol(0, n-1, m_list[i])
    if res == None:
        print(0)
    else:
        print(1)

# 이분탐색 미사용 1
n = int(input())
A = set(map(int, input().split()))
m = int(input())
arr = list(map(int,input().split()))

for i in arr:
    if i in A:
        print(1)
    else:
        print(0)

# 이분탐색 미사용 2
import sys

N = int(input())
As = list(map(int, sys.stdin.readline().split()))
M = int(input())
Ms = list(map(int, sys.stdin.readline().split()))

As_dict = {}
for A in As:
    As_dict[A] = 1

for M in Ms:
    if M in As_dict:
        print(1)
    else:
        print(0)