import sys
input = sys.stdin.readline

site_dict = {}

n, m = map(int, input().split())

for i in range(n):
    site, pw = input().split()
    site_dict[site] = pw

for j in range(m):
    print(site_dict[input().rstrip()])
