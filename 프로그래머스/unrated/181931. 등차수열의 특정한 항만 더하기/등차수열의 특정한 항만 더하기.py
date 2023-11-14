def solution(a, d, included):
    return sum(a + d * i for i, b in enumerate(included) if b)