def solution(l):
    def m(lst):
        r = 1
        for n in lst:
            r *= n
        return r
    
    return 1 if sum(l) ** 2 > m(l) else 0