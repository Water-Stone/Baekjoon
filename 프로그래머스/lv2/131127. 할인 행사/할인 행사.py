def solution(want, number, discount):
    answer = 0
    want_set = {}
    
    for meal, idx in zip(want, range(len(number))):
        want_set[meal] = number[idx]
    
    for idx in range(len(discount)):
        discount_target = discount[idx:idx + 10]

        copy_want_set = dict(want_set)
        
        for meal in discount_target:
            if meal in copy_want_set:
                copy_want_set[meal] -= 1
                if copy_want_set[meal] == 0:
                    del copy_want_set[meal]

        if not copy_want_set:
            answer += 1

    return answer
