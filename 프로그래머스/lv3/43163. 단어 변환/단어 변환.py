from collections import deque


def solution(begin, target, words):
    if target not in words:
        return 0
    
    dq = deque()
    dq.append((begin, 0))
    visited = set()
    
    while dq:
        curr, cnt = dq.popleft()
        if curr == target:
            return cnt
        for word in words:
            if word in visited:
                continue
            
            flag = False
            for i, letter in enumerate(word):
                if curr[i] != letter:
                    if flag:
                        break
                    flag = True
            else:
                dq.append((word, cnt + 1))
                visited.add(word)
    return -1