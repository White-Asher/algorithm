month = [31,28,31,30,31,30,31,31,30,31,30,31]
T = int(input())
for test_case in range(1, T + 1):
    m1, d1, m2, d2 = map(int,input().split())
    
    result=1
    for x in range(m1-1, m2-1):
        result+=month[x]
    result += d2
    result -= d1

    print("#{} {}".format(test_case,result))