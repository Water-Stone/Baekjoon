import sys


if __name__ == "__main__":
    T = int(sys.stdin.readline().rstrip())
    for _ in range(T):
        line = sys.stdin.readline().rstrip()
        left, right = [], []
        for c in line:
            if c == '<':
                if left:
                    right.append(left.pop())
            elif c == '>':
                if right:
                    left.append(right.pop())
            elif c == '-':
                if left:
                    left.pop()
            else:
                left.append(c)
        sys.stdout.write(''.join(left) + ''.join(reversed(right)) + '\n')