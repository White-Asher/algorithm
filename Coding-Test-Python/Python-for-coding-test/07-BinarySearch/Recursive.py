import sys
input = sys.stdin.readline
def bin(array, target, start, end):
    if start > end:
        return None
    mid = (start + end) // 2

    if array[mid] == target:
        return mid
    elif array[mid] > target:
        return bin(array, target, start, mid-1)
    else:
        return bin(array, target, mid + 1, end)

n, target = list(map (int, input().split()))

array = list(map(int, input().split()))

result = bin(array, target, 0, n-1)
if result == None:
    print("원소가 존재하지 않음")
else:
    print(result + 1)
