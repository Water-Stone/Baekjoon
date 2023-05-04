# [1차] 다트 게임
def solution(dartResult):
    answer = 0
    # [점수, 제곱, 스타상, 아차상]
    result_list = [[0, 1, 1, 1], [0, 1, 1, 1], [0, 1, 1, 1]]

    curr_result_idx = 0
    isTen = False
    for i in range(len(dartResult)):
        if isTen:
            isTen = False
            continue

        char = dartResult[i]
        if char.isdigit():
            point = 0
            if char == '1':
                if dartResult[i + 1] == '0':
                    point = 10
                    isTen = True
                else:
                    point = 1
            else:
                point = int(char)
            result_list[curr_result_idx][0] = point
        elif char.isalpha():
            if char == 'S':
                result_list[curr_result_idx][1] = 1
            elif char == 'D':
                result_list[curr_result_idx][1] = 2
            elif char == 'T':
                result_list[curr_result_idx][1] = 3
            if i != len(dartResult) - 1:
                if dartResult[i + 1].isdigit():
                    curr_result_idx += 1
        else:
            if char == '*':
                result_list[curr_result_idx][2] *= 2
                if curr_result_idx >= 1:
                    result_list[curr_result_idx - 1][2] *= 2
            elif char == '#':
                result_list[curr_result_idx][3] *= -1
            curr_result_idx += 1

    # [점수, 제곱, 스타상, 아차상]
    for result in result_list:
        answer += pow(result[0], result[1])*result[2]*result[3]

    return answer