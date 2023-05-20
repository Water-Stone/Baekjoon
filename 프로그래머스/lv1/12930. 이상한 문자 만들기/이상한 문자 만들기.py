def solution(s):
    result = ''
    for word in s.split(' '):
        for i, c in enumerate(word):
            if i % 2 == 0:
                result += c.upper()
            else:
                result += c.lower()
        result += ' '
    return result[:-1]