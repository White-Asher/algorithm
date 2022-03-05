import queue
def solution(bridge_length, weight, truck_weights):
    current_BW = 0 # 다리현재 무게
    current_BT = 0 # 다리에 있는 트럭들 개수
    bridge = queue.Queue() # 다리위에 트럭들이 어디에 있는지 큐로 나타냄
    # 큐의 크기에 맞춰 0 입력...
    for _ in range(bridge_length): 
        bridge.put(0)
    counter = 0
    
    while True:
        # 대기
        if (current_BW + truck_weights[0]) > weight or current_BT > bridge_length:
            counter+=1 
        
        elif current_BW <= weight and current_BT <= bridge_length:
            truck_weights[0]  
        
            
            truck_weights.pop()
        else:
            if (len(truck_weights) == 0 and bridge.qsize() == 0) == 1:
                break
    
    answer = 0
    return answer


print(solution(2,10,[7,4,5,6]))
