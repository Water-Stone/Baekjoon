def solution(s):
    sum = 0
    prev = 0
    for i in s.split(' '):
        if i == 'Z':
            sum -= prev
        else:
            prev = int(i)
            sum += int(i)
    return sum