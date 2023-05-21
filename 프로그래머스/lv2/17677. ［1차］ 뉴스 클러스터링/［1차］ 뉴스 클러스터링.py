def interlist(l1, l2):
    # 두 리스트(중복 가능 집합)의 교집합
    result = []
    for elem in l1:
        if elem in l2:
            result.append(elem)
            l2.remove(elem)
    return result

def unionlist(l1, l2):
    # 두 리스트(중복 가능 집합)의 합집합
    return l1 + l2

def solution(str1, str2):
    set1 = [str1[i:i+2].lower() for i in range(len(str1) - 1) if str1[i:i+2].isalpha()]
    set2 = [str2[i:i+2].lower() for i in range(len(str2) - 1) if str2[i:i+2].isalpha()]
    inter = interlist(set1, set2)
    uni = unionlist(set1, set2)
    if len(uni) == 0:
        return 65536
    result = len(inter) / len(uni)
    return int(result * 65536)