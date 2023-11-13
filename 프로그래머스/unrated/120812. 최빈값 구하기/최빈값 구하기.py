from collections import Counter

def solution(arr):
    if len(arr) == 1 or len(set(arr)) == 1:
        return arr[0]
    
    mc = Counter(arr).most_common()
    return -1 if mc[0][1] == mc[1][1] else mc[0][0]