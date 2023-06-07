def dfs(_coms, _visited, _n):
    _visited.add(_n)
    for idx, link in enumerate(_coms[_n]):
        if link == 1 and idx not in _visited:
            dfs(_coms, _visited, idx)
    return 1


def solution(n, coms):
    visited = set()
    result = 0
    for i in range(n):
        if i not in visited:
            result += dfs(coms, visited, i)
    return result