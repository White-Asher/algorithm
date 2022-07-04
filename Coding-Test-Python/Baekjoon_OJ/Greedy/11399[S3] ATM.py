saram = int(input())
indiSaram = list(map(int,input().split()))
indiSaram.sort()
sum = 0
temp = 0
for i in indiSaram:
    temp += i
    sum += temp
    
print(sum)