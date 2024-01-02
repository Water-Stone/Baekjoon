import sys


def main():
    read = sys.stdin.readline
    
    N = int(read().rstrip())
    costs = []
    for _ in range(N):
        costs.append(list(map(int, read().rstrip().split())))
    
    for i in range(1, N):
        costs[i][0] += min(costs[i - 1][1], costs[i - 1][2])
        costs[i][1] += min(costs[i - 1][0], costs[i - 1][2])
        costs[i][2] += min(costs[i - 1][0], costs[i - 1][1])
    
    result = str(min(min(costs[N - 1][0], costs[N - 1][1]), costs[N - 1][2]))
    sys.stdout.write(result)

if __name__ == "__main__":
    main()