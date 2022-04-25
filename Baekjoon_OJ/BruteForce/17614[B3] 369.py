# 시간초과
# n = int(input())
# count = 0
# for i in range(1, n+1):
#     istr_list = list(str(i))
#     for j in istr_list:
#         if j == '3' or j == '6' or j == '9':
#             count += 1
# print(count)

#리스트 안쓰고
import sys
input = sys.stdin.readline
res = 0
for i in range(1, int(input())+1):
    res += str(i).count('3')+str(i).count('6')+str(i).count('9')
print(res)

# import sys
# input = sys.stdin.readline
# res = 0
# for i in range(1, int(input()+1):
#     res += str(i).count('3')+str(i).count('6')+str(i).count('9')
# print(res)