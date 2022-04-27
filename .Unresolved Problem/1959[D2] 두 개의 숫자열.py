t=int(input())
for tc in range(1,t+1):

    n,m=map(int,input().split())
    a=list(map(int,input().split()))
    b=list(map(int,input().split()))

    sum = []
    
    if n>m:
        for i in range(1+n-m):
            temp = 0 
            for j in range(m):
                temp += a[j+i] * b[j]
            sum.append(temp)

        print("#{} {}".format(tc, max(sum)))
    else:
        for i in range(1+m-n):
            temp = 0 
            for j in range(n):
                temp += a[j] * b[j+i]
            sum.append(temp)
        print("#{} {}".format(tc, max(sum)))