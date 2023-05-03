def solution(name, yearning, photo):
    answer = [0] * len(photo)
    
    for i in range(len(photo)):
        for j in range(len(name)):
            answer[i] += photo[i].count(name[j]) * yearning[j]
    
    return answer