def solution(n, lost, reserve):
    lset = set(lost)
    rset = set()
    reserve.sort()
    for r in reserve:
        if r in lost:
            lset.discard(r)
            continue
        
        if (r - 1) in lset:
            if r not in rset:
                lset.discard((r - 1))
                rset.add(r)
        elif (r + 1) in lset:
            if r not in rset:
                lset.discard((r + 1))
                rset.add(r)
    return n - len(lset)