import sys


def is_balanced(s):
    stack = []
    for c in s:
        if c == '(' or c == '[':
            stack.append(c)
        elif c == ')':
            if stack:
                if stack[-1] == '(':
                    stack.pop()
                    continue
            return 'no\n'
        elif c == ']':
            if stack:
                if stack[-1] == '[':
                    stack.pop()
                    continue
            return 'no\n'
    
    if stack:
        return 'no\n'
    return 'yes\n'

if __name__ == "__main__":
    result = ''
    while True:
        s = sys.stdin.readline().rstrip()
        if s == '.':
            break
        result += is_balanced(s)
    
    sys.stdout.write(result.rstrip())