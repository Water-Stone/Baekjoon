def find(parent, i):
    # 부모 노드를 찾는 재귀적인 함수
    if parent[i] == i:  # 현재 노드의 부모가 자기 자신인 경우
        return i
    return find(parent, parent[i])  # 부모 노드를 따라가며 재귀적으로 탐색

def union(parent, rank, x, y):
    # 두 집합을 합치는 함수 (Union-Find)
    xroot = find(parent, x)
    yroot = find(parent, y)

    if rank[xroot] < rank[yroot]:
        parent[xroot] = yroot
    elif rank[xroot] > rank[yroot]:
        parent[yroot] = xroot
    else:
        parent[yroot] = xroot
        rank[xroot] += 1

def solution(n, costs):
    # 간선을 비용 순으로 정렬
    costs.sort(key=lambda x: x[2])

    parent = [i for i in range(n)]  # 각 정점의 부모 노드
    rank = [0] * n  # 각 정점의 랭크 (트리의 높이)
    min_cost = 0  # 최소 비용

    for edge in costs:
        src, dst, cost = edge

        if find(parent, src) != find(parent, dst):
            # 두 정점의 부모 노드가 다르면 (사이클을 형성하지 않으면)
            union(parent, rank, src, dst)  # 두 정점을 연결
            min_cost += cost  # 비용 추가

    return min_cost