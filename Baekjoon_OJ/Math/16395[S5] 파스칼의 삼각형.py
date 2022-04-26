n, k = map(int,input().split())
num_list = [[1],[1,1]]
for i in range(2, n):
    t = [1]
    for j in range(1,i):
        t.append(num_list[i-1][j-1] + num_list[i-1][j])
    t.append(1)
    num_list.append(t)
print(num_list[n-1][k-1])
for i in num_list:
    print(*i)
# 다른 답안 (더 짧은 시간)
# pascal = [[1 for _ in range(i)] for i in range(1, 31)]
# for i in range(2, 30):
#     for j in range(1, i):
#         pascal[i][j] = pascal[i-1][j-1] + pascal[i-1][j]
# n, k = map(int, input().split())
# print(pascal[n-1][k-1])