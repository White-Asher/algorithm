n = int(input())
arr = [(list(map(int,input().split(" ")))) for _ in range(n)]
arr_rank = []
for i in range(n):
    count = 0
    for j in range(n):
        if((arr[i][0] < arr[j][0]) and (arr[i][1] < arr[j][1])):
            count+=1
    arr_rank.append(count + 1)

for i in arr_rank:
    print(i, end =' ')


# n = int(input())
# original_arr = [(list(map(int,input().split(" ")))) for _ in range(n)]
# new_arr = original_arr
# new_arr.sort(key = lambda x:x[0], reverse=True)
# count = 1

# new_arr[0].append(1)
# if n >=2:
#     for i in range(0,n-1):
#         if((new_arr[i][0] > new_arr[i+1][0]) and (new_arr[i][1] > new_arr[i+1][1])):
#             count = i+2
#             new_arr[i+1].append(count)
#         else:
#             new_arr[i+1].append(count)