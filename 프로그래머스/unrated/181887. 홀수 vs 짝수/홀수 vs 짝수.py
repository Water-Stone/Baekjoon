def solution(num_list):
    return max(sum(num_list[idx] for idx in range(0, len(num_list), 2)),\
               sum(num_list[idx] for idx in range(1, len(num_list), 2)))