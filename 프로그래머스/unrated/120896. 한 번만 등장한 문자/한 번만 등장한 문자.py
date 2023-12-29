from collections import Counter as cnt


def solution(s):
    return ''.join(sorted([x[0] for x in cnt(s).items() if x[1] == 1]))