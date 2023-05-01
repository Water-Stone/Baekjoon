from collections import OrderedDict

def solution(numlist, n):
    num_dict = OrderedDict()
    for i in range(len(numlist)):
        distance = abs(numlist[i] - n)
        num_dict[numlist[i]] = distance
    
    st = sorted(num_dict.items(), key= lambda x: (x[1], -x[0]))
    answer = []
    for i in range(len(st)):
        answer.append(st[i][0])
    return answer