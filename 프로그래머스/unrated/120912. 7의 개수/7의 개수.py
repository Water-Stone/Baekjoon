def solution(array):
    cnt = 0
    for s in map(str, array):
        cnt += s.count('7')
    return cnt