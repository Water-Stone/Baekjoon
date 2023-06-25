def solution(numbers):
    return sum(filter(lambda x: x not in numbers, range(10)))