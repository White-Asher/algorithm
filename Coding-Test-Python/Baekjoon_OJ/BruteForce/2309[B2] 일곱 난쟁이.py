# 1번째 방법
a = [int(input()) for _ in range(9)]
sumList = sum(a)

for i in range(8):
    for j in range(i+1, 9):
        if sumList - (a[i] + a[j]) == 100:
            one = a[i]
            two = a[j]
            a.remove(one)
            a.remove(two)
            a.sort()
            for b in a:
                print(b)
        if len(a)<=8:
            break
    if len(a)<=8:
        break
    

# 2번째
a = [int(input()) for _ in range(9)]
sumList = sum(a)

for i in range(8):
    for j in range(i+1, 9):
        if sumList - (a[i] + a[j]) == 100:
            one = a[i]
            two = a[j]
            
a.remove(one)
a.remove(two)
a.sort()
for b in a:
    print(b)