# 참고한 풀이
import sys
input = sys.stdin.readline

on_off = {1:0, 0:1}

n = int(input())
sw = list(map(int, input().split()))
st = int(input())

for _ in range(st):
    s, num = map(int, input().split())
    
    if s == 1:
        i = num
        while num-1 < n:
            sw[num-1] = on_off[sw[num-1]]
            num += i
            
    else:
        i, j = num-2, num
        sw[num-1] = on_off[sw[num-1]]
        while i >= 0 and j < n:
            if sw[i] == sw[j]:
                sw[i] = on_off[sw[i]]
                sw[j] = on_off[sw[j]]
            else:
                break
            i -= 1
            j += 1
            
for i in range(0, n, 20):
    print(*sw[i:i+20])
