def solution(arr):
    answer = []
    curv = -1
    for i, v in enumerate(arr):
        if v == curv:
            continue
        curv = v
        answer.append(v)
    return answer
        