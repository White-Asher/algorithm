dic = {'name': 'pey', 'phone': '0119993323', 'birth': '1118'}
print("# 딕셔너리에 값 추가")
dic['gender'] = 'Men'
print(dic)

print("# 딕셔너리에 값 제거")
del dic['phone']
print(dic)

print("# 딕셔너리에서 key 사용해 value 얻기")
print(dic['name'])
print(dic['birth'])

print("# 딕셔니리의 키값으로 리스트 객체 만들기")
print(dic.keys())

print("# 딕셔너리 키 값 출력")
for k in dic.keys():
    print(k)

print("# 딕셔너리의 value값으로 리스트 객체 만들기")
print(dic.values())

print("# key, value 쌍 얻기")
print(dic.items())

print("# key로 value 얻기")
print(dic.get('name'))
print(dic.get('birth'))

print("# 딕셔너리에 키 값 있는지 찾기")
print('name' in dic)

print("# key를 이용한 정렬")
dict = {'A' : 1, 'D' : 4, 'C' : 3, 'B' : 2}
print(dict)

print("# 키 값 기준으로 정렬하기(오름차순)")
sdict = sorted(dict.keys())
print(sdict)

print("# 키 값 기준으로 정렬하기(내림차순)")
sdict = sorted(dict.keys(), reverse=True)
print(sdict)

print("# value 값을 기준으로 정렬하기(오름차순)")
sdict = sorted(dict.values())
print(sdict)

print("# value 값을 기준으로 정렬하기(내림차순)")
sict = sorted(dict.values(), reverse=True)
print(sict)

print("# 키와 값 쌍 기준으로 정렬하기(오름차순)")
# items 를 사용할 경우 튜플 자료형으로 리턴한다
sdict = sorted(dict.items())
print(sdict)

print("# for문을 이용하여 키 값 쌍으로 출력")
for key, value in sdict:
    print(key, ":", value)

print("# 키와 값 쌍 기준으로 정렬하기(내림차순)")
# items 를 사용할 경우 튜플 자료형으로 리턴한다
sdict = sorted(dict.items(), reverse=True)
print(sdict)

print("# 람다식을 사용하여 내림차순 정렬방법")
sdict = sorted(dict.items(), key=lambda x: x[1], reverse=True)
print(sdict)

sdict = sorted(dict.items(), key=lambda x: -x[1],)
print(sdict)