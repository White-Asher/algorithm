import heapq
import sys

def inputdata(n):
    classarr = []
    for _ in range(n):
        a,b = list(map(int, sys.stdin.readline().split()))
        classarr.append([a,b])
    classarr.sort(key = lambda x:x[0])
    print(classarr)
    return classarr
    
def solution(): 
    n = int(sys.stdin.readline())
    classarr = inputdata(n)
    roomAmount = []
    heapq.heappush(roomAmount, classarr[0][1])
    
    for i in range(1, n):
        if classarr[i][0] < roomAmount[0]:
            heapq.heappush(roomAmount , classarr[i][1])
        else:
            heapq.heappop(roomAmount)
            heapq.heappush(roomAmount, classarr[i][1])
            
    return len(roomAmount)

print(solution())


# import heapq
# import sys

# def inputdata(n):
#     classarr = []
#     for _ in range(n):
#         a,b = list(map(int, sys.stdin.readline().split()))
#         classarr.append([a,b])
        
#     classarr.sort(key = lambda x:x[1],reverse=True)
#     print(classarr[0][0])
#     print(classarr[0][1])

#     print(classarr[1][0])
#     print(classarr[1][1])
#     print(classarr[2][0])
#     print(classarr[2][1])
    
#     return classarr
# n = int(sys.stdin.readline())
# inputdata(n)
# def solution(): 
#     n = int(sys.stdin.readline())
#     classarr = inputdata(n)
#     classheapq = []
#     heapq.heappush(classheapq, classarr[0][1])
    
#     for i in range(1, n):
#         if classheapq[i][1] >= classheapq[i-1][1]:
#             heapq.heappush(classheapq[i][1])
#         else:
#             heapq.heappop(classheapq)
#             heapq.heappush(classheapq, classheapq[i][1])
            
#     return len(classheapq)


# print(solution())
