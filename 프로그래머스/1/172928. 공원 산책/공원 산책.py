def find_start(park):
    for i in range(len(park)):
        for j in range(len(park[0])):
            if park[i][j] == 'S':
                return [i, j]

def move(park, route, cur):
    goal = [a+b for a, b in zip(route, cur)]
    if not 0 <= goal[0] <= len(park) - 1: return cur
    if not 0 <= goal[1] <= len(park[0]) - 1: return cur
    
    if goal[0] != cur[0]:
        for i in range(min(cur[0], goal[0]), max(cur[0],goal[0])+1):
            if park[i][cur[1]] == 'X': return cur
    else:
        for i in range(min(cur[1], goal[1]), max(cur[1], goal[1])+1):
            if park[cur[0]][i] == 'X': return cur
    return goal

def solution(park, routes):
    answer = []
    cur = find_start(park)
    direc = {'N':[-1,0], 'S':[1,0], 'E':[0,1], 'W':[0,-1]}
    for r in routes:
        route = [a * int(r[2]) for a in direc[r[0]]]
        cur = move(park, route, cur)


    return cur