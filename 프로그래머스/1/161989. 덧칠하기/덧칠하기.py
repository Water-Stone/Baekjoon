def solution(n, m, section):
    result = 0
    l = -100001
    for v in section:
        if l < v:
            result += 1
            l = v + m - 1
    return result