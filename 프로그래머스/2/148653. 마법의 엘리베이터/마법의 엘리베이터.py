def solution(s):
    result = 0
    s = list(map(int, str(s)))
    while s:
        f = s.pop()
        if (f == 5 and ((s and s[-1] < 5) or not s)) or f < 5:
            result += f
        else:
            result += (10 - f)
            if s:
                s[-1] += 1
            else:
                result += 1
    
    return result