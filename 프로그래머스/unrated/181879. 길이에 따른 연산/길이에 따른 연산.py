def solution(num_list):
    if len(num_list) >= 11:
        return sum(num_list)
    v = 1
    for n in num_list:
        v *= n
    return v