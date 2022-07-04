n = int(input())
for i in range(1, n+1):
    count = 0
    istr_list = list(str(i))
    for j in istr_list:
        if j == '3' or j == '6' or j == '9':
            count += 1
    if count == 0:
        print(i, end=' ')
    else:
        print('-'*count, end=' ')