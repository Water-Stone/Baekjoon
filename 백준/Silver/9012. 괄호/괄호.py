import sys


def is_balanced(s):
    stack = []
    for c in s:
        if c == '(':
            stack.append(c)
        elif c == ')':
            if stack:
                if stack[-1] == '(':
                    stack.pop()
                    continue
            return 'NO\n'
    
    if stack:
        return 'NO\n'
    return 'YES\n'

if __name__ == "__main__":
    T = int(sys.stdin.readline().rstrip())
    result = ''
    for _ in range(T):
        s = sys.stdin.readline().rstrip()
        result += is_balanced(s)
    
    sys.stdout.write(result.rstrip())