def solution(sticker):
    N = len(sticker)
    if N == 1:
        return sticker[0]
    
    dp1, dp2 = [0 for _ in range(N)], [0 for _ in range(N)]
    
    dp1[0], dp1[1] = sticker[0], max(sticker[0], sticker[1])
    for i in range(2, N - 1):
        dp1[i] = max(dp1[i - 1], dp1[i - 2] + sticker[i])
    
    dp2[0], dp2[1] = 0, sticker[1]
    for i in range(2, N):
        dp2[i] = max(dp2[i - 1], dp2[i - 2] + sticker[i])
    
    return max(max(dp1), max(dp2))