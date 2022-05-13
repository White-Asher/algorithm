# 제출 답안
# T = int(input())
# for test_case in range(1, T + 1):
#     word = list(input())
#     count = 0
#     result = 0
#     if len(word) == 1:
#         result = 1
#     elif len(word) % 2 == 1:
#         mid = len(word)//2 
#         for i in range(1, mid+1):
#             if word[mid-i] == word[mid+i]:
#                 count += 1
#         if count == mid:
#             result = 1
#     elif len(word) % 2 == 0:
#         mid = len(word)//2 -1
#         for i in range(0, mid+1):
#             if word[mid-i] == word[mid+1+i]:
#                 count += 1
#         if count == mid+1:
#             result = 1
                
#     print("#{} {}".format(test_case, result))
    
# 다른 풀이
# 입력받은 문자열을 list에 담고, 그 리스트의 reverse가 같다면 회문이라고 볼 수 있기 때문에
# 간단히, list[::-1]을 통해 풀이 하였다.

for i in range(1, int(input())+1):
    a = [w for w in input()]
    if a == a[::-1]:
        print(f"#{i} {1}")
    else:
        print(f"#{i} {0}")