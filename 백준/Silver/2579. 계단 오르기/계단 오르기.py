num_stairs = int(input())
stairs = [0] + [int(input()) for _ in range(num_stairs)]

if num_stairs <= 2:
    sum = 0
    for i in stairs:
        sum += i
    print(sum)
    exit()

dp = [0] * (num_stairs + 1)
dp[1] = stairs[1]
dp[2] = stairs[1] + stairs[2]

for i in range(3, num_stairs + 1):
    dp[i] = max(dp[i-3]+stairs[i-1]+stairs[i], dp[i-2]+stairs[i])

print(dp[num_stairs])