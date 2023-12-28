import sys

read = sys.stdin.readline
write = sys.stdout.write

if __name__ == "__main__":
    while True:
        N, M = map(int, read().rstrip().split())
        if N == 0 and M == 0:
            break
        Nset, Mset = set(), set()
        cnt = 0
        for _ in range(N):
            Nset.add(read().rstrip())
        for _ in range(M):
            m = read().rstrip()
            if m in Nset:
                cnt += 1
        write(f'{cnt}\n')