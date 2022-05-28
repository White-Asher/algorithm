t = int(input())
for tc in range(1, t+1):
    w = list(input())
    print("#{}".format(tc),end=' ')
    dupSet = set(w)
    if len(w) == 4 and len(dupSet) == 2:
        if w.count(w[0]) == 2:
            print('Yes')
    else:
        print('No')