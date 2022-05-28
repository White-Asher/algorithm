T = int(input())
for test_case in range(1, T + 1):
    numlist = list(map(int, input().split()))
    numsum = []
    for i in range(len(numlist)):
        for j in range(i+1,len(numlist)):
            for k in range(j+1,len(numlist)):
                numsum.append(numlist[i]+numlist[j]+numlist[k])
    numsum = list(set(numsum))
    numsum.sort(reverse=True)
    print("#{} {}".format(test_case, numsum[4]))