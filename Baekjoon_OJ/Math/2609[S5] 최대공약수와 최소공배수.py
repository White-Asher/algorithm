# 내가 제출한 코드
# a = list(map(int,input().split()))
# max_d = max(a)
# GCD = []
# LCM = []
# while max_d != 1:
#     if (a[0] % max_d)==0 and (a[1] % max_d)==0:
#         a[0]=a[0]/max_d 
#         a[1]=a[1]/max_d
#         LCM.append(max_d)
#         GCD.append(max_d)
#         max_d = max(a)
#     else: 
#         max_d-=1
# LCM.append(a[0])
# LCM.append(a[1])
# Multi_GCD = 1
# Multi_LCM = 1
# for i in GCD:
#     Multi_GCD = Multi_GCD * i
# print(Multi_GCD)
# for i in LCM:
#     Multi_LCM = Multi_LCM * i
# print(int(Multi_LCM))

#다른사람 코드
a, b = map(int, input().split())
def gcd(a, b):
    while b > 0:
        a, b = b, a % b
    return a
def lcm(a, b):
    return a * b // gcd(a, b)
print(gcd(a, b))
print(lcm(a, b))