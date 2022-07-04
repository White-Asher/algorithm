def solution(n):
    sqn = n**(1/2)
    if int(sqn)**2 == n:
        answer = (sqn+1)**2
    else:
        answer = -1
    return answer