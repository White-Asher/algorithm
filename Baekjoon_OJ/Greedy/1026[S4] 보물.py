# 답으로 인정되지만 문제 조건을 위반한 풀이
# n = int(input())
# a = list(map(int,input().split()))
# b = list(map(int,input().split()))
# a.sort(reverse=True)
# b.sort()
# answer = 0
# for i in range(n):
#     temp = a[i] * b[i]
#     answer += temp
    
# print(answer)

# 문제 조건을 만족한 풀이

n = int(input())
a = list(map(int,input().split()))
b = list(map(int,input().split()))
answer = 0
for i in range(n):
    a_max = a.pop(a.index(max(a)))
    b_min = b.pop(b.index(min(b)))
    answer += (a_max*b_min)
print(answer)