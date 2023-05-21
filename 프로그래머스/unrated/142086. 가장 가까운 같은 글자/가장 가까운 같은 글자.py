def solution(s):
    answer = [-1]
    
    for i, c in enumerate(s):
        if i == 0:
            continue
        idx = s[i-1::-1].find(c)
        answer.append(idx if idx < 0 else idx + 1)
    
    return answer