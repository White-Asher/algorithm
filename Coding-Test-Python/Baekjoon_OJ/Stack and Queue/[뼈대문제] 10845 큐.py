import sys
command_count = int(sys.stdin.readline())
count = 0
queue_area = list()

while count != command_count:
    count += 1
    command_comment = sys.stdin.readline().split()

    if command_comment[0] == 'pop':
        if (len(queue_area) == 0):
            print(-1)
            continue
        else:
            print(queue_area.pop(0))
            continue

    elif command_comment[0] == 'size':
        print(len(queue_area))
    
    elif command_comment[0] == 'empty':
        if(len(queue_area) == 0):
            print(1)
        else:
            print(0)

    elif command_comment[0] == 'front':
        if(len(queue_area) == 0):
            print(-1)
        else:
            print(queue_area[0])

    elif command_comment[0] == 'back':
        if(len(queue_area) == 0):
            print(-1)
        else:
            print(queue_area[-1])

    if command_comment[0] == "push":
        queue_area.append(int(command_comment[1]))
        continue