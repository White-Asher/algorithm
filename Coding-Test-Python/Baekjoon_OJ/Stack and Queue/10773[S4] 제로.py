n = int(input())
arr = []
for i in range(n):
    a = int(input())
    if (a == 0):
        arr.pop()
    else:
        arr.append(a)

sum = 0
for i in arr:
    sum += i
    
print(sum)