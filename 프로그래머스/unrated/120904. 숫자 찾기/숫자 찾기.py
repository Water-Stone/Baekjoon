def solution(num, k):
    r = str(num).find(str(k))
    return r + 1 if r != -1 else -1