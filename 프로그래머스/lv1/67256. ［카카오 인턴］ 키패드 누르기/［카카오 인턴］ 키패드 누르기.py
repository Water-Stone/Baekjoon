# [카카오 인턴] 키패드 누르기
def solution(numbers, hand):
    # 123
    # 456
    # 789
    # *0#
    answer = ''
    currLthumb = [3, 0]
    currRthumb = [3, 2]

    for n in numbers:
        if n in [1, 4, 7]:
            answer += 'L'
            currLthumb = [n // 3, 0]
        elif n in [3, 6, 9]:
            answer += 'R'
            currRthumb = [(n // 3) - 1, 2]
        else:
            dis_left = abs(currLthumb[0] - [2, 5, 8, 0].index(n)) +\
                abs(currLthumb[1] - 1)
            dis_right = abs(currRthumb[0] - [2, 5, 8, 0].index(n)) +\
                abs(currRthumb[1] - 1)
            if hand == 'left':
                if dis_left <= dis_right:
                    answer += 'L'
                    currLthumb = [[2, 5, 8, 0].index(n), 1]
                else:
                    answer += 'R'
                    currRthumb = [[2, 5, 8, 0].index(n), 1]
            else:
                if dis_left < dis_right:
                    answer += 'L'
                    currLthumb = [[2, 5, 8, 0].index(n), 1]
                else:
                    answer += 'R'
                    currRthumb = [[2, 5, 8, 0].index(n), 1]

    return answer