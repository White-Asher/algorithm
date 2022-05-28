t = int(input())
for tc in range(1, t+1):
    word = [list(input()) for _ in range(5)]

    maxLen = 0
    for w in word:
        if len(w) > maxLen:
            maxLen = len(w)

    nw = ''
    for i in range(maxLen):
        for j in range(5):
            if i < len(word[j]):
                nw += word[j][i]

    print("#{} {}".format(tc, nw))