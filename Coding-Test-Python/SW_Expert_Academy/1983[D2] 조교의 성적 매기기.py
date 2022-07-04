T = int(input())
grade_al = ['A+','A0','A-','B+','B0','B-','C+','C0','C-','D0']
for test_case in range(1, T + 1):
    n , k = map(int,input().split())
    grade = []
    for i in range(n):
        a,b,c = map(int,input().split())
        result = a*0.35 + b*0.45 + c*0.2
        grade.append(result)
    
    k_score = grade[k-1]
    grade.sort(reverse=True)
    a = grade.index(k_score)//(n//10)
    
    print("#{} {}".format(test_case, grade_al[a]))