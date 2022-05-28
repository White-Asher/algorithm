arr = [[2,3],[1,2],[0,4]]
arr.sort(key=lambda x:x[0]) # 첫번째 열 기준으로 정렬
print(arr)
# [[0, 4], [1, 2], [2, 3]]

arr = [[2,3],[1,2],[0,4]]
arr.sort(key=lambda x: -x[0])
print(arr)
# [[2, 3], [1, 2], [0, 4]]

arr = [[2,3],[1,2],[0,4]]
arr.sort(key=lambda x:x[1])
print(arr)
# [[1, 2], [2, 3], [0, 4]]

arr = [[2,3],[1,2],[0,4]]
arr.sort(key=lambda x:-x[1])
print(arr)
# [[0, 4], [2, 3], [1, 2]]

arr = [[2, 3], [1, 2], [0, 4], [2, 2]]
arr.sort(key=lambda x: (x[1], x[0]))
print(arr)
# [[1, 2], [2, 2], [2, 3], [0, 4]]