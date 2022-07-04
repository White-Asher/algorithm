n = int(input())
seat = list(input())
holder = n+1
Lcount = 0
for i in range(n):
    if seat[i] == 'L':
        Lcount += 1
Lcount = Lcount // 2
holder -= Lcount
if holder > n:
    print(n)
else:
    print(holder)
    
# 다른 사람 풀이
N = int(input())
string = input().replace("LL", "L")
if len(string) + 1 <= N:
    print(len(string) + 1)
else:
    print(N)