t = int(input())
for tc in range(1, t+1):
    n = int(input())
    ground = [list(map(int, input().split())) for _ in range(n)]
    result = 0

    s, e = n // 2, n // 2
    for i in range(n):
        for j in range(s, e+1):
            result += ground[i][j]
        if i < n // 2:
            s -= 1
            e += 1
        else:
            s += 1
            e -= 1
    print("#{} {}".format(tc, result))


# 참고
# T = int(input())
# for t in range(1, T+1):
#     N = int(input())
#     map_list = [list(map(int, list(input()))) for _ in range(N)]
#     t_N = N//2
#     change = -1
#     answer = 0
#     for i in range(N):
#         if i >= N//2:
#             change = 1
#         for j in range(abs(i-N//2), abs(N-t_N)):
#             answer += map_list[i][j]
#         t_N += change
#     print('#{} {}'.format(t, answer))