def is_valid(s):
    brackets = ['()', '[]', '{}']

    while len(s) > 0:
        for i in range(3):
            if brackets[i] in s:
                s = s.replace(brackets[i], '')
                break
        else:
            return False
    return True

def solution(s):
    if len(s) % 2 == 1:
        return 0

    answer = 0
    for _ in range(len(s)):
        if is_valid(s):
            answer += 1
        s = s[1:] + s[:1]

    return answer