def solution(numbers):
    result = set([])
    for i in range(len(numbers)):
        for j in range(i+1, len(numbers)):
            sumNum = numbers[i] + numbers[j]
            result.add(sumNum)
    answer = list(result)
    answer.sort()
    return answer

# 간결한 코드
def solution(numbers):
    answer = []
    for i in range(len(numbers)):
        for j in range(i+1, len(numbers)):
            answer.append(numbers[i] + numbers[j])
    return sorted(list(set(answer)))