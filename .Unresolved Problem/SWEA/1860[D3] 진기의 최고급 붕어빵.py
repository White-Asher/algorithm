t = int(input())
def sol():
    bread = 0
    for i in range(n):
        bread = (human[i] // m) * k
        if bread < i + 1:
            return 'Impossible'
    return 'Possible'

for tc in range(1, t+1):
    n, m, k = map(int,input().split())
    human = list(map(int,input().split()))
    human.sort()
    result = sol()
    print("#{} {}".format(tc, result))