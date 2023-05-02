def solution(quiz):
    answer = []
    
    for q in quiz:
        seq = q.split(' ')
        x = int(seq[0])
        y = int(seq[2])
        z = int(seq[4])
        if seq[1] == '+':
            if (x + y) == z:
                answer.append('O')
            else:
                answer.append('X')
        else:
            if (x - y) == z:
                answer.append('O')
            else:
                answer.append('X')
    
    return answer

quiz = ["3 - 4 = -3", "5 + 6 = 11"]
print(solution(quiz))