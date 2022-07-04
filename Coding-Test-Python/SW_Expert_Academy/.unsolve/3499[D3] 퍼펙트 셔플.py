t = int(input())
for tc in range(1, t+1):
    n = int(input())
    word = list(input().split())
    nw = []
    for tr in range(len(word)//2):
        if word[tr] is not None:
            nw.append(word[tr])
        if word[(n+1)//2 + tr] is not None:
            nw.append(word[(n+1)//2 + tr])
    if n % 2 == 1:
        nw.append(word[n//2])
    print("#{}".format(tc),end= ' ')
    for i in nw:
        print(i,end=' ')
    print()