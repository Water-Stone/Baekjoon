def solution(numer1, denom1, numer2, denom2):
    ja = (numer1 * denom2) + (numer2 * denom1)
    mo = denom1 * denom2
    
    for i in range(min(ja, mo), 0, -1):
        if ja % i == 0 and mo % i == 0:
            ja /= i
            mo /= i
            break
    
    return [int(ja), int(mo)]