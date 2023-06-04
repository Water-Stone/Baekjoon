def get_num_divisors(n, limit, power):
    cnt = 0
    for i in range(1, int(n ** (1 / 2)) + 1):
        if n % i == 0:
            cnt += 1
            if i**2 != n:
                cnt += 1
            if cnt > limit:
                cnt = power
                break
    return cnt
    
def solution(number, limit, power):
    return sum(get_num_divisors(n, limit, power) for n in range(1, number + 1))