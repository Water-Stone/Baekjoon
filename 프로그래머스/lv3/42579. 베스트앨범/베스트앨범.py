def solution(genres, plays):
    d = dict()
    for i, genre in enumerate(genres):
        # d = {'genre': [total_played, [idx_first_and_second]]}
        d.setdefault(genre, [0, [-1, -1]])
        d[genre][0] += plays[i]
        f, s = d[genre][1]
        
        if f == -1:
            d[genre][1][0] = i
            continue
        if s == -1:
            if plays[i] > plays[f]:
                d[genre][1][1] = f
                d[genre][1][0] = i
            else:
                d[genre][1][1] = i
            continue
        
        if plays[i] > plays[s]:
            if plays[i] > plays[f]:
                d[genre][1][1] = f
                d[genre][1][0] = i
            else:
                d[genre][1][1] = i
    
    result = []
    while d:
        first, second = d.pop(max(d, key= lambda k: d[k][0]))[1]
        result.append(first)
        if second != -1:
            result.append(second)
    return result