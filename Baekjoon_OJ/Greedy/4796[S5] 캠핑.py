count = 0
while True:
    L,P,V = map(int, input().split(" "))
    if L == 0 and P == 0 and V == 0:
        break;
    count += 1
    answer = 0
    quotient = int(V/P)
    remainder = V%P
    remainderAval = 0
    if remainder > L :
        remainderAval = L
    else:
        remainderAval = remainder
    answer = (quotient*L) + remainderAval
    print("Case %d: %d"%(count,answer))