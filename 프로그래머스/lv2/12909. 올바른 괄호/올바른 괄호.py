def solution(s):
    cnt = 0
    for i, c in enumerate(s):
        if c == '(':
            cnt += 1
        elif c == ')':
            if cnt == 0:
                return False
            cnt -= 1
    
    return cnt == 0