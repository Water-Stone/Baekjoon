def solution(word):
    pool = [[], ['A', 'E', 'I', 'O', 'U']]
    
    for digit in range(2, 6):
        pool.append([])
        for s in pool[digit - 1]:
            for b in pool[1]:
                pool[digit].append(s + b)
    
    words = []
    for p in pool:
        for w in p:
            words.append(w)
    words.sort()
    
    return words.index(word) + 1