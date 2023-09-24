def solution(ingredient):
    # 버거: 1-2-3-1
    result = 0
    stack = []
    
    for item in ingredient:
        stack.append(item)
        if len(stack) < 4:
            continue
        if stack[-4] == 1 and stack[-3] == 2 and stack[-2] == 3 and stack[-1] == 1:
            # stack = stack[:-4]
            for i in range(4):
                stack.pop()
            result += 1
    
    return result
    