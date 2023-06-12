def solution(s):
    if 'x' not in s:
        return len(s)
    
    return [len(elem) for elem in s.split('x')]