# 내장함수 사용
T = int(input())
for test_case in range(1, T + 1):
    n = int(input())
    num_list = list(map(int,input().split()))
    num_list.sort()
    print("#{}".format(test_case), end= ' ')
    print(" ".join(map(str, num_list)))
    
# 내장함수 사용 X (추후에 정렬 공부하면 따로 작성해보자...)
from collections import deque
T = int(input())
for test_case in range(1, T + 1):
    n = int(input())
    num_list = list(map(int,input().split()))
    num_deque = deque(num_list)    
    
    print("#{}".format(test_case), end= ' ')
    print(" ".join(map(str, num_list)))