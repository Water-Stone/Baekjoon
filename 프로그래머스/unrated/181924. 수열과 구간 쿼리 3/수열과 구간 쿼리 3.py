def solution(arr, queries):
    for q in queries:
        i, j = q
        arr[i], arr[j] = arr[j], arr[i]
    return arr