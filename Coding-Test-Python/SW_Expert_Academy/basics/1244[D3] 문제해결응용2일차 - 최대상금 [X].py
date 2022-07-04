# 다른사람의 답안...

# def dfs(idx, cnt):
#     global answer
#     if cnt == int(target):
#         answer = max(int("".join(nums)), answer)
#         return
#     for now in range(idx, n):
#         for max_idx in range(now + 1, n):
#             if nums[now] <= nums[max_idx]:
#                 nums[now], nums[max_idx] = nums[max_idx], nums[now]
#                 dfs(now, cnt + 1)
#                 nums[now], nums[max_idx] = nums[max_idx], nums[now]
#     if not answer and cnt < int(target):
#         rotate = (int(target) - cnt) % 2
#         if rotate:
#             nums[-1], nums[-2] = nums[-2], nums[-1]
#         dfs(idx, int(target))


# for test in range(1, int(input()) + 1):
#     nums, target = input().split()
#     n = len(nums)
#     nums = list(nums)
#     answer = 0
#     dfs(0, 0)
#     print(f'#{test} {answer}')
    
# 이해 안되서 참고한 또 다른 사람의 답안.

def dfs(changeCount):
    global answer
    if not changeCount:
        tempInt = int(''.join(value))
        if answer < tempInt:
            answer = tempInt
            return 
    for i in range(lengthvalue):
        for j in range(i+1, lengthvalue):
            value[i], value[j] = value[j], value[i]
            temp_key = ''.join(value)
            if visited.get((temp_key, changeCount -1),1):
                visited[(temp_key, changeCount -1 )] = 0
                dfs(changeCount-1)
            value[i], value[j] = value[j], value[i]
            

for t in range(1, int(input())+1):
    answer = -1
    value, change = input().split()
    value = list(value)
    change = int(change)
    lengthvalue = len(value)
    
    visited = []
    dfs(change)
    print(f'#{t} {answer}')
