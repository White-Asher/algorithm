'''
n = int(input())
array = list(map(int,input().split()))

m = int(input())
x = list(map(int,input().split()))

def bin(array, target, start, end):
    while start <= end:
        mid = (start + end) // 2
        if array[mid] == target:
            return mid
        elif array[mid] > target:
            end = mid - 1
        else:
            start = mid + 1
    return None

for i in x:
    result = bin(array, i, 0, n-1)
    if result != None:
        print('yes', end = ' ')
    else:
        print('no', end = ' ')
'''
# 계수 정렬로 짜기

n = int(input())
array = [0] * 10000001

# 처음보는 테크닉
for i in input().split():
    array[int(i)] = 1

m = int(input())

x = list(map(int, input().split()))

for i in x:
    if array[i] == 1:
        print('yes', end=' ')
    else:
        print('no', end=' ')