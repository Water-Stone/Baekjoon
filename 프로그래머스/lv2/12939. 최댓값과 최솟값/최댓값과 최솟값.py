def solution(s):
    return f"{min(map(int, s.split(' ')))} {max(map(int, s.split(' ')))}"