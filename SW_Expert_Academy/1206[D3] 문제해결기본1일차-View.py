# 수정후제출답안
for test_case in range(1,11):
    result = 0
    houseCount = int(input())
    house = list(map(int , input().split()))
    for i in range(2, houseCount-2):
        def_2 = house[i] - house[i-2]
        def_1 = house[i] - house[i-1]
        def1 = house[i] - house[i+1]
        def2 = house[i] - house[i+2]
        if def_2 > 0 and def_1 > 0 and def1 > 0 and def2 > 0 :
            result += min(def_2, def_1, def1, def2)

    print("#{} {}".format(test_case,result))
    
    
for test_case in range(1,11):
    result = 0
    houseCount = int(input())
    house = list(map(int , input().split()))
    for i in range(2, houseCount-2):
        arMax = max(house[i-1],house[i-2],house[i+1],house[i+2])
        if house[i] > arMax:
            result += ( house[i] - arMax )

    print("#{} {}".format(test_case,result))