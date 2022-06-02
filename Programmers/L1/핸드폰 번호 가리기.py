def solution(pn):
    answer = []
    for i in range(len(pn[:-4])):
        answer.append("*")
    answer.append(pn[-4:])
    answer = ''.join(answer)
    return answer