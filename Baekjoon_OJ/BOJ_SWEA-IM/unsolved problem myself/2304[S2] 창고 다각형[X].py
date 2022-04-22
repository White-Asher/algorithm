# stack = []
# area = 0
# new_stack = []

# for i in range(int(input())):
#     x, y = map(int,input().split())
#     stack.append([x,y])
# stack.sort()

# y = [i[1] for i in stack]
# y_index = y.index(max(y))
# print(y_index)

# for i in range(0, y_index+1):
    
    

# y = [i[1] for i in stack]
# leny= len(y)
# y_min = 0
# y_max = stack[leny-1][1]
# y_index = y.index(max(y))


# for i in range(len(stack)-1):
#     if i< y_index:
#         if y_min < stack[i][1]:
#             new_stack.append(stack[i])
#             y_min = stack[i][1]
#         else: 
#             continue
        
#     elif i > y_index:
#         if y_max > stack[i][1]:
#             new_stack.append(stack[i])
#             y_max = stack[i][1]
#         else: 
#             continue
    
#     elif i == y_index:
#         new_stack.append(stack[i])
            
# print(new_stack)


n = int(input())
x_max, y_max = 0,0
stack = []

for i in range(n):
    x,y = map(int,input().split())
    stack.append([x,y])
stack.sort()

