def isPrime(n):
    for i in range(2, int(n ** (0.5)) + 1):
        if not n % i:
            return 0
    return 1

def solution(nums):
    sums = []
    l = len(nums)
    for i in range(l - 2):
        for j in range(i + 1, l - 1):
            for k in range(j + 1, l):
                sums.append(nums[i] + nums[j] + nums[k])
    
    result = 0
    for s in sums:
        result += isPrime(s)
    return result