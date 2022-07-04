# # 참고
T = int(input())
for test_case in range(1, T + 1):
    N = int(input())
    farm = [list(map(int, list(input().strip()))) for _ in range(N)]

    m = N // 2
    answer = 0
    for i in range(m+1):
        for j in range(m - i, m + i + 1):
            answer += farm[i][j] + farm[N-i-1][j]

    print(f'#{test_case} {answer - sum(farm[m])}')
