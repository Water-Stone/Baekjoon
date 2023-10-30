def solution(code):
    mode = False
    result = ''
    
    for i, c in enumerate(code):
        if c == '1':
            mode = not mode
            continue
        if mode and i % 2:
            result += c
        elif not mode and not i % 2:
            result += c
    
    return result if result else 'EMPTY'