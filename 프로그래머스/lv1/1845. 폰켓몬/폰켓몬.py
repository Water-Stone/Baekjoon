def solution(nums):
    limit = len(nums) // 2
    t = set(nums)
    
    if len(t) >= limit:
        return limit
    return len(t)