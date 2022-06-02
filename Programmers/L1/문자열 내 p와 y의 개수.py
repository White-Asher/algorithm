def solution(s):
    s = s.lower()
    yCount = s.count('y')
    pCount = s.count('p')

    if yCount == pCount:
        return True
    elif yCount != pCount:
        return False
    elif yCount == 0 and pCount == 0:
        return True

    return True