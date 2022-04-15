T = 10
for test_case in range(1, T + 1):
    count = int(input())
    width = list(map(int , input().split()))
    result = 0
    for i in range(count):
        maxIndex = width.index(max(width))
        minIndex = width.index(min(width))

        width[maxIndex]=width[maxIndex] - 1
        width[minIndex]=width[minIndex] + 1

    result = max(width) - min(width)
    print("#{} {}".format(test_case, result))



# width = list(map(int , input().split()))
# count = 10 
# for i in range(count):
#     maxtemp = max(width)
#     maxIndex = width.index(maxtemp)
#     # print(width[maxIndex])
    
#     mintemp = min(width)
#     minIndex = width.index(mintemp)
#     # print(width[minIndex])
    
#     width[maxIndex]=width[maxIndex] - 1
#     width[minIndex]=width[minIndex] + 1
    
# result = width[maxIndex] - width[minIndex]
# print("#{} {}".format(i, result))


# T = 10
# for test_case in range(1,2):
#     count = int(input())
#     width = list(map(int , input().split()))
#     result = 0
#     for i in range(count):
#         maxtemp = max(width)
#         maxIndex = width.index(maxtemp)
        
#         mintemp = min(width)
#         minIndex = width.index(mintemp)
#         if(width[maxIndex] == width[minIndex]):
#             break
#         elif width[maxIndex] != width[minIndex]:
#             width[maxIndex]=width[maxIndex] - 1
#             width[minIndex]=width[minIndex] + 1
#         # print("i: ",i,"result: ",width[maxIndex] - width[minIndex])
#     result = width[maxIndex] - width[minIndex]
#     print("#{} {}".format(test_case, result))
