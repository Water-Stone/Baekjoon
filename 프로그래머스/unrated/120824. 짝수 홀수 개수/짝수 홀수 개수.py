def solution(num_list):
    a, b = 0, 0
    for num in num_list:
        if num % 2:
            b += 1
        else:
            a += 1
    return [a, b]