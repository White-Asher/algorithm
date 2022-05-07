import sys
input = sys.stdin.readline

m = int(input())
s = set()
for i in range(m):
    li = input().split()

    if len(li) == 1:
        if li[0] == 'all':
            s = set([i for i in range(1, 21)])
        else:
            s = set()
        continue

    else:
        b = int(li[1])

        if li[0] == 'add':
            if b not in s:
                s.add(b)
        elif li[0] == 'remove':
            s.discard(b)
        elif li[0] == 'check':
            if b in s:
                print(1)
            else:
                print(0)
        elif li[0] == 'toggle':
            if b in s:
                s.discard(b)
            elif b not in s:
                s.add(b)



# import sys
#
# m = int(sys.stdin.readline())
# S = set()
#
# for _ in range(m):
#     temp = sys.stdin.readline().strip().split()
#
#     if len(temp) == 1:
#         if temp[0] == "all":
#             S = set([i for i in range(1, 21)])
#         else:
#             S = set()
#
#     else:
#         func, x = temp[0], temp[1]
#         x = int(x)
#
#         if func == "add":
#             S.add(x)
#         elif func == "remove":
#             S.discard(x)
#         elif func == "check":
#             print(1 if x in S else 0)
#         elif func == "toggle":
#             if x in S:
#                 S.discard(x)
#             else:
#                 S.add(x)