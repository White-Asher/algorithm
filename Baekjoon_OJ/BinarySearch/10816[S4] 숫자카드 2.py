import sys
input = sys.stdin.readline

n = int(input())
n_list = list(map(int, input().split()))
n_list.sort()
m = int(input())
m_list = list(map(int, input().split()))

count = {}

for li in n_list:
    if li in count:
        count[li] += 1
    else:
        count[li] = 1

def sol(start, end, target):
    if start > end:
        return 0
    mid = (start + end) // 2
    if n_list[mid] == target:
        return count.get(target)
    elif n_list[mid] > target:
        return sol(start, mid - 1, target)
    else:
        return sol(mid + 1, end, target)

for i in m_list:
    print(sol(0, len(n_list)-1, i), end=' ')

# 키를 이용한 풀이
N=int(input())
nData=list(map(int,input().split()))
mySet = {}
for n in nData:
    if n not in mySet.keys():
        mySet[n]=1
    else:
        mySet[n]+=1
M=int(input())
mData=list(map(int,input().split()))

for m in mData:
    if mySet.get(m)==None:
        print(0,end=' ')
    else:
        print(mySet.get(m),end=' ')

# Counter 모듈을 이용한 풀이
n = int(input())
list1 = list(map(int, input().split()))
m = int(input())
list2 = list(map(int, input().split()))
from collections import Counter
count = Counter(list1)
for i in range(len(list2)):
    if list2[i] in count:
        print(count[list2[i]], end = ' ')
    else:
        print(0, end = ' ')

# 시도한 답: 시간초과 (오답)
'''
import sys
input = sys.stdin.readline

n = int(input())
n_list = list(map(int, input().split()))
m = int(input())
m_list = list(map(int, input().split()))
n_list.sort()
res_list = []

def sol(start, end, target):
    if start > end:
        return None
    mid = (start + end) // 2
    if n_list[mid] == target:
        return n_list[start:end+1].count(target)
    elif n_list[mid] > target:
        return sol(start, mid-1, target)
    else:
        return sol(mid+1, end, target)

for i in range(len(m_list)):
    result = sol(0, n-1, m_list[i])
    if result == None:
        print(0,end = ' ')
    else:
        print(result, end= ' ')
        
'''