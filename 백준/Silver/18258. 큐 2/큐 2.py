import sys
from collections import deque

if __name__ == "__main__":
    q = deque()
    N = int(sys.stdin.readline().rstrip())
    for _ in range(N):
        input = sys.stdin.readline().rstrip().split(' ')
        if input[0] == 'push':
            q.append(input[1])
        elif input[0] == 'pop':
            if q:
                sys.stdout.write(q.popleft() + '\n')
            else:
                sys.stdout.write('-1\n')
        elif input[0] == 'size':
            sys.stdout.write(str(len(q)) + '\n')
        elif input[0] == 'empty':
            sys.stdout.write(str(0 if q else 1) + '\n')
        elif input[0] == 'front':
            sys.stdout.write((q[0] if q else '-1') + '\n')
        elif input[0] == 'back':
            sys.stdout.write((q[-1] if q else '-1') + '\n')