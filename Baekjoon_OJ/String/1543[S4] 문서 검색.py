s = input()
a = input()
cnt = 0
idx = 0
for i in range(len(s)):
    if idx > i:
        continue
    if a == s[i: i + len(a)]:
        cnt += 1
        idx = i + len(a)
print(cnt)