def solution(dots):
    slope1 = abs((dots[0][0] - dots[1][0]) / (dots[0][1] - dots[1][1]))
    slope2 = abs((dots[2][0] - dots[3][0]) / (dots[2][1] - dots[3][1]))
    
    if slope1 == slope2:
        return 1
    
    slope1 = abs((dots[0][0] - dots[2][0]) / (dots[0][1] - dots[2][1]))
    slope2 = abs((dots[1][0] - dots[3][0]) / (dots[1][1] - dots[3][1]))
    
    if slope1 == slope2:
        return 1
    
    slope1 = abs((dots[0][0] - dots[3][0]) / (dots[0][1] - dots[3][1]))
    slope2 = abs((dots[1][0] - dots[2][0]) / (dots[1][1] - dots[2][1]))
    
    if slope1 == slope2:
        return 1
    
    return 0