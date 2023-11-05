def solution(wallpaper):
    lux, luy, rdx, rdy = 51, 51, -1, -1
    
    for x, line in enumerate(wallpaper):
        for y, ch in enumerate(line):
            if ch == '#':
                lux, luy = min(lux, x), min(luy, y)
                rdx, rdy = max(rdx, x + 1), max(rdy, y + 1)
    
    return [lux, luy, rdx, rdy]