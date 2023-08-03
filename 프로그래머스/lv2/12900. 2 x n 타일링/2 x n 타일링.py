def solution(n):
    dp = [i for i in range(n + 1)]
    for i in range(3, n + 1):
        dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007
    return dp[n] % 1000000007