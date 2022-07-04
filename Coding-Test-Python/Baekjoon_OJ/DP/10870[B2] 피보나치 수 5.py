# 1. 재귀함수를 이용 (시간복잡도 매우 큼: 절대 이렇게 작성하면 안됨)
n = int(input())
def pi(n):
    if n==0:
        return 0
    elif n== 1 or n==2:
        return 1
    else:
        return pi(n-1)+pi(n-2)
print(pi(n))
# 2. 재귀함수 이용 (메모이제이션) Top-down
#한번 계산된 결과를 메모이제이션 하기 위한 리스트 초기화
# n = int(input())
# d = [0] * (n+1)
# def pibo(n):
#     if n == 0:
#         return 0
#     elif n == 1 or n == 2:
#         return 1
#     if d[n] != 0:
#         return d[n]
    
#     d[n] = pibo(n-1) + pibo(n-2)
#     return d[n]
# print(pibo(n))

# 제출용
# n = int(input())
# d = [0] * (n+1)
# def pi(n):
#     if n==0:
#         return 0
#     elif n==1 or n==2: 
#         return 1
#     if d[n]!=0: 
#         return d[n]
#     d[n]=pi(n-1)+pi(n-2)
#     return d[n]
# print(pi(n))
        
        
# 3. 재귀함수 이용 (메모이제이션) bottom-up
n=int(input())
d=[0]*(n+1)
if n==0:
    d[0]=0
elif n==1:
    d[1]=1
elif n==2:
    d[2]=1
else:
    d[0]=0
    d[1]=1
    d[2]=1
    for i in range(3,n+1):
        d[i]=d[i-1]+d[i-2]
print(d[n])
