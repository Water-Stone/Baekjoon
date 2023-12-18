import sys
from collections import deque

read = sys.stdin.readline
write = sys.stdout.write

if __name__ == "__main__":
    T = int(read().rstrip())
    for t in range(T):
        rev_cnt = 0
        p = read().rstrip()
        n = int(read().rstrip())
        if n:
            q = deque(read().rstrip()[1:-1].split(','))
            for cmd in p:
                if cmd == 'R':
                    rev_cnt += 1
                elif cmd == 'D':
                    if q:
                        if rev_cnt % 2:
                            q.pop()
                        else:
                            q.popleft()
                    else:
                        write('error\n')
                        break
            else:
                if rev_cnt % 2:
                    q.reverse()
                write('[' + ','.join(q) + ']\n')
        else:
            read()
            if 'D' in p:
                write('error\n')
            else:
                write('[]\n')