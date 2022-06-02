# 제출한 풀이
def gcm(n,m):
    while m >0:
        n,m = m, n%m
    return n

def lcm(n,m):
    return n * m / gcm(n,m)

def solution(n, m):
    answer = [gcm(n,m), lcm(n,m)]
    return answer

'''유클리드 호제법 사용
# 재귀 호출 사용
def gcd(a,b):
    if a%b == 0 :
        return b
    elif b == 0 :
        return a
    else:
        return gcd(b,a%b)

# while문 사용
def gcd (a, b):
    while b:
        a,b = b, a%b  #파이썬에서 swap 하는 방법
    return x
'''