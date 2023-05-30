import sys
MAX_DIS = 800000001


class Dot:
    def __init__(self, _x, _y):
        self.x = _x
        self.y = _y

    def getDistance(self, other):
        # 거리의 제곱을 출력해야하므로 루트 씌워주지 않는다.
        return abs(self.x - other.x) ** 2 + abs(self.y - other.y) ** 2


n = int(input())
dots = []
for _ in range(n):
    x, y = map(int, sys.stdin.readline().split())
    dots.append(Dot(x, y))
dots = sorted(dots, key=lambda dot: dot.x)


def bruteForce(start, end):
    tmp = MAX_DIS
    for i in range(start, end + 1):
        for j in range(i + 1, end + 1):
            tmp = min(tmp, dots[i].getDistance(dots[j]))
    return tmp


def solution(start, end):
    if start == end:
        return MAX_DIS

    if end - start <= 2:
        return bruteForce(start, end)

    mid = (start + end) // 2
    min_dist = min(solution(start, mid - 1), solution(mid + 1, end))

    candidates = []
    for i in range(start, end+1):
        if (dots[mid].x - dots[i].x) ** 2 < min_dist:
            candidates.append(dots[i])

    candidates.sort(key=lambda dot: dot.y)

    for i in range(len(candidates) - 1):
        for j in range(i + 1, len(candidates)):
            if (candidates[i].y - candidates[j].y) ** 2 < min_dist:
                min_dist = min(
                    min_dist, candidates[i].getDistance(candidates[j]))
            else:
                break

    return min_dist


print(solution(0, n - 1))
