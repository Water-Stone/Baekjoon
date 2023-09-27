def solution(intStrs, k, s, l):
    result = []
    for t in intStrs:
        v = int(t[s:s+l])
        if v > k:
            result.append(v)
    return result