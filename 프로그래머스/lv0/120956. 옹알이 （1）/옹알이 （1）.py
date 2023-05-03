def solution(babbling):
    onglist = ["aya", "ye", "woo", "ma"]
    result = 0
    
    for bab in babbling:
        text = bab
        for ong in onglist:
            if ong in text:
                text = text.replace(ong, '-')
                for i in range(len(text)):
                    if list(text)[i] != '-':
                        break
                    if i == len(text) - 1:
                        result += 1
    
    return result