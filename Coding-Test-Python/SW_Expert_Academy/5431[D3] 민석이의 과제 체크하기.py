t = int(input())
for tc in range(1, t+1):
    n, m = map(int, input().split())
    n_list = []
    for i in range(1,n+1):
        n_list.append(i)

    m_list = list(map( int,input().split()))

    for i in m_list:
        n_list.remove(i)
    print("#{}".format(tc), end= ' ')
    print(*n_list)