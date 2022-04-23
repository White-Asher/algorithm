# 내 풀이
w,h = map(int,input().split())
x,y = map(int,input().split())
t = int(input())

if ((x+t)//w) % 2 == 0:
    if ((x+t)%w) == 0:
        x = 0
    else:
        x = ((x+t)%w)
elif ((x+t)//w) % 2 == 1:
    if ((x+t)%w) == 0:
            x = w
    else:
        x = w-((x+t)%w)

if ((y+t)//h) % 2 == 0:
    if ((y+t)%h) == 0:
        y = 0
    else:
        y = ((y+t)%h)
elif ((y+t)//h) % 2 == 1:
    if ((y+t)%h) == 0:
            y = h
    else:
        y = h-((y+t)%h)
        
print(x,y)

# 다른 사람의 풀이
w, h = map(int, input().split())
p, q = map(int, input().split())
t = int(input())
s = p + t%(2*w)
if s > w:
    s = abs(2*w - s)
r = q + t%(2*h)
if r > h:
    r = abs(2*h - r)
print(s, r)