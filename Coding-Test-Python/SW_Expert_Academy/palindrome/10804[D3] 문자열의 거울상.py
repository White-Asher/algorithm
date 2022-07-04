t = int(input())
for tc in range(1, t+1):
    string = list(input())
    newString = []
    for i in string:
        if i == 'b':
            newString.append('d')
        elif i == 'd':
            newString.append('b')
        elif i == 'p':
            newString.append('q')
        elif i == 'q':
            newString.append('p')

    print("#{} {}".format(tc, ''.join(newString[::-1])))