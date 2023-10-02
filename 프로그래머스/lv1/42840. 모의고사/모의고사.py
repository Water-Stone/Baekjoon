def solution(answers):
    p1 = [1, 2, 3, 4, 5]
    p2 = [2, 1, 2, 3, 2, 4, 2, 5]
    p3 = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]
    cnts = [0, 0, 0]
    
    for i, answer in enumerate(answers):
        idx1, idx2, idx3 = i % 5, i % 8, i % 10
        if p1[idx1] == answer:
            cnts[0] += 1
        if p2[idx2] == answer:
            cnts[1] += 1
        if p3[idx3] == answer:
            cnts[2] += 1
    
    m = max(cnts)
    return [i + 1 for i, cnt in enumerate(cnts) if cnt == m]
    
        