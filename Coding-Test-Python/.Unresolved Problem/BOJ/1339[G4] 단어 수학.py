n = int(input())
words = [input().rstrip() for _ in range(n)]
dict = {}

for word in words:
    sr = len(word) - 1
    for c in word:
        if c in dict:
            dict[c] += pow(10, sr)
        else:
            dict[c] = pow(10,sr)
        sr -= 1

dict = sorted(dict.values(), reverse=True)

result = 0
m = 9

for val in dict:
    result += val * m
    m -= 1

print(result)

'''
딕셔너리를 사용해줬다. 가장 높은 알파벳 순서대로 9부터 시작해주니 시작 값은 9로 설정 (num 변수)
그리고 딕셔너리에 값이 없으면 10의 제곱승을 추가해준다.
제곱승은 입력받은 길이에 따라 달라지고 for문을 한바퀴 돌 때마다 하나씩 줄어든다.
그리고 마지막에 딕셔너리를 큰 값부터 사용하기 위해 역정렬을 해준다.
그리고 값들을 result에 넣어 더해주고 출력해주면 된다.
'''