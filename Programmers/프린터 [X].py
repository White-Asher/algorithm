# 작성한 코드
def solution(priorities, location):
    localist = [i for i in range(0, len(priorities))]
    count = 0
    while priorities:
        maximum = max(priorities)
        poppriorities = priorities.pop(0)
        if poppriorities < maximum:
            priorities.append(poppriorities)
            localist.append(localist.pop(0))
        else:
            count+=1
            delindex = localist.pop(0)
            if delindex == location:
                break
    return count
    
# 효율성이 좋은 코드
# def solution(priorities, location):
#     printer = [(i,p) for i, p in enumerate(priorities)]
#     count = 0
#     while printer:
#         job = printer.pop(0)
#         if any(job[1] < other_job[1] for other_job in printer):
#             printer.append(job)
#         else:
#             count+=1
#             if job[0] == location:
#                 break;
#     return count