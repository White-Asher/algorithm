t = int(input())

def check():
    if cnt == len(temp):
        result = ''.join(temp)

for tc in range(1, t+1):
    n = int(input())
    num = list(map(int, input().split()))
    result = -1

    for i in range(len(num)-1, 0, -1):
        temp = list(str(num[i] * num[i-1]))
        cnt = 0
        for j in range(len(temp)-1):
            if temp[j] > temp[j+1]:
                break
            else:
                cnt+=1

    print("#{} {}".format(tc, result))