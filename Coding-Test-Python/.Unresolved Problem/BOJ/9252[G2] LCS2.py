word1 = list(input())
word2 = list(input())

h = len(word1)
w = len(word2)

LCS = [[0] * (w + 1) for _ in range(h + 1)]
word = [[""] * (w + 1) for _ in range(h + 1)]

for i in range(1, h + 1):
    for j in range(1, w + 1):
        if word1[i - 1] == word2[j - 1]:
            LCS[i][j] = LCS[i - 1][j - 1] + 1
        else:
            LCS[i][j] = max(LCS[i - 1][j], LCS[i][j - 1])

def findword():
    result = ''
    current = LCS[-1][-1]
    x = len(LCS[0]) - 1
    y = len(LCS) - 1

    while current != 0:
        if LCS[y][x - 1] == current - 1 and LCS[y - 1][x] == current - 1:
            result = word2[x - 1] + result
            current -= 1
            x -= 1
            y -= 1
        else:
            if LCS[y - 1][x] > LCS[y][x - 1]:
                y -= 1
            else:
                x -= 1
    return result

print(LCS[-1][-1])
print(findword())
