t = int(input())
gugu = set()
for i in range(1,10):
    for j in range(1,10):
        gugu.add(i*j)

for tc in range(1, t+1):
    n = int(input())
    if n in gugu:
        print("#{} {}".format(tc, 'Yes'))
    else:
        print("#{} {}".format(tc, 'No'))