import sys


if __name__ == "__main__":
    d1, d2, d3 = map(int, sys.stdin.readline().rstrip().split())
    if d1 == d2 or d1 == d3 or d2 == d3:
        if d1 == d2 and d1 == d3:
            sys.stdout.write(str(10000 + d1 * 1000))
        elif d2 == d3:
            sys.stdout.write(str(1000 + d2 * 100))
        else:
            sys.stdout.write(str(1000 + d1 * 100))
    else:
        sys.stdout.write(str(max(d1, d2, d3) * 100))