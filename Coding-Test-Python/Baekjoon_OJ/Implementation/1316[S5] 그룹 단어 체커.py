n = int(input())
count = n
for i in range(n):
    text = input()
    for j in range(0, len(text)-1):
        if(text[j] == text[j+1]):
            continue
        elif(text[j] in text[j+1:]):
            count-=1
            break
print(count)