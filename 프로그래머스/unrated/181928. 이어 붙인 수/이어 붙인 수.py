def solution(numlist):
    a, b = '', ''
    for n in numlist:
        if n % 2:
            a += str(n)
        else:
            b += str(n)
    return int(a) + int(b)