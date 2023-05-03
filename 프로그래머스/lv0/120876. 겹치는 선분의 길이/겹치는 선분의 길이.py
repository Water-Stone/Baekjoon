def solution(lines):
    # lines.sort(key= lambda x: (x[0], x[1]))
    
    start = min(lines[0][0], lines[1][0], lines[2][0])
    end = max(lines[0][1], lines[1][1], lines[2][1])
    pivot = start * (-1)
    isOverlap = [0] * (end - start)
    
    for line in lines:
        for i in range(line[0], line[1]):
            isOverlap[i + pivot] += 1
    
    return str(isOverlap).count('2') + str(isOverlap).count('3')