def solution(s):
    result = []
    for c in s:
        try:
            result.append(int(c))
        except:
            continue
    return sorted(result)