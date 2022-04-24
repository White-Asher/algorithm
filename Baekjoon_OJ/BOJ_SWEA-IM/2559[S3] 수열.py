# 시간초과 deque로...
n, k = map(int,input().split())
temp = list(map(int,input().split()))
seq_temp = [] 
for i in range(n+1-k):
    result = 0
    for j in range(0+i,k+i):
        result += temp[j]
    seq_temp.append(result)
print(max(seq_temp))