s1 = set([1,2,3,4,5,6])
print("s1출력:",s1)

s2 = set([4,5,6,7,8,9])
print("s2출력:",s2)

print("# 교집합")
print(s1 & s2)

print("# 합집합")
print(s1 | s2)

print("# 차집합")
print(s1 - s2)

print("====")
s1 = set([1,2,3])
print("s1출력:",s1)

print("# 값 1개 추가하기")
s1.add(4)
print(s1)

print("# 값 여러개 추가하기")
s1.update([7,8,9])
print(s1)

print("# 특정 값 제거하기(값)")
s1.remove(8)
print(s1)

print("# pop하기")
s1.pop()
print(s1)