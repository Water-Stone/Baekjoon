import math

def solution(n, stations, w):
    blank_start = 1
    blank_end = 0
    result = 0
    for pos in stations:
        blank_end = pos - w - 1
        blank_length = blank_end - blank_start + 1
        
        if blank_end >= 1 and blank_length > 0:
            result += math.ceil(blank_length / (w * 2 + 1))
        
        blank_start = pos + w + 1
    else:
        if blank_start <= n:
            result += math.ceil((n - blank_start + 1) / (w * 2 + 1))
    
    return result