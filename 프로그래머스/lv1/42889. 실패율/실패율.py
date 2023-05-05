# 실패율
def solution(N, stages):
    diff = {}

    staying = 0
    # 스테이지에 도달한 플레이어 수
    been = len(stages)
    for i in range(1, N + 2):
        # 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수
        staying = stages.count(i)

        # for _ in range(staying):
        #     stages.remove(i)

        if been == 0:
            diff[i] = 0
        else:
            diff[i] = staying / been

        been -= staying

    del (diff[N+1])
    result = sorted(diff.keys(), key=lambda x: diff.get(x), reverse=True)

    return result