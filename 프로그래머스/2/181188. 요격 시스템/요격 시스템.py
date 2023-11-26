def solution(targets):
    targets.sort(key=lambda x: x[1])
    
    cnt, cur = 0, 0
    for start, end in targets:
        if cur <= start:
            cur = end
            cnt += 1
    
    return cnt