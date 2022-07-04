snum = int(input())
line_list = list(map(int,input().split()))

student = []

for i in range(0, snum):
    index = len(student) - line_list[i]
    student.insert(index, i+1)

print(" ".join(map(str, student)))

# 다른 답안
n = int(input())
l = list(map(int, input().split()))
nList = []
cnt = 1
for i in l:
    nList.insert(i,cnt)
    cnt += 1

print(*nList[::-1])