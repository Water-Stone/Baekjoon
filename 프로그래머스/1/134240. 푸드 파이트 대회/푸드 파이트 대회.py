def solution(food):
    result = ''
    
    food = food[1:]
    
    for i, f in enumerate(food):
        for _ in range(f // 2):
            result += str(i + 1)
    
    result += '0'
    result += result[::-1][1:]
    
    return result