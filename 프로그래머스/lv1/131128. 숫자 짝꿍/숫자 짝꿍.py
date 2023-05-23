def solution(x, y):
    sx, sy = map(str, (x, y))
    cnts = []
    
    for i in range(10):
        cnts.append(min(sx.count(f'{i}'), sy.count(f'{i}')))
    
    result = ''
    for i in range(9, -1, -1):
        result += f'{i}' * cnts[i]
    
    if result and result.count('0') == len(result):
        return '0'
    
    return result if result else '-1'