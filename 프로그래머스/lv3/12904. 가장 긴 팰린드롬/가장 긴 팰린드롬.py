def solution(s):
    n = len(s)
    dp = [[0] * n for _ in range(n)]
    maxLength = 1

    # All substrings of length 1 are palindromes
    for i in range(n):
        dp[i][i] = 1

    # Check for substrings of length 2
    start = 0
    for i in range(n - 1):
        if s[i] == s[i + 1]:
            dp[i][i + 1] = 1
            start = i
            maxLength = 2

    # Check for substrings of length 3 and more
    for k in range(3, n + 1):
        for i in range(n - k + 1):
            j = i + k - 1
            if dp[i + 1][j - 1] and s[i] == s[j]:
                dp[i][j] = 1
                if k > maxLength:
                    start = i
                    maxLength = k

    return maxLength