def solution(s):
    result = 0
    cnts = [0, 0]
    currX = ''
    for c in s:
        if currX == '':
            currX = c
            cnts[0] += 1
        else:
            if c == currX:
                cnts[0] += 1
            else:
                cnts[1] += 1
                if cnts[0] == cnts[1]:
                    cnts[0] = 0
                    cnts[1] = 0
                    currX = ''
                    result += 1
    
    if currX:
        result += 1
    
    return result
                    