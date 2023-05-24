def solution(brown, yellow):
    size = brown + yellow
    mid = size // 2
    for x in range(mid, 0, -1):
        if size % x == 0:
            y = size // x
            if x >= y:
                if (x - 2) * (y - 2) == yellow:
                    return [x, y]
    return []