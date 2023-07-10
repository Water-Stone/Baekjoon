def solution(routes):
    routes.sort(key= lambda x: x[0])
    
    result = 1
    cam = 30001
    for start, end in routes:
        if start > cam:
            cam = end
            result += 1
        cam = min(cam, end)
    
    return result