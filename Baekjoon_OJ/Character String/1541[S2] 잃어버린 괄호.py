n = input().split('-')
num_list = []
for i in n:
    temp = 0
    s = i.split('+')
    for j in s:
        temp += int(j)
    num_list.append(temp)
result = num_list[0]
for i in range(1, len(n)):
    result -= num_list[i]
print(result)