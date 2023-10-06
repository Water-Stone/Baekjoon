def solution(arr, n):
    if len(arr) % 2:
        return [v + n if not i % 2 else v for i, v in enumerate(arr)]
    else:
        return [v + n if i % 2 else v for i, v in enumerate(arr)]