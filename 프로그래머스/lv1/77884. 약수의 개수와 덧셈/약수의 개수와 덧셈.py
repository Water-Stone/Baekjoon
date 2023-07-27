def cntDivisors(n):
    cnt = 0
    for i in range(1, int(n**(1/2)) + 1):
        if n % i == 0:
            cnt += 1
            if (i**2) != n: 
                cnt += 1
    return cnt

def solution(left, right):
    result = 0
    for num in range(left, right + 1):
        if cntDivisors(num) % 2:
            result -= num
        else:
            result += num
    return result