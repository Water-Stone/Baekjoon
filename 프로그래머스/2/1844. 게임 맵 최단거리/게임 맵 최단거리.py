from collections import deque


def solution(maps):
    class Position:
        def __init__(self, x, y, cnt):
            self.x = x
            self.y = y
            self.cnt = cnt
    
    q = deque()
    xdir = [0, 0, 1, -1]
    ydir = [1, -1, 0, 0]
    MAX_X, MAX_Y = len(maps[0]), len(maps)
    
    q.append(Position(0, 0, 1))
    maps[0][0] = 0
    
    while q:
        pos = q.popleft()
        pos.cnt += 1
        
        for i in range(4):
            x = pos.x + xdir[i]
            y = pos.y + ydir[i]
            
            if x < 0 or y < 0 or x >= MAX_X or y >= MAX_Y:
                continue
            elif maps[y][x] == 0:
                continue
            elif x == MAX_X - 1 and y == MAX_Y - 1:
                return pos.cnt
            else:
                q.append(Position(x, y, pos.cnt))
                maps[y][x] = 0
    
    return -1