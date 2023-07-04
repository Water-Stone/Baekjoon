def list_to_dict_by_cnt(_list):
    result_dict = {}
    
    for n in _list:
        if n in result_dict:
            result_dict[n] += 1
        else:
            result_dict[n] = 1
    
    return result_dict


def solution(k, tangerine):
    d = list_to_dict_by_cnt(tangerine)
    cnt_list = sorted(list(d.items()), key= lambda x: x[1])
    
    cnt_size = 0
    while k:
        curr = cnt_list.pop()
        if curr[1] >= k:
            cnt_size += 1
            break
        else:
            cnt_size += 1
            k -= curr[1]

    return cnt_size