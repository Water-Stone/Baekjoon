def solution(n, results):
    answer = 0
    table = [[0 for _ in range(n + 1)] for _ in range(n + 1)]
    
    for a, b in results:
        table[a][b] = 1
    
    for k in range(1, n + 1):
        for i in range(1, n + 1):
            for j in range(1, n + 1):
                if table[i][j] == 1 or (table[i][k] == 1 and table[k][j] == 1):
                    table[i][j] = 1
    
    answers = [0 for _ in range(n + 1)]
    for i in range(1, n + 1):
        for j in range(1, n + 1):
            if table[i][j] == 1:
                answers[i] += 1
                answers[j] += 1
    for i in range(1, n + 1):
        if answers[i] == n - 1:
            answer += 1
    return answer