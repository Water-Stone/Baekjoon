def solution(prices):
    stack = []
    result = [0 for _ in range(len(prices))]
    
    for i, price in enumerate(prices):
        while stack and price < stack[-1][1]:
            idx = stack.pop()[0]
            result[idx] = i - idx
        stack.append([i, price])
    
    while stack:
        idx = stack.pop()[0]
        result[idx] = len(prices) - idx - 1
    
    return result