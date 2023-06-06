def solution(tri):
    tri = [[0] + lv + [0] for lv in tri]
    for i in range(1, len(tri)):
        for j in range(1, i + 2):
            tri[i][j] += max(tri[i-1][j-1], tri[i-1][j])
    return max(tri[-1])
    