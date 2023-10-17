import re


def solution(babbling):
    words = [re.sub(r'aya', 'A', re.sub(r'ye', 'B', re.sub(r'woo', 'C', re.sub(r'ma', 'D', b)))) for b in babbling]
    result = 0

    for word in words:
        including = re.sub(r'[^ABCD]', '', word)
        excluding = re.sub(r'[ABCD]', '', word)
        
        if excluding:
            continue
        
        bef = ''
        for cur in including:
            if cur == bef:
                break
            bef = cur
        else:
            result += 1
    
    return result