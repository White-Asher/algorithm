a = list(input())
b = list(input())
h = len(a)
w = len(b)
LCS = [[0]*(w+1) for _ in range(h+1)]

result = 0
for i in range(1, h+1):
    for j in range(1, w+1):
        if a[i-1] == b[j-1]:
            LCS[i][j] = LCS[i-1][j-1] + 1
        else:
            LCS[i][j] = max(LCS[i-1][j], LCS[i][j-1])
print(LCS[-1][-1])