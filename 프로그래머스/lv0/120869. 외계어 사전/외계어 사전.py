def solution(spell, dic):
    for word in dic:
        for i in range(len(spell)):
            if not (spell[i] in word):
                break
            if i == len(spell) - 1:
                return 1
    
    return 2