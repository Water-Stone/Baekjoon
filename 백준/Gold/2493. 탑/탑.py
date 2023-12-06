import sys


if __name__ == "__main__":
    N = int(sys.stdin.readline().rstrip())
    towers = list(map(int, sys.stdin.readline().split()))
    result = [0 for _ in range(N)]
    
    stack = []
    for i in range(N - 1, -1, -1):
        while stack:
            latest = stack[-1]
            if towers[i] > latest[1]:
                result[latest[0]] = i + 1
                stack.pop()
            else:
                break
        stack.append([i, towers[i]])
    
    sys.stdout.write(' '.join(map(str, result)))