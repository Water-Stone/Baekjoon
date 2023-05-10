# JadenCase 문자열 만들기
def solution(s):
    answer = ''
    for word in s.split(' '):
        if word == '':
            answer += ' '
            continue
        if word.isalpha():
            answer += word[0].upper()
        else:
            answer += word[0]
        if len(word) > 1:
            answer += word[1:].lower()
        answer += ' '
    else:
        answer = answer[:-1]

    return answer