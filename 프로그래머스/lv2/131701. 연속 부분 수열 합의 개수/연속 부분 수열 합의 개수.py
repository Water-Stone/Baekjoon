def solution(elements):
    elements_length = len(elements)
    sum_set = set(elements)
    
    for curr_length in range(elements_length):
        if curr_length == 0:
            continue
        for i in range(elements_length):
            if i + curr_length >= elements_length:
                rest = i + curr_length - elements_length
                sum_set.add(sum(elements[i:]) + sum(elements[:rest]))
            else:
                sum_set.add(sum(elements[i:i+curr_length]))
    
    sum_set.add(sum(elements))
    return len(sum_set)