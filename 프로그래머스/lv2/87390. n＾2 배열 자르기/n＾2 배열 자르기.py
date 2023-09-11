def solution(n, left, right):
    answer = []

    for i in range(left, right + 1):
        divide, rest = divmod(i, n)
        if divide >= rest:
            answer.append(divide + 1)
        else:
            answer.append(rest + 1)

    return answer