# 숫자 문자열과 영단어
def solution(s):
    if s.isdigit():
        return int(s)

    words = ['zero', 'one', 'two', 'three', 'four',
             'five', 'six', 'seven', 'eight', 'nine']
    for i in range(len(words)):
        s = s.replace(words[i], str(i))

    return int(s)