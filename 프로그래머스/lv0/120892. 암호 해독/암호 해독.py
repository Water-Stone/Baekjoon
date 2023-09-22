def solution(cipher, code):
    return ''.join(c for i, c in enumerate(cipher) if not (i + 1) % code)