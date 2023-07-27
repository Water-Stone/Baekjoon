def solution(s, n):
    result = ''
    a = ord('a')
    z = ord('z')
    A = ord('A')
    Z = ord('Z')
    for letter in s:
        if letter == ' ':
            result += letter
            continue
        l = ord(letter)
        next = l + n
        if l >= a and l <= z:
            # 소문자
            if next > z:
                next += (a - z - 1)
        else:
            # 대문자
            if next > Z:
                next += (A - Z - 1)
        result += chr(next)
    return result