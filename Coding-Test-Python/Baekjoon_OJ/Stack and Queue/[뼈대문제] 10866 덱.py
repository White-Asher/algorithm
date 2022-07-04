import sys
from collections import deque
command_count = int(sys.stdin.readline())
count = 0
deque_area = deque()

while count != command_count:
    count += 1
    command_comment = sys.stdin.readline().split()

    if(command_comment[0] == 'push_front'):
        deque_area.appendleft(command_comment[1])
    
    elif(command_comment[0] == 'push_back'):
        deque_area.append(command_comment[1])

    elif(command_comment[0] == 'pop_front'):
        if(len(deque_area) == 0):
            print(-1)
        else:
            result = deque_area.popleft()
            print(result)

    elif(command_comment[0] == 'pop_back'):
        if(len(deque_area) == 0):
            print(-1)
        else:
            result = deque_area.pop()
            print(result)        
    
    elif(command_comment[0] == 'size'):
        print(len(deque_area))

    elif(command_comment[0] == 'empty'):
        if(len(deque_area) == 0):
            print(1)
        else:
            print(0)

    elif(command_comment[0] == 'front'):
        if(len(deque_area) == 0):
            print(-1)
        else:
            print(deque_area[0])

    elif(command_comment[0] == 'back'):
        if(len(deque_area) == 0):
            print(-1)
        else:
            print(deque_area[-1])