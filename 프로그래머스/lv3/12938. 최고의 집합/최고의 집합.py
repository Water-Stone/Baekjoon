def solution(n, s):
    if s < n:
        return [-1]
    
    q, r = divmod(s, n)
    
    result = []
    for _ in range(n):
        if r > 0:
            r -= 1
            result.append(q + 1)
        else:
            result.append(q)
    return sorted(result)