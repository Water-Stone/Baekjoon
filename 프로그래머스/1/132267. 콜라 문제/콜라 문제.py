def solution(a, b, n):
    result = 0
    
    while n >= a:
        d, m = divmod(n, a)
        result += d * b
        n = d * b + m
    
    return result