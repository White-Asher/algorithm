# primary answer...
def condition(x):
    for i in range(x):
        if h[x] == h[i] or abs(h[x] - h[i]) == x - i:
            return False
    return True

def queen(x):
    global result
    # 입력한 수 N까지 전부돌고 만족하는 경우가 있다면 결과에 +1을 함.
    if x == n:
        result += 1

    # 체스판 하나의 경우에서 제약조건을 검사하는 조건문 (열번호 0부터 N까지 검사)
    else:
        for i in range(n):
            h[x] = i
            if condition(x):
                queen(x+1)

n = int(input())
result = 0
h = [0] * n
queen(0)
print(result)

# 풀이 출처 https://seongonion.tistory.com/103

# 다른 풀이

def adjacent(x):  # x와 i 가 같으면 행이 같은거 근데 for문을 보면 x와 i가 같을 수가 없다.
    for i in range(x):  # 인덱스가 행  row[n]값이 열
        if row[x] == row[i] or abs(row[x] - row[i]) == x - i:  # 열이 같거나 대각선이 같으면 false
            return False  # 대각선이 같은경우는 두 좌표에서 행 - 행 = 열 - 열 이 같으면 두개는 같은 대각선상에 있다.
    return True


# 한줄씩 재귀하며 dfs 실행
def dfs(x):
    global result

    if x == N:
        result += 1
    else:
        # 각 행에 퀸 놓기
        for i in range(N):  # i 는 열번호 0부터 N 전까지 옮겨가면서 유망한곳 찾기
            row[x] = i
            if adjacent(x):  # 행,열,대각선 체크함수 true이면 백트래킹 안하고 계속 진행
                dfs(x + 1)

N = int(input())
row = [0] * N
result = 0
print(row)
dfs(0)
print(result)

# https://sso-feeling.tistory.com/415?category=913126