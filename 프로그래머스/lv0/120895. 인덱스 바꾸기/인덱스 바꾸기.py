def solution(mys, n1, n2):
    if n1 > n2:
        n1, n2 = n2, n1
    
    return mys[:n1] + mys[n2] + mys[n1 + 1:n2] + mys[n1] + mys[n2 + 1:]