n = int(input())
fact = 1
for i in range(1, n+1):
    fact *= i
str_fact = list(str(fact))

cnt = 0
for i in range(len(str_fact)-1, 0, -1):
    if str_fact[i] == '0':
        cnt += 1
    else:
        break

print(cnt)

# 다른 답안
N = int(input())
cnt = 0
while N >= 5:
    cnt += N // 5
    N = N//5
print(cnt)
# 출처: https://beginnerdeveloper-lit.tistory.com/18