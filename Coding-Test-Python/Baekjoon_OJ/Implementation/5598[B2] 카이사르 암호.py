data = input()
data2 = []
for x in data:
    y = ord(x) - 3 
    if y <=64:
        y += 26
    z = chr(y)
    data2.append(z)

print(''.join(data2))