# n보다 같거나 작은 소수 리스트
def prime_list(n):
    # 체 초기화 : n개의 요소에 True 설정
    sieve = [True] * (n+1)
    
    m = int(n ** 0.5)
    for i in range(2, m + 1):
        if sieve[i] == True:  # i가 소수인 경우
            for j in range(i+i, n+1, i):  # i 이후 i의 배수를 False 판정
                sieve[j] = False
                
    # 소수 목록 return
    return [i for i in range(2, n+1) if sieve[i] == True]

N = int(input())
if N != 1:
    primeNumbers = prime_list(N)
    
    currN = N
    for p in primeNumbers:
        if p > currN: break
        while currN % p == 0:
            print(p)
            currN /= p