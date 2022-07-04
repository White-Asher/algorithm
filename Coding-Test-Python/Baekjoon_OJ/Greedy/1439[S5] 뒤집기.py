# 내가 푼 코드
a = list(map(int, input()))
count = 0
for i in range(len(a)-1):
    if a[i] == a[i+1]:
        continue
    else:
        count+=1
if count % 2 == 0:
    count = int(count/2)
else :
    count = int((count+1)/2)
print(count)

# 사람들이 푼 일반적인 답안
s = input()
count = 0
for i in range(len(s)-1):
    if s[i] != s[i+1]:
        count +=1
print((count+1)//2)