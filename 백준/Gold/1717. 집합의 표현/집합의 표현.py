import sys

read = sys.stdin.readline
write = sys.stdout.write

def find_parent(parent, x):
    if parent[x] != x:
        parent[x] = find_parent(parent, parent[x])
    return parent[x]

def union_parent(parent, x, y, depth):
    root_x = find_parent(parent, x)
    root_y = find_parent(parent, y)
    
    if root_x == root_y:
        return
    
    if depth[root_x] > depth[root_y]:
        parent[root_y] = root_x
    elif depth[root_x] < depth[root_y]:
        parent[root_x] = root_y
    else:
        parent[root_y] = root_x
        depth[root_x] += 1

if __name__ == "__main__":
    n, m = map(int, read().rstrip().split())
    parent = [i for i in range(n + 1)]
    depth = [0 for _ in range(n + 1)]
    for _ in range(m):
        cmd, a, b = map(int, read().rstrip().split())
        if cmd == 0:
            union_parent(parent, a, b, depth)
        elif cmd == 1:
            if find_parent(parent, a) == find_parent(parent, b):
                write('YES\n')
            else:
                write('NO\n')