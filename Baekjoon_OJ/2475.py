# a, b, c, d, e = input().split(" ")
# a = int(a)
# b = int(b)
# c = int(c)
# d = int(d)
# e = int(e)
#
# print(((a*a)+(b*b)+(c*c)+(d*d)+(e*e))%10)

# 더 효율적인 코드
sum = 0
for num in map(int, input().split()):
    sum += num**2
print(sum % 10)

