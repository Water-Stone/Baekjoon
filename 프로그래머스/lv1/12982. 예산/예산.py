def solution(d, budget):
    if sum(d) <= budget:
        return len(d)
    
    d.sort()
    cnt = 0
    for num in d:
        if budget < num:
            return cnt
        budget -= num
        cnt += 1
    return -1