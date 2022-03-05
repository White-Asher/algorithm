# Stack 자료 구조를 이용한 풀이
N=int(input())

for i in range(N):
    string=input()
    string+=" "
    stack=[]
    for j in string:
        if j!=" ":
            stack.append(j)
        else:
            while stack:
                print(stack.pop(), end='')
            print(' ', end='')

# List 내부에서 제공하는 기능을 이용한 풀이
M=int(input())

for i in range(N):
    string=list(input().split())
    for j in string:
        print(j[::-1], end=' ')