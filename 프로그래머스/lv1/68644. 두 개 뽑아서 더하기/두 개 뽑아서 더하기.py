def solution(numbers):
    numbers.sort()
    result = []
    for i in range(1, len(numbers)):
        result += [x + y for x, y in zip(numbers, numbers[i:])]
    return sorted(list(set(result)))