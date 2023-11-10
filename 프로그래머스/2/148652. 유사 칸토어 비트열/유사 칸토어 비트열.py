def solution(n, l, r):
    def check(v):
        if v < 5 and v != 2: return True
        if not (v - 2) % 5: return False
        return check(v // 5)
    
    result = 0
    for i in range(l - 1, r):
        if check(i): result += 1
    return result