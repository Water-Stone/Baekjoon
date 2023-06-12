import math

def solution(keymap, targets):
    answer = []
    for target in targets:
        asum = 0
        for c in target:
            ind = []        
            for key in keymap:
                try:
                    ind.append(key.index(c))
                except:
                    ind.append(math.inf)
            asum += (min(ind) + 1)
        
        if asum == math.inf:
            answer.append(-1)
        else:
            answer.append(asum)
    
    return answer