person, num = map(int,input().split())
entire_list = []
result = []
popNum = 0
for i in range(person):
    entire_list.append(i+1)

while len(entire_list) > 0 :
    popNum = (popNum + (num-1)) % len(entire_list)
    popElement = entire_list.pop(popNum)
    result.append(str(popElement))

print("<%s>" %(", ".join(result)))