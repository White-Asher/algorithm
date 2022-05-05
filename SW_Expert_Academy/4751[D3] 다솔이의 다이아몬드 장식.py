t = int(input())
for tc in range(1, t+1):
    li = [[]for _ in range(5)]

    l1 = ['..#.']
    l2 = ['.#.#']
    l3 = ['.']
    l4 = ['#']
    n = input()
    for i in n:
        li[0].append(l1)
        li[1].append(l2)
        li[2].append('#.'+str(i)+'.')
        li[3].append(l2)
        li[4].append(l1)
    li[0].append(l3)
    li[1].append(l3)
    li[2].append(l4)
    li[3].append(l3)
    li[4].append(l3)

    for i in range(5):
        for j in li[i]:
            print(''.join(j), end = '')
        print()

# 다른 풀이
for t in range(int(input())):
    word = input()

    first_line = '..#.'
    second_line = '.#.#'
    third_line = '#.'
    third_line_2 = '.'

    print(first_line * len(word) + '.')
    print(second_line * len(word) + '.')
    for i in range(len(word)):
        print(third_line + word[i] +  third_line_2, end="")
        if i == len(word) - 1:
            print('#')
    print(second_line * len(word) + '.')
    print(first_line * len(word) + '.')

# 또 다른 풀이
for tc in range(int(input())):
    word = input()
    a = '..#.'
    b = '.#.#'
    ab_last = '.'
    c1 = '#.'
    c2 = '.'
    c_last = '#'

    N = len(word)
    answer = ['']*5
    answer[0] += a*N + ab_last
    answer[1] += b*N + ab_last
    for w in word:
        answer[2] += c1 + w + c2
    answer[2] += c_last
    answer[3] += b*N + ab_last
    answer[4] += a*N + ab_last

    for rw in answer:
        print(rw)