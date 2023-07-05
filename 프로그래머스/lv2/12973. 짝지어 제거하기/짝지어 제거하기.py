def solution(s):
    if len(s) % 2:
        return 0
    
    stack = []
    for letter in s:
        if stack and stack[-1] == letter:
            stack.pop()
        else:
            stack.append(letter)
    
    if stack:
        return 0
    return 1