import sys
input = sys.stdin.readline

on_off = {1:0, 0:1}

sw_count = int(input())
sw = list(map(int, input().split()))
std_num = int(input())

for _ in range(std_num):
    std_gen, sw_num = map(int, input().split())
    
    if std_gen == 1:
        i = sw_num
        while sw_num-1 < sw_count:
            sw[sw_num-1] = on_off[sw[sw_num-1]]
            sw_num += i
            
    else:
        i, j = sw_num-2, sw_num
        sw[sw_num-1] = on_off[sw[sw_num-1]]
        while i >= 0 and j < sw_count:
            if sw[i] == sw[j]:
                sw[i] = on_off[sw[i]]
                sw[j] = on_off[sw[j]]
                i -= 1
                j += 1
                
            else:
                break
            
for i in range(0, sw_count, 20):
    print(*sw[i:i+20])



############################################
# 제출답안 (시간초과)
# import sys
# input = sys.stdin.readline
# from collections import deque

# sw_count = int(input())
# sw = deque(list(map(int,input().split())))

# stu_count = deque([])
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

# for i in range(0,len(sw)):
#     if i % 20 == 0:
#         print()
#     print(sw[i], end=' ')