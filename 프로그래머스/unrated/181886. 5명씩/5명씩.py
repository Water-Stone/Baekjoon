def solution(names):
    return [name for i, name in enumerate(names) if not i % 5]