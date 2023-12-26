def compare_len(arr1, arr2):
    if len(arr1) < len(arr2):
        return -1
    return 1

def compare_sum(arr1, arr2):
    s1, s2 = sum(arr1), sum(arr2)
    if s1 > s2:
        return 1
    if s1 < s2:
        return -1
    return 0

def solution(arr1, arr2):
    if len(arr1) == len(arr2):
        return compare_sum(arr1, arr2)
    return compare_len(arr1, arr2)