price = int(input())
money = 1000-price
changeMoney = [500,100,50,10,5,1]
count = 0
for i in range(0,len(changeMoney)):
    count += money // changeMoney[i]
    money %= changeMoney[i]

print(count)