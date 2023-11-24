def solution(data, ext, val_ext, sort_by):
    ext_match = {'code':0, 'date':1, 'maximum':2, 'remain':3}
    e = ext_match[ext]
    s = ext_match[sort_by]
    
    return sorted([d for d in data if d[e] < val_ext], key= lambda x: x[s])