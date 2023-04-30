N = int(input())
pointList = []
for i in range(N):
    p = list(input().split())
    for j in range(2):
        p[j] = int(p[j])
    pointList.append(p)

pointList.sort(key = lambda p: (p[0], p[1]))

for i in range(N):
    print(f'{pointList[i][0]} {pointList[i][1]}')