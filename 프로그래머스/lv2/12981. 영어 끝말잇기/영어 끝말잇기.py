# 영어 끝말잇기
def solution(n, words):
    for i in range(1, len(words)):
        # 끝말 확인 or 중복 확인
        if words[i - 1][-1:] != words[i][:1] or words.index(words[i]) < i:
            return [(i % n) + 1, (i // n) + 1]

    return [0, 0]
