n, m = map(int, input().split())
rice_cake = list(map, int(input().split()))

s = 0
e = max(rice_cake)
result = 0

while s<=e:
    total = 0
    mid = (s+e)//2
    for i in rice_cake:
        if i > mid:
            total += i - mid;
    if total < m:
        e = mid - 1
    else:
        result = mid
        start = mid + 1

