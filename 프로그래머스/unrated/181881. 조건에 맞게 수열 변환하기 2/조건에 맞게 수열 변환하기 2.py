def solution(arr):
    arrs = [arr]
    
    i = 0
    while True:
        tmp = []
        l = arrs[i]
        for value in l:
            if value < 50 and value % 2:
                res = value * 2 + 1
            elif value >= 50 and not value % 2:
                res = value // 2
            else:
                res = value
            tmp.append(res)
        
        if tmp == l:
            return i
        arrs.append(tmp)
        i += 1
            