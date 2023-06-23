import sys

N = int(sys.stdin.readline())
l = []
lapp = l.append
for _ in range(N):
    n = int(sys.stdin.readline())
    lapp(n)
l.sort()
print('\n'.join(map(str, l)))