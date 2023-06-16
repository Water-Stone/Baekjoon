def solution(n):
    s = ''
    while n > 0:
        n, mod = divmod(n, 3)
        s += str(mod)
    
    return int(s, 3)