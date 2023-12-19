import sys

read = sys.stdin.readline
write = sys.stdout.write

if __name__ == "__main__":
    diff_idxs = set()
    
    N = int(read().rstrip())
    pattern = list(read().rstrip())
    for _ in range(N - 1):
        file_name = read().rstrip()
        for i, c in enumerate(pattern):
            if c != file_name[i]:
                diff_idxs.add(i)
    
    for i in diff_idxs:
        pattern[i] = '?'
    
    write(''.join(pattern))