def solution(land):
    answer = -1
    dp = [[0, 0, 0, 0] for _ in range(len(land) + 1)]
    
    for i in range(1, len(land) + 1):
        for j in range(4):
            for k in range(4):
                if k == j:
                    continue
                
                dp[i][j] = max(dp[i][j], land[i - 1][j] + dp[i - 1][k])
                answer = max(answer, dp[i][j])
    return answer