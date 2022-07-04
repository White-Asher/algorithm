import sys
command_count = int(sys.stdin.readline())
count = 0
stack_area = list()

while count != command_count:
    count += 1
    command_comment = sys.stdin.readline().split()

    if command_comment[0] == 'pop':
        if (len(stack_area) == 0):
            print(-1)
            continue
        else:
            print(stack_area.pop())
            continue

    elif command_comment[0] == 'size':
        print(len(stack_area))
    
    elif command_comment[0] == 'empty':
        if(len(stack_area) == 0):
            print(1)
        else:
            print(0)

    elif command_comment[0] == 'top':
        if(len(stack_area) == 0):
            print(-1)
        else:
            print(stack_area[-1])


    if command_comment[0] == "push":
        stack_area.append(int(command_comment[1]))
        continue

    