T = int(input())
for test_case in range(1, T + 1):
    _testcase=int(input())
    array=list(map(int,input().split()))
    _max = 0

    for value in range(101):
        if array.count(value) ==0:
            continue
        elif array.count(value) >= array.count(_max):
            _max=value

    print("#{} {}".format(_testcase, _max))