a = list(input())
a.sort(reverse=True)
sum = 0
for i in a:
    sum+=int(i)
if sum % 3 !=0 or "0" not in a:
    print(-1)
else:
    print("".join(a))