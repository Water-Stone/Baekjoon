def solution(arr):
    if 2 not in arr:
        return [-1]
    
    left_idx = arr.index(2)
    if 2 not in arr[left_idx + 1:]:
        return [2]
    
    right_idx = len(arr) - arr[::-1].index(2)
    return arr[left_idx:right_idx]