def solution(n):
    # 1, 2, 3, 5, 8, 13, 21, 34
    dp = [1 for _ in range(n + 1)]
    for i in range(2, n + 1):
        dp[i] = dp[i - 2] + dp[i - 1]
    return dp[n] % 1234567