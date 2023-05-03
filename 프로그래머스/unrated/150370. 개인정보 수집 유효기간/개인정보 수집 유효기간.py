# 개인정보 수집 유효기간
def diff_date(today, past):
    ty = int(today.split('.')[0])
    tm = int(today.split('.')[1])
    td = int(today.split('.')[2])
    py = int(past.split('.')[0])
    pm = int(past.split('.')[1])
    pd = int(past.split('.')[2])
    # year_diff = ty - py
    # mon_diff = tm - pm
    # day_diff = td - pd
    
    # 2000.01.01 기준 날 수
    t_parsed = ((ty - 2000) * 12 * 28) + ((tm - 1) * 28) + td
    p_parsed = ((py - 2000) * 12 * 28) + ((pm - 1) * 28) + pd
    
    # if year_diff == 0:
    #     if mon_diff == 0:
    #         return day_diff
    #     return (28 - pd) +\
    #         td + (28 * mon_diff)
    # return (28 - pd) + (28 * (11 - pm) + tm) + td
    
    return t_parsed - p_parsed

def solution(today, terms, privacies):
    answer = []
    
    term_dict = {}
    for term in terms:
        term_dict[term.split(' ')[0]] = int(term.split(' ')[1]) * 28
    
    for i in range(len(privacies)):
        priv = privacies[i]
        date = priv.split(' ')[0]
        if diff_date(today, date) >= term_dict.get(priv.split(' ')[1]):
            answer.append(i + 1)
    
    return answer