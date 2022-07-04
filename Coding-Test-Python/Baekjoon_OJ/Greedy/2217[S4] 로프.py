#  1차 시도
# n = int(input())
# rope = []
# for i in range(n):
#     rope.append(int(input()))
# rope.sort(reverse=True)
# if len(rope) >=2 :
#     print(int((rope[0]+rope[1])/2))
# else:
#     print(rope[0])


# 2차 시도
def solution():
    n = int(input())
    rope = []
    for i in range(n):
        rope.append(int(input()))
    rope.sort(reverse=True)
    for j in range(n):
        rope[j] = rope[j] * (j+1)
    return max(rope)

print(solution())