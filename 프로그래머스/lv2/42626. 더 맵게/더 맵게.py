import heapq


def mix_food(a, b):
    return min(a, b) + (max(a, b) * 2)


def solution(scoville, K):
    if K == 0:
        return 0

    cnt_mix = 0
    lessK = list(filter(lambda x: x < K, scoville))
    heapq.heapify(lessK)

    no_remain_flag = False
    if len(lessK) == len(scoville):
        no_remain_flag = True

    while len(lessK) >= 2:
        food1 = heapq.heappop(lessK)
        food2 = heapq.heappop(lessK)
        mixed = mix_food(food1, food2)
        cnt_mix += 1
        if mixed < K:
            heapq.heappush(lessK, mixed)
        else:
            no_remain_flag = False

    if len(lessK) == 1:
        if no_remain_flag:
            return -1
        cnt_mix += 1

    return cnt_mix