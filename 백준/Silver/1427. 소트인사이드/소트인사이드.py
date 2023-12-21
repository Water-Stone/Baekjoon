import sys


def main():
    N = sys.stdin.readline().rstrip()
    sys.stdout.write(''.join(sorted(N, reverse=True)))

if __name__ == "__main__":
    main()