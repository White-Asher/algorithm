T = int(input())
for test_case in range(1, T + 1):
    n,m = map(int,input().split())
    arr = [list(map(int,input().split())) for i in range(n)]
    
    sum_list = []
    for i in range(n-m+1):
        for j in range(n-m+1):
            temp = []
            for c in range(m):
                for r in range(m):
                    temp.append(arr[i+c][j+r])
            sum_list.append(sum(temp))
    
    print("#{} {}".format(test_case,max(sum_list)))