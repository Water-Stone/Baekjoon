def solution(numbers, target):
    result = [0]
    
    def rec(cnt, value, result):
        if len(numbers) == cnt:
            if value == target:
                result[0] += 1
            return None
        rec(cnt + 1, value + numbers[cnt], result)
        rec(cnt + 1, value - numbers[cnt], result)
    
    rec(0, 0, result)
    
    return result[0]
    
        