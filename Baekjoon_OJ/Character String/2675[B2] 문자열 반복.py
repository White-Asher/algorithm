# n = int(input())
# result = []
# for i in range(n):
#     new_data = []
#     repeat ,data = input().split(" ")
#     data = list(data)
#     repeat = int(repeat)
#     for j in range(len(data)):
#         temp = data[j]*repeat
#         new_data.append(temp)
#         s = "".join(new_data)
#     result.append(s)

# for k in result:
#     print(k)
    
n = int(input())
for _ in range(n):
    repeat, word = input().split()
    for x in word:
        print(x*int(repeat), end='')
    print()