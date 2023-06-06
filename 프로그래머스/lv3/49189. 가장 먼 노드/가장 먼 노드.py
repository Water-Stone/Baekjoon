from collections import deque, defaultdict

def bfs(_dict, n):
    visited = {n}
    dq = deque()
    dq.append(n)
    
    while dq:
        node = dq.popleft()
        distance, links = _dict[node]
        for idx in links:
            if idx not in visited:
                visited.add(idx)
                _dict[idx][0] = distance + 1
                dq.append(idx)
    

def solution(n, edges):
    # d = {n: [distance_from_1, [links]]}
    d = {1: [0, []]}
    for edge in edges:
        node_a, node_b = edge
        d.setdefault(node_a, [20001,[]])
        d.setdefault(node_b, [20001,[]])
        d[node_a][1].append(node_b)
        d[node_b][1].append(node_a)
    
    bfs(d, 1)
    
    result = 0
    longest_distance = max(d.values(), key= lambda v: v[0])[0]
    for v in d.values():
        if v[0] == longest_distance:
            result += 1
    return result