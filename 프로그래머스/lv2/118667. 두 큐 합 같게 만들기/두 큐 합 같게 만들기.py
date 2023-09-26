def solution(queue1, queue2):
    tried = 0
    queue_length = len(queue1) + len(queue2)
    is_find_same_queue = False
    idx1, idx2 = 0, 0
    queue1_sum = sum(queue1)
    queue2_sum = sum(queue2)

    while tried < queue_length * 2:
        if queue1_sum > queue2_sum:
            element = queue1[idx1]
            idx1 += 1
            queue1_sum -= element
            queue2_sum += element
            queue2.append(element)
        elif queue1_sum < queue2_sum:
            element = queue2[idx2]
            idx2 += 1
            queue1_sum += element
            queue2_sum -= element
            queue1.append(element)
        else:
            return tried
        tried += 1
    return -1
