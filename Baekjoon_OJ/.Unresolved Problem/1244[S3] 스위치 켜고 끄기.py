sw_count = int(input())
sw = list(map(int,input().split()))

stu_count = []
for i in range(int(input())):
    stu_count.append(list(map(int,input().split())))
    
    if stu_count[i][0] == 1:
        sw_num = stu_count[i][1]
        for j in range(1, int(len(sw)/sw_num)+ 1):
            if sw[(j*sw_num)-1] == 1:
                sw[(j*sw_num)-1] = 0
            elif sw[(j*sw_num)-1] == 0:
                sw[(j*sw_num)-1] = 1
    
    elif stu_count[i][0] == 2:
        sw_num = stu_count[i][1]-1
        count = 0
        for k in range(1, int(len(sw)/2)):
            if sw_num-k <= -1 or sw_num+k > len(sw):
                break
            elif sw[sw_num-k] == sw[sw_num+k]:
                count+=1

        for q in range(count+1):
            if q == 0:
                if sw[sw_num] == 1:
                    sw[sw_num] = 0
                elif sw[sw_num] == 0:
                    sw[sw_num] = 1
                    
            elif q>=1 :
                if sw[sw_num+q] == 1:
                    sw[sw_num+q] = 0
                elif sw[sw_num+q] == 0:
                    sw[sw_num+q] = 1
                    
                if sw[sw_num-q] == 1:
                    sw[sw_num-q] = 0
                elif sw[sw_num-q] == 0:
                    sw[sw_num-q] = 1
                
print(*sw)