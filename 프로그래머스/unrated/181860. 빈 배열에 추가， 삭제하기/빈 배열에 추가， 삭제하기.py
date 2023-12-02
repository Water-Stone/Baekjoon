def solution(arr, flag):
    result = []
    for i, f in enumerate(flag):
        if f:
            for _ in range(arr[i]):
                result.append(arr[i])
                result.append(arr[i])
        else:
            result = result[:-1 * arr[i]]
    return result