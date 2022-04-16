# primary answer...

def condition(x):
    for i in range(x):
        if h[x] == h[i] or abs(h[x] - h[i]) == x - i:
            return False
    return True

def queen(x):
    global result
    # 입력한 수 N까지 전부돌고 만족하는 경우가 있다면 결과에 +1을 함.
    if x == n :
        result += 1
    
    # 체스판 하나의 경우에서 제약조건을 검사하는 조건문 (열번호 0부터 N까지 검사)
    else:
        for i in range(n):
            h[x] = i
            if condition(x):
                queen(x+1)
                
n = int(input())
result = 0   
h = [0] * n                
queen(0)
print(result)