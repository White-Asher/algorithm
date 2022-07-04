# 제출 답안
w, h = map(int,input().split()) 
total = w*2 + h*2
num = int(input()) 
dist_list = [] 
new_list = []
result = 0
def dire_check(dire, dist):
    if dire == 1:
        return dist
    elif dire == 3:
        return w*2 + h*2 - dist
    elif dire == 2:
        return w*2 + h - dist
    elif dire == 4:
        return w + dist

for _ in range(num+1):
    dire,dist = map(int,input().split())
    new_dist = dire_check(dire,dist)
    dist_list.append(new_dist)

    
for i in range(num):
    dist_diff = abs(dist_list[i] - dist_list[num])
    result += min(dist_diff , total - dist_diff)

print(result)


# 답안
# w, h = map(int,input().split()) # 전체 블록 가로 길이, 세로 길이 
# num = int(input()) # 상점 개수 입력
# dist_list=[] # 상점의 위치를 저장할 리스트 만들어 놓기

# # 북쪽 왼쪽 모서리를 0을 기준으로 북 동 남 서 면을 펼처 
# # 기준점에서얼마나 떨어졌는 지 위치를 계산해주는 함수
# def new_dist(dire, dist) :
#     if dire == 1 : 
#         return dist
#     elif dire == 4 : 
#         return w+dist
#     elif dire == 2 : 
#         return w+h+w-dist
#     elif dire == 3 :
#         return w+h+w+h-dist

# for i in range(num+1) :
#     dire, dist = map(int, input().split())
#     dist_list.append(new_dist(dire, dist))

# #동근이의 0에서 부터 떨어진 위치를 저장
# dong_dist = dist_list[-1]
# result=0
# for i in range(num):
#     # 기준점 0에서 각 가게 사이의 거리, 기준점 0과 동근의 위치 차이의 절댓값을 구함
#     cal_dist = abs(dist_list[i] - dong_dist)

#     # 블럭 둘레의 길이
#     total=2*(w+h)

#     #더 작은 값을 result에 누적시킨다.
#     result+=min(cal_dist,total-cal_dist)

# print(result)
