import sys


if __name__ == "__main__":
    K = int(sys.stdin.readline().rstrip())
    stack = []
    for _ in range(K):
        num = int(sys.stdin.readline().rstrip())
        if num:
            stack.append(num)
        else:
            stack.pop()
    sys.stdout.write(str(sum(stack)))