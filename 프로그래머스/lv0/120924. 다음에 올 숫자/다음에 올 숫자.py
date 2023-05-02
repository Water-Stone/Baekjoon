def solution(common):
    if common[2] == common[1] + (common[1] - common[0]):
        return common[len(common) - 1] + (common[1] - common[0])
    return common[len(common) - 1] * int(common[1] / common[0])