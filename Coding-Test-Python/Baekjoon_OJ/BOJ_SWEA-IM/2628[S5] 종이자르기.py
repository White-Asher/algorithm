x,y = map(int,input().split())
n = int(input())
xn = [0]
yn = [0]
for i in range(n):
    a,b = map(int,input().split())
    if a == 1:
        xn.append(b)
        xn.sort()
    elif a == 0:
        yn.append(b)
        yn.sort()
        
xn.append(x)
yn.append(y)

mx_len_x = 0
mx_len_y = 0

for i in range(len(xn)-1):
    len_x = -(xn[i] - xn[i+1])
    if len_x > mx_len_x:
        mx_len_x = len_x

for i in range(len(yn)-1):
    len_y = -(yn[i] - yn[i+1])
    if len_y > mx_len_y:
        mx_len_y = len_y
        
print(mx_len_x*mx_len_y)