for tc in range(1, 11):
    stack = []
    n, nums = input().split()
    nums = list(nums)

    for i in nums:
        if not stack:
            stack.append(i)
        else:
            if stack[-1] == i:
                stack.pop()
            else:
                stack.append(i)

    print("#{} {}".format(tc, ''.join(stack)))