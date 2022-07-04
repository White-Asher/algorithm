t = int(input())
for tc in range(1, t+1):
    str_list = []
    for i in range(int(input())):
        a, b = input().split()
        str_list.append(a * int(b))
        strjoin = ''.join(str_list)
    print("#{}".format(tc))
    for i in range(0, len(strjoin), 10):
        print(strjoin[i:i+10])