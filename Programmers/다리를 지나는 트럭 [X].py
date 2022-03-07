# #3번째 시도 O
def solution(bridge_length, weight, truck_weights):
    current_BT = [0] * bridge_length       
    current_BW = 0
    answer = 0
    
    while len(current_BT):
        answer+=1
        leftout = current_BT.pop(0)       
        current_BW-=leftout
        if truck_weights:
            if current_BW + truck_weights[0]  <= weight:
                current_BW+= truck_weights[0]
                current_BT.append(truck_weights.pop(0))
            else:
                current_BT.append(0)
    return answer
print(solution(2,10,[7,4,5,6]))


# 2번째 시도 X
# from collections import deque
# def solution(bridge_length, weight, truck_weights):
#     current_BT = [0] * bridge_length       
#     answer = 0
    
#     while len(current_BT):
#         answer+=1
#         current_BT.pop(0)       
#         if truck_weights:
#             if sum(current_BT) + truck_weights[0]  <= weight:
#                 current_BT.append(truck_weights.pop(0))
#             else:
#                 current_BT.append(0)
#     return answer
# print(solution(2,10,[7,4,5,6]))

# 테스트케이스 5번에서 시간초과가 발생하였는데 sum 내장함수 때문인 것 같다..
# sum을 이용하지 않고 빠르게 다리위의 트럭들 무게를 구할 수 있는 방법은???

# 1번째 시도 X
# def solution(bridge_length, weight, truck_weights):
#     current_BT = [] 
#     for _ in range(bridge_length): 
#         current_BT.append(0)
#     answer = 0
    
#     while len(current_BT) != 0:       
#         if sum(current_BT) + truck_weights[0]  > weight:
#             current_BT.append(0)
#             del current_BT[0]
#             answer+=1 
            
#         else : 
#             current_BT.append(truck_weights[0])
#             del current_BT[0]
#             answer+=1 
#             while len(truck_weights) == 0:
#                 del current_BT[0]
#                 answer+=1 
#                 if len(current_BT) == 0:
#                     break
#     return answer
# print(solution(2,10,[7,4,5,6]))
# 문법 오류...