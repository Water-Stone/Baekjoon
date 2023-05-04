# 로또의 최고 순위와 최저 순위
def solution(lottos, win_nums):
    result = [7, 7]
    cnt_matched = 0
    cnt_zeros = lottos.count(0)

    for num in lottos:
        if num in win_nums:
            cnt_matched += 1

    for _ in range(cnt_matched):
        result[0] -= 1
        result[1] -= 1

    for _ in range(cnt_zeros):
        result[0] -= 1

    while 7 in result:
        result[result.index(7)] = 6

    return result