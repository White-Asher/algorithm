import time
from datetime import timedelta
start = time.process_time()

T = int(input())
for test_case in range(1, T + 1):
    num_set = set([])
    n = int(input())
    a = 1
    
    while True:
        temp = n * a
        input_num = list(map(int, str(int(temp))))
        a += 1
        for i in input_num:
            num_set.add(i)
            
        if len(num_set) == 10:
            break

    print("#{} {}".format(test_case, temp))


end = time.process_time()       
print("Time elapsed: ", end - start)  # seconds
print("Time elapsed: ", timedelta(seconds=end-start))

#입력
'''
5
1
2
11
1295
1692
'''
# 출력
#1 10
#2 90
#3 110
#4 6475
#5 5076

# 다른 풀이
T = int(input())

for test_case in range(1, T+1) :
    N = int(input())

    listA = [0]*10

    i = 0
    while(True) :
        if 0 not in listA :
            break
        else :
            i += 1
            num = str(N*i)
            for j in range(len(num)) :
                listA[int(num[j])] = 1


    print("#{} {}".format(test_case, num))