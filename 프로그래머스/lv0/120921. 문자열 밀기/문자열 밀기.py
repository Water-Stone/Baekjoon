import collections

def solution(A, B):
    if A == B:
        return 0
    dq = collections.deque(A)
    for i in range(len(A)):
        dq.rotate(1)
        if ''.join(dq) == B:
            return i + 1
    return -1