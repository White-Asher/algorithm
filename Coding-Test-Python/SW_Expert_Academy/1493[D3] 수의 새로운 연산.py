T = int(input())
for tc in range(1, T + 1):
    n = int(input())
    a = []
    for i in range(n):
        a.append(int(input()))
    b = sum(a) // n
    res = 0
    for i in range(n):
        if a[i] < b:
           res += b-a[i]

    print("#{} {}".format(tc,res ))


# 다른 풀이
r = []
for tc in range(int(input())):
    N = int(input())
    info = [int(input()) for _ in range(N)]
    avg = sum(info)//N
    r.append("#{} {}".format(tc+1, sum([x-avg for x in info if x>avg])))
print("\n".join(r))