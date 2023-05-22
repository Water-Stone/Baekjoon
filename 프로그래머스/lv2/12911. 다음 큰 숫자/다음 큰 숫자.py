def solution(n):
    cnt1 = str(bin(n))[2:].count('1')
    for d in range(n + 1, 1000002):
        if cnt1 == str(bin(d))[2:].count('1'):
            return d