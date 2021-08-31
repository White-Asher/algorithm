n = int(input())
data = list(map(int,input().split()))
max_num = max(data)
sum = 0
for i in range(n):
    data[i] = data[i]/max_num*100
    sum += data[i]

print(sum/n)