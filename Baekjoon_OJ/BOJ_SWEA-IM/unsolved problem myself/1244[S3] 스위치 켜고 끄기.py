# 제출한 답안 (시간초과)
# import sys
# input = sys.stdin.readline

# sw_count = int(input())
# sw = list(map(int,input().split()))

# stu_count = []
# for i in range(int(input())):
#     stu_count.append(list(map(int,input().split())))
    
#     if stu_count[i][0] == 1:
#         sw_num = stu_count[i][1]
#         for j in range(1, int(len(sw)/sw_num)+ 1):
#             st = (j*sw_num)-1
#             if sw[st] == 1:
#                 sw[st] = 0
#             elif sw[st] == 0:
#                 sw[st] = 1
    
#     elif stu_count[i][0] == 2:
#         sw_num = stu_count[i][1] - 1
#         t1 = sw_num - 1
#         t2 = sw_num + 1
#         if sw[sw_num] == 1:
#             sw[sw_num] = 0
#         elif sw[sw_num] == 0:
#              sw[sw_num] = 1
            
#         while t1 >= 0 and t2 <len(sw):
#             if sw[t1] == sw[t2]:
#                 if sw[t1] == 1:
#                     sw[t1] = 0
#                 elif sw[t1] == 0:
#                     sw[t1] = 1
                
#                 if sw[t2] == 1:
#                     sw[t2] = 0
#                 elif sw[t2] == 0:
#                     sw[t2] = 1
                
#                 else: 
#                     break
#                 t1 -= 1
#                 t2 += 1
            
# for i in range(0, sw_count, 20):
#     print(*sw[i:i+20])

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
