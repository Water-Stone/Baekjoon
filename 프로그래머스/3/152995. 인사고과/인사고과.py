def solution(scores):
    W, P = scores[0]
    cleared_scores = scores[1:]
    pivot, rank = 0, 1
    
    for w, p in sorted(cleared_scores, key=lambda x: (-x[0], x[1])):
        if W < w and P < p:
            return -1
        
        if pivot <= p:
            pivot = p
            if W + P < w + p:
                rank += 1
    
    return rank