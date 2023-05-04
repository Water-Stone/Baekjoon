from collections import OrderedDict


def solution(survey, choices):
    # RT, CF, JM, AN
    indicate = OrderedDict()
    indicate = {'RT': [0, 0], 'CF': [0, 0], 'JM': [0, 0], 'AN': [0, 0]}

    for i in range(len(choices)):
        point = choices[i]
        is_reversed = False
        curr_indi = ''.join(sorted(survey[i]))
        if curr_indi != survey[i]:
            is_reversed = True
        if point < 4:
            if point == 1:
                point = 3
            elif point == 3:
                point = 1

            if is_reversed:
                indicate.get(curr_indi)[1] += point
            else:
                indicate.get(curr_indi)[0] += point
        elif point > 4:
            point -= 4
            if is_reversed:
                indicate.get(curr_indi)[0] += point
            else:
                indicate.get(curr_indi)[1] += point

    answer = ''
    for indi, value in indicate.items():
        answer += indi[value.index(max(value))]
    return answer