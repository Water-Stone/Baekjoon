def solution(s):
    r = 0
    for c in s:
        try:
            r += int(c)
        except:
            continue
    return r