def binstr(n, v):
    tmp = str(bin(v))[2:]
    if len(tmp) < n:
        return '0' * (n - len(tmp)) + tmp
    return tmp

def solution(n, arr1, arr2):
    m1 = [list(map(int, binstr(n, arr1[i]))) for i in range(n)]
    m2 = [list(map(int, binstr(n, arr2[i]))) for i in range(n)]
    
    return [''.join(['#' if m1[j][i] or m2[j][i] else ' ' for i in range(n)]) for j in range(n)]