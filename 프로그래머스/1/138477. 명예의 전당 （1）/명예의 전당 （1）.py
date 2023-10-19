def solution(k, score):
    hall = []
    result = []
    
    for s in score:
        if len(hall) < k:
            hall.append(s)
        else:
            hall[0] = max(hall[0], s)
        hall.sort()
        result.append(hall[0])
    
    return result