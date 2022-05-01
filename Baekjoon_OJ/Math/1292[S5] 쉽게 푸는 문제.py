a,b = map(int,input().split())
li = []
i = 1
while True:
    for _ in range(i):
        li.append(i)
    i += 1
    if b < len(li):
        break
print(sum(li[a-1:b]))