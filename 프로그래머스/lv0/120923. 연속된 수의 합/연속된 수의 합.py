def solution(num, total):
    mid = total // num
    result = [mid]
    
    for i in range((num - 1) // 2):
        result.append(mid - (i + 1))
    for i in range((num - 1) // 2):
        result.append(mid + i + 1)
    
    if len(result) < num:
        result.append(total - sum(result))
    
    return sorted(result)

print(solution(4, 14))