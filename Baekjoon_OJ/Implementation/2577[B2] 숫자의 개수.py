# 내 제출답안
# sum = 1
# number_count = []
# for i in range(3):
#     a = int(input())
#     sum = sum * a
# while(sum != 0):
#     number_count.append(sum % 10)
#     sum = int(sum / 10)
# for i in range(10):
#     print(number_count.count(i))

# 다른사람 풀이  
# a = int(input())
# b = int(input())
# c = int(input())

# result = list(str(a * b * c))
# for i in range(10):
#     print(result.count(str(i)))
    
# 새로운 풀이
sum = 1
for i in range(3):
    a = int(input())
    sum = sum * a
    
result = list(str(sum))
for i in range(10):
    print(result.count(str(i)))