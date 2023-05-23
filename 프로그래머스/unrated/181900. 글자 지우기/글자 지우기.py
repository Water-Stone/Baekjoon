def solution(my_string, indices):
    result = ''
    for i, c in enumerate(my_string):
        if i not in indices:
            result += c
    return result