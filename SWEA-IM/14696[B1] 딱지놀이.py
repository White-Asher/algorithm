n = int(input())
def who_win():
    an, *al = map(int, input().split())
    bn, *bl = map(int, input().split())
    al.sort()
    bl.sort()
    for i in range(4,0,-1):
        anum_count = al.count(i)
        bnum_count = bl.count(i)
        if anum_count > bnum_count:
            return "A"
        elif anum_count < bnum_count:
            return "B"
        elif anum_count == bnum_count:
            continue
    return "D"

for i in range(n):
    print(who_win())
    
# 좀 더 짧게
def win():
    a, *al = map(int, input().split())
    b, *bl = map(int, input().split())
    al.sort()
    bl.sort()
    for i in range(4,0,-1):
        ac = al.count(i)
        bc = bl.count(i)
        if ac > bc: 
            return "A"
        elif ac < bc:
            return "B"
        elif ac == bc:
            continue
    return "D"

for i in range(int(input())):
    print(win())