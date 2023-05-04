# 신규 아이디 추천
def solution(new_id):
    # 1: 대문자를 소문자로 치환
    answer = new_id.lower()

    # 2: 알파벳 소문자, 숫자, 유효 특수문자를 제외한 모든 문자를 제거
    available_special_symbols = '-_.'
    for char in list(answer):
        if not char.isalpha():
            if not char.isdigit():
                if not char in available_special_symbols:
                    answer = answer.replace(char, '')

    # 3: 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환
    dots = '.' * 1000
    while True:
        if dots == '.':
            break
        if dots in answer:
            answer = answer.replace(dots, '.')
        dots = dots[1:]

    # 4: 마침표(.)가 처음이나 끝에 위치한다면 제거
    answer = answer.strip('.')

    # 5: 빈 문자열이라면, "a"를 대입
    if answer == '':
        answer = 'a'

    # 6: 길이가 16자 이상이면, 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거
    if len(answer) >= 16:
        answer = answer[:15]
    # 만약 제거 후 마침표(.)가 끝에 위치한다면 해당 마침표(.) 문자를 제거
    answer = answer.strip('.')

    # 7: 길이가 2자 이하라면, 마지막 문자를 반복. (길이가 3이 될 때까지)
    while len(answer) <= 2:
        answer += answer[-1:]

    return answer