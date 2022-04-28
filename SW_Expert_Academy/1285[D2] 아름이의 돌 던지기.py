T = int(input())
for test_case in range(1, T + 1):
    n = int(input())
    rock = list(map(int,input().split()))
    abc_rock = []
    
    for i in rock:
        abc_rock.append(abs(i))

    minrock = min(abc_rock)
    rocker = abc_rock.count(minrock)
    
    print("#{} {} {}".format(test_case,minrock,rocker))