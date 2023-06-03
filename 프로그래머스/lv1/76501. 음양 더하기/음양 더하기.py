def solution(absolutes, signs):
    return sum(num if signs[i] else num * (-1) for i, num in enumerate(absolutes))