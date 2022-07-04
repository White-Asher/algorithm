def solution(n):
    cnt = 0
    while cnt <= 500:
        if n == 1:
            break

        if n % 2 == 0:
            n = n // 2
        else:
            n = n * 3 + 1
        cnt += 1

    if cnt > 500:
        cnt = -1

    return cnt