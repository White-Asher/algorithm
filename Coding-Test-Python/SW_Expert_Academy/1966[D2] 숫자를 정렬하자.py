# 내장함수 사용
T = int(input())
for test_case in range(1, T + 1):
    n = int(input())
    num_list = list(map(int,input().split()))
    num_list.sort()
    print("#{}".format(test_case), end= ' ')
    print(" ".join(map(str, num_list)))