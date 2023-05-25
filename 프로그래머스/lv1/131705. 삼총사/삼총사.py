def solution(number):
    cnt = 0
    for i, n1 in enumerate(number):
        for j, n2 in enumerate(number[i + 1:], start= i + 1):
            for n3 in number[j + 1:]:
                if (n1 + n2 + n3) == 0:
                    cnt += 1
    return cnt