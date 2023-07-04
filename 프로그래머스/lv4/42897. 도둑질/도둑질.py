def solution(money):
    L = len(money)
    
    # 첫번째집(money[0])을 터는 경우 dp1
    dp1 = [0] * (L - 1)
    dp1[0], dp1[1] = money[0], max(money[1], money[0])
    for i in range(2, L - 1): # 첫번째집과 연결된 마지막집은 X
        dp1[i] = max(dp1[i-1], dp1[i-2] + money[i])
    
    # 첫번째집(money[0])을 털지 않는 경우 dp2
    dp2 = [0] * L
    dp2[0], dp2[1] = 0, money[1] # 첫번째 집은 X
    for i in range(2, L): # 마지막집까지
        dp2[i] = max(dp2[i-1], dp2[i-2] + money[i])
    
    return max(dp1[L - 2], dp2[L - 1])