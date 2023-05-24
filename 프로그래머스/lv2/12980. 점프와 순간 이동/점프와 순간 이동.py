def solution(n):
    k = 0
    while n:
        if n % 2 == 0:
            n //= 2
        else:
            n -= 1
            k += 1
    return k