print("# 리스트 선언")
tlist = ['가', '나', '다', '라', '마']
print("# 리스트 원소 추가")
tlist.append('바')
print(tlist)

print("# 리스트 전부 제거")
tlist.clear()
print(tlist)

print("# 리스트 특정 원소 숫자 세기")
tlist = ['가', '나', '다', '라', '마', '바', '바']
print(tlist)
print(tlist.count('바'))

print("# 리스트를 원소 끝에 추가하기 ")
tlist2 = ['아', '자', '차', '카']
tlist.extend(tlist2)
print(tlist)

print("# 특정 원소의 인덱스 번호 찾기")
print(tlist.index('아'))

print("# 특정 인덱스에 값 추가하기")
tlist.insert(3,'삼식이')
print(tlist)

print("# 리스트 pop 하기(맨 왼쪽 원소를)")
tlist.pop()
print(tlist)

print("# 리스트 5번째 인덱스를 pop하기")
tlist.pop(5)
print(tlist)

print("# 리스트에 차 원소를 제거하기")
tlist.remove('차')
print(tlist)

print("# 리스트를 거꾸로 뒤집기")
tlist.reverse()
print(tlist)

print(tlist[::-1])

print("리스트를 정렬하기(오름차순)")
tlist.sort()
print(tlist)

print("리스트를 정렬하기(내림차순)")
tlist.sort(reverse=True)
print(tlist)

print("리스트의 특정 인덱스를 찾아 제거하기")
del tlist[6]
print(tlist)

print("리스트의 특정 인덱스 범위를 찾아 제거하기")
del tlist[2:6]
print(tlist)

del tlist[2:]
print(tlist)
