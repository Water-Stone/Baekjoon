def solution(n, m):
    for i in range(min(n, m) + 1, 0, -1):
        if max(n, m) % i == 0 and min(n, m) % i == 0:
            return [i, n * m / i]
    return -1