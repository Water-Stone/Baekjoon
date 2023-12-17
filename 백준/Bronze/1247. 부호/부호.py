import sys


if __name__ == "__main__":
    for T in range(3):
        N = int(sys.stdin.readline().rstrip())
        s = 0
        for _ in range(N):
            num = int(sys.stdin.readline().rstrip())
            s += num
        if s < 0:
            sys.stdout.write('-\n')
        elif s > 0:
            sys.stdout.write('+\n')
        else:
            sys.stdout.write('0\n')