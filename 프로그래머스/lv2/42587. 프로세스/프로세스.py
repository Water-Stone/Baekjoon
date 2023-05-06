# 프로세스
from collections import deque


def solution(priorities, location):
    dq = deque(priorities)

    num_excuted_process = 0
    while len(dq) > 0:
        is_curr_excuted = True
        curr = dq.popleft()
        for n in range(9, curr, -1):
            if n in dq:
                dq.append(curr)
                is_curr_excuted = False
                break

        if is_curr_excuted and location == 0:
            return num_excuted_process + 1

        location -= 1
        if location < 0:
            location = len(dq) - 1

        if is_curr_excuted:
            num_excuted_process += 1