def solution(arr, idx):
    result = ''.join(map(str, arr[idx:])).find('1')
    return result + idx if result != -1 else -1