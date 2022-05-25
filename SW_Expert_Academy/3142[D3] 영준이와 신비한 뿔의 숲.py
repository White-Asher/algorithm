t = int(input())
for tc in range(1, t+1):
    n, m = map(int, input().split())
    x = n-m
    y = m-x
    print("#{} {} {}".format(tc,y,x))