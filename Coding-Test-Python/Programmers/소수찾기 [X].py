import math 
def solution(n):
    arr = [True for i in range(n+1)]

    for i in range(2,int(math.sqrt(n))+1):
        if arr[i] == True:    
            j = 2
            while i * j <=n:
                arr[i*j] = False
                j+=1
    answer = len([i for i in range(2,n+1) if arr[i] == True])
    return answer
print(solution(5))