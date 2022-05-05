# 오답
n = int(input())
r = []
nr = []
for i in range(n):
    a,b = map(int,input().split())
    r.append([a,b])
r.sort(key=lambda x: (x[0], -x[1]))
print(r)

temp = 0
for i in range(1,n+1):
    index = r[i-1][0]
    print(index)

    pos = [j for j, x in enumerate(r) if x == i]
    print(pos)
    for i in pos:
        nr.append(r[i])
        
        # print("len(nr):",len(nr))
        # print("i:", i)
        
    if len(nr) > i:
        temp = len(nr) - i
        print(nr)
        nr.sort(key=lambda x: (x[1]))
        for i in range(temp):
            nr.pop()
        
print(nr)

result = 0
for i in range(len(nr)):
    result += nr[i][1]

print(result)