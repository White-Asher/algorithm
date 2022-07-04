T = int(input())
for test_case in range(1, T + 1):
    a,b = map(int,input().split())
    if a>b:
        c = '>'
    elif a == b:
        c = '='
    elif a<b:
        c = '<'
    print("#{} {}".format(test_case,c))    