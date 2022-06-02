from itertools import combinations

def isPrimeNumber(result):
    if result==0 or result==1:
        return False
    else:
        for i in range(2, (result-1)):
            if result%i == 0:
                return False
        return True

def solution(nums):
    answer = 0
    arr = list(combinations(nums, 3))
    for a in arr:
        if isPrimeNumber(sum(a)):
            answer += 1
    return answer