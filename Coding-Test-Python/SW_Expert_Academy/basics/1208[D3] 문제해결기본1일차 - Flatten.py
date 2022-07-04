T = 10
for test_case in range(1, T + 1):
    count = int(input())
    width = list(map(int , input().split()))
    result = 0
    for i in range(count):
        maxIndex = width.index(max(width))
        minIndex = width.index(min(width))

        width[maxIndex]=width[maxIndex] - 1
        width[minIndex]=width[minIndex] + 1

    result = max(width) - min(width)
    print("#{} {}".format(test_case, result))