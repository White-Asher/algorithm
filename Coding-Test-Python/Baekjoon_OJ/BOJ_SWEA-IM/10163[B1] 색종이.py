import sys 

area = [[0 for _ in range(1001)] for _ in range(1001)]
n = int(sys.stdin.readline())

for i in range(1,n+1):
    x1,y1,x2,y2 = map(int,sys.stdin.readline().split())
    for j in range(x1, x1+x2):
        for k in range(y1, y1+y2):
            area[j][k] = i
 
for num in range(1,n+1):
    sum = 0
    for a in area:
        for b in a:
            if b == num:
                sum += 1
    print(sum)