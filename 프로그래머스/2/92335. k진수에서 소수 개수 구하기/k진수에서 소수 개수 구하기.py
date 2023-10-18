import string
import re


def convert(num, base) :
    tmp = string.digits + string.ascii_lowercase
    q, r = divmod(num, base)
    if q == 0:
        return tmp[r] 
    else:
        return convert(q, base) + tmp[r]

def isPrime(n):
    if n == 1:
        return False
    for i in range(2, int(n ** (0.5)) + 1):
        if not n % i:
            return False
    return True

# def isNotPrime(n):
#     return 2 not in [n, 2**n%n]
    
def solution(n, k):
    result = 0
    num = convert(n, k)
    p = re.compile(r'0?([1-9]*)0?')
    
    matches = p.findall(num)
    for match in matches:
        if match == '':
            continue
        # if not isNotPrime(int(match)):
        if isPrime(int(match)):
            result += 1
    return result