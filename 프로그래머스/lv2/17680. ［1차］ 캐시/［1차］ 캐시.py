from collections import deque


def solution(cacheSize, cities):
    if cacheSize == 0:
        return 5 * len(cities)

    cache = deque([''] * cacheSize, maxlen=cacheSize)
    answer = 0

    for city in cities:
        city = city.lower()
        if city in cache:
            cache.remove(city)
            answer += 1
        else:
            answer += 5
        cache.append(city)

    return answer