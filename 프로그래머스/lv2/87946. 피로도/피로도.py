from itertools import permutations

def solution(k, dungeons):
    N = len(dungeons)
    idxList = [i for i in range(N)]
    ps = permutations(idxList)
    result = -1
    
    for p in ps:
        f = k
        explored = 0
        for i in p:
            req = dungeons[i][0]  # 최소 필요 피로도
            con = dungeons[i][1]  # 소모 피로도
            if f >= req: 
                f -= con
                explored += 1
            else:
                break
        if explored == N:
            return N
        result = max(result, explored)
    return result
        