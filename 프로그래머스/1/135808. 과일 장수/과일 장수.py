def solution(k, m, score):
    score.sort(reverse=True)
    d = len(score) // m
    
    return sum(min(score[box * m: box * m + m]) * m for box in range(d))