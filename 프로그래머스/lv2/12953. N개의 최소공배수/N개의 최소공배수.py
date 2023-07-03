import math

def prime_factorization(n):
    factors = {}
    while n % 2 == 0:
        factors[2] = factors.get(2, 0) + 1
        n //= 2
    for i in range(3, int(math.sqrt(n)) + 1, 2):
        while n % i == 0:
            factors[i] = factors.get(i, 0) + 1
            n //= i
    if n > 2:
        factors[n] = factors.get(n, 0) + 1
    return factors

def solution(arr):
    lcm_factors = {}
    for num in arr:
        factors = prime_factorization(num)
        for factor, count in factors.items():
            lcm_factors[factor] = max(lcm_factors.get(factor, 0), count)
    
    result = 1
    for factor, count in lcm_factors.items():
        result *= factor ** count
    
    return result
