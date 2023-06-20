def solution(t, p):
    pl = len(p)
    ip = int(p)
    cnt = 0
    for i in range(len(t) - pl + 1):
        if int(t[i:i+pl]) <= ip:
            cnt += 1
    return cnt