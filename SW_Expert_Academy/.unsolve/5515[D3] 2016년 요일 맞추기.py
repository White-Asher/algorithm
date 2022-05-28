T = int(input())
c = [31,29,31,30,31,30,31,31,30,31,30,31]

for tc in range(1,T+1):
    m,d = map(int,input().split())
    tmp = 0
    for i in range(m-1):
        tmp += c[i]
    tmp += d
    tmp = tmp % 7
    answer = (tmp + 4 - 1) % 7
    print('#%d %s' % (tc,answer))