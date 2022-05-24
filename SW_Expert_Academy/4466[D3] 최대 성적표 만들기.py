t = int(input())
for tc in range(1, t+1):
    n, k = map(int, input().split())
    grade = list(map(int, input().split()))
    grade.sort(reverse=True)
    sumGrade = 0
    for i in range(k):
        sumGrade += grade[i]

    print("#{} {}".format(tc, sumGrade))