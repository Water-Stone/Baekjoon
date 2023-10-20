def solution(k, d):
    result = 0
    
    for x in range(0, d + 1, k):
        y_limit = (d * d - x * x) ** (0.5)
        result += y_limit // k + 1
    
    return result