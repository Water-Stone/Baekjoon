def solution(dirs):
    log = {}
    pos = (0, 0)
    result = 0
    
    for d in dirs:
        if d == 'U':
            next_pos = (pos[0], pos[1] + 1)
        elif d == 'D':
            next_pos = (pos[0], pos[1] - 1)
        elif d == 'R':
            next_pos = (pos[0] + 1, pos[1])
        elif d == 'L':
            next_pos = (pos[0] - 1, pos[1])
        
        if abs(next_pos[0]) > 5 or abs(next_pos[1]) > 5:
            continue
        
        if pos not in log:
            log[pos] = set()
        elif next_pos in log[pos]:
            result -= 1
            
        log[pos].add(next_pos)
        
        if next_pos not in log:
            log[next_pos] = set()
        log[next_pos].add(pos)
        
        result += 1
        pos = next_pos
    
    return result
        