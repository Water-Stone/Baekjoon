def solution(n):
    che = [True for _ in range(n + 1)]
    for i in range(2, int(n ** (0.5)) + 1):
        if che[i]:
            for j in range(2, n // i + 1):
                che[i * j] = False
    return che.count(True) - 2