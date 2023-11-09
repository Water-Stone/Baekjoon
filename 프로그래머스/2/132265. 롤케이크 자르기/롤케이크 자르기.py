from collections import Counter


def solution(topping):
    result = 0
    
    left, right = Counter(), Counter(topping)
    
    for t in topping:
        if t in right:
            right[t] -= 1
            if not right[t]:
                del right[t]
        if t not in left:
            left[t] = 1
        else:
            left[t] += 1
        result += (len(left) == len(right))
    
    return result