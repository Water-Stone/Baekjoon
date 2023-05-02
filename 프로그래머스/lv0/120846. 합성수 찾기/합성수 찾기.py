def solution(n):
    primes = [2, 3, 5, 7, 11, 13, 17, 19,\
            23, 29, 31, 37, 41, 43, 47, 53,\
            59, 61, 67, 71, 73, 79, 83, 89, 97]
    cnt = 0
    for i in range(4, n + 1):
        if not (i in primes):
            cnt += 1
    return cnt