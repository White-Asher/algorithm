## 코딩테스트 파이썬 템플릿 코드

## 입출력가속 (백준에서 풀 때)
import sys 
N = int(sys.stdin.readline())
sys.stdout.write(N)

## 나누어 입력받기 // 입력:1 2
a, b = map(int, input().split())

## 배열입력
# 3
# 1 2 3
# 4 5 6
# 7 8 9
# Good Code
MAP = [list(map(int, input().split())) for _ in range(int(input()))]

# Bad Code
# n = int(input())
# for i in range(n):
#     [list(map(int,input().split()))]

## 정수와 배열이 같은 줄에 들어오는 경우 
# (한 줄에는 수의 개수 n 가 주어지고, 다음에는 n개의 수가 주어진다)
# 4 10 20 30 40
# 3 7 5 12
# 3 125 15 25
# N, *arr = map(int, input().split())

## 문자열을 한 글자씩 배열에 저장
# 3    
# AAAA 
# ABCA 
# AAAA 
arr = [list(input()) for _ in range(N)]

## 문자열 거꾸로 뒤집기
alph = "ABCD"
alph[::-1]

## 배열을 연결해서 출력 
# arr = [1, 2, 3, 4] => 1234
arr = [1, 2, 3, 4] 
print("".join(map(str, arr)))

## 배열 출력
# arr = [1, 2, 3, 4] -> 1 2 3 4
print(*arr)

## 배열 초기화 // 입력:3 5
N, M = map(int, input().split())
arr = [[0] * N for _ in range(M)]

## 배열에 찾고자 하는 원소 개수
# list.count(찾고자 하는 값)

## 문자열에 찾고자 하는 문자열의 개수
# str.count(찾는 값)

## 1차원 리스트 원소 중복 제거
alpha = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'a', 'b', 'c', 'd' ] 
alpha = list(set(alpha)) 

## 2차원 리스트 원소 중복 제거
lst = [[1,2], [1,2], [1]] 
print(list(set(map(tuple, lst))))

## 배열의 원소가 한개가 아닌 리스트일때 정렬하는 방법 (오름차순)/내림차순시 -x[0] -를 붙임
arr.sort(key=lambda x:(x[0], x[1]))

## 파이썬 삼항연산자
# [True 조건] if 조건 else [False 조건]
res = a if a > b else b

## 조합
from itertools import combinations  
print(list(combinations([1, 2, 3, 4], 3)))

print("{:.6f}".format(40.123456789))
40.123457