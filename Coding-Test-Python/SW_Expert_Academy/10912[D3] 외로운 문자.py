T = int(input())
for test_case in range(1, T + 1):
    word = list(input())
    uniqueWord = set(word)
    dictWord = dict()
    result = []
    while uniqueWord:
        p = uniqueWord.pop()
        dictWord[p] = 0

    for i in word:
        dictWord[i] += 1

    while dictWord:
        k, v = dictWord.popitem()
        if v % 2 == 1 and k is not None:
            result.append(k)

    if len(result) == 0:
        result.append('Good')
    result.sort()

    print("#{} {}".format(test_case, ''.join(result)))