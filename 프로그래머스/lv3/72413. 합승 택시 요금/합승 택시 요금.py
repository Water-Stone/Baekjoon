def solution(n, s, a, b, fares):
    """
    args:
        n <int>: 지점(노드)의 개수, 3이상 200 이하의 자연수.
        s <int>: 출발지점의 노드 번호, 1이상 n이하의 자연수.
        a <int>: A(무지)의 도착지점의 노드 번호, 1이상 n이하의 자연수.
        b <int>: B(어피치)의 도착지점의 노드 번호, 1이상 n이하의 자연수.
        fares <list>: 지점 사이의 요금 정보, 2 이상 (n * (n - 1) / 2)이하의 크기.
            - fare <list>: fares의 원소, [c, d, f]의 형태로 c지점-d지점의 요금이 f원.
    
    return:
        s에서 출발하여 a, b로 이동할 때 최소가 되는 비용을 반환.
    """
    MAX = 100000 * n
    
    graph = [[MAX] * (n + 1) for _ in range(n + 1)]
    
    for x, y, fare in fares:
        graph[x][y] = fare
        graph[y][x] = fare
    
    for k in range(1, n + 1):
        for i in range(1, n + 1):
            for j in range(1, n + 1):
                if i == j:
                    graph[i][j] = 0
                elif graph[i][j] > graph[i][k] + graph[k][j]:
                    graph[i][j] = graph[i][k] + graph[k][j]

    answer = MAX
    for start in range(1,n+1):
        answer = min(answer, graph[start][s] + graph[start][a] + graph[start][b])
    return answer