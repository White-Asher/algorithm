# n, k = map(int,input().split(" "))
# coin = []
# count = 0
# for i in range(n):
#     amount = int(input())
#     coin.append(amount)
# coin.sort(reverse=True)
    
# while k!=0:
#     for j in coin:
#         while k - j >= 0:
#             k -= j
#             count+=1
# print(count)

# 2번째 시도
# from collections import deque
# n, k = map(int,input().split())
# count = 0
# coin = deque()
# for i in range(n):
#     amount = int(input())
#     coin.appendleft(amount)
# while True:
#     coinpop = coin.popleft()
#     if k - coinpop >=0:
#         temp = k//coinpop
#         count = count + temp
#         k = k%coinpop
#     elif k == 0:
#         break
# print(count)


# 3번째 시도
# from collections import deque
# n, k = map(int,input().split())
# count = 0
# coin = list()
# for i in range(n):
#     amount = int(input())
#     coin.append(amount)
# coin.sort(reverse=True)
# coinque = deque(coin)
# while True:
#     coinpop = coinque.popleft()
#     if k - coinpop >=0:
#         temp = int(k/coinpop)
#         count = count + temp
#         k = k%coinpop
#     elif k == 0:
#         break
# print(count)

# 4번째 시도
n, k = map(int,input().split(" "))
coin = list()
count = 0
for i in range(n):
    amount = int(input())
    coin.append(amount)
    
for i in reversed(range(n)):
    temp = k//coin[i]
    count = count + temp
    k = k % coin[i]
    
print(count)