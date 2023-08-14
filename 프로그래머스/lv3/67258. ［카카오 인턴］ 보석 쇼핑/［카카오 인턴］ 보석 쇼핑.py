from collections import Counter

def solution(gems):
    num_of_gem_types = len(set(gems))
    res = []

    left = 0
    counter = Counter()
    for right, gem in enumerate(gems):
        counter[gem] += 1
        right += 1
        while len(counter) == num_of_gem_types:
            counter[gems[left]] -= 1
            if counter[gems[left]] == 0:
                del counter[gems[left]]
            left += 1
            res.append([left, right])

    return sorted(res, key = lambda x: (x[1]-x[0], x[0]))[0]