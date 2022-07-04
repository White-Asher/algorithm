def solution(n):
    n = list(str(n))
    n.sort(reverse = True)
    a = int(''.join(n))
    return a