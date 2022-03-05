data = []
max_num = 0
count = 0
for i in range(9):
    data = int(input())
    if (data > max_num):
        max_num = data
        count = i+1

print(max_num)
print(count)