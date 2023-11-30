def solution(arr, h):
    return len(list(filter(lambda x: x > h, arr)))