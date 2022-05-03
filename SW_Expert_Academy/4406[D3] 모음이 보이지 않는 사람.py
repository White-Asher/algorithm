t = int(input())
for tc in range(1, t+1):
    st = input()
    characters = "aeiou"
    st = ''.join(x for x in st if x not in characters)
    print("#{} {}".format(tc, st))