def solution(n, a, b):
    cnt = 1
    
    while True:
        if a % 2 != 0:
            if (a + 1) == b:
                return cnt
            a = (a + 1) // 2
        elif a % 2 == 0:
            if (a - 1) == b:
                return cnt
            a = a // 2
        b = (b + 1) // 2 if b % 2 != 0 else b // 2
        cnt += 1

    return cnt