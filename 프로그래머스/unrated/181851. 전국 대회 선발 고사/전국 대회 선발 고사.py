def solution(rank, attendance):
    answer = 0
    cnt = 0
    
    for r in sorted(rank):
        idx = rank.index(r)
        if attendance[idx]:
            if cnt == 0:
                answer += 10000 * idx
                cnt += 1
            elif cnt == 1:
                answer += 100 * idx
                cnt += 1
            elif cnt == 2:
                answer += idx
                cnt += 1
            else:
                break
            
    
    return answer