def solution(x):
    return False if x%sum(list(map(int,str(x))))!=0 else True

''' 보기 좋은 코드
def solution(x):
    answer = True
    nl = list(map(int, str(x)))
    if x % sum(nl) != 0:
        answer = False
    return answer
'''