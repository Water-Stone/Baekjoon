import sys


if __name__ == "__main__":
    a, b = sys.stdin.readline().rstrip().split()
    i, j = 0, 0
    for idx, c in enumerate(a):
        if c in b:
            i = b.index(c)
            j = idx
            break
    
    for x in range(len(b)):
        if x == i:
            sys.stdout.write(a + '\n')
            continue
        for y in range(len(a)):
            if y == j:
                sys.stdout.write(b[x])
                continue
            sys.stdout.write('.')
        sys.stdout.write('\n')