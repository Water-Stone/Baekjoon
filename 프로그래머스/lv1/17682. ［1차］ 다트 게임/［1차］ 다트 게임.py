# [1차] 다트 게임
import re


def solution(dartResult):
    valid = re.compile(r'([0-9]|10)([SDT])([\*\#]?)')
    dart_results = valid.findall(dartResult)

    results = [0, 0, 0]
    for i in range(3):
        p = -1
        if dart_results[i][1] == 'S':
            p = 1
        elif dart_results[i][1] == 'D':
            p = 2
        elif dart_results[i][1] == 'T':
            p = 3

        results[i] = int(dart_results[i][0]) ** p

        if dart_results[i][2] == '*':
            for j in range(i, i - 2, -1):
                if j < 0:
                    break
                results[j] *= 2
        elif dart_results[i][2] == '#':
            results[i] *= (-1)

    return sum(results)