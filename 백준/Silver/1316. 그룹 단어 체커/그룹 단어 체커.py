import sys


def check_group_word(word):
    if len(word) == 1:
        return 1
    
    prev = word[0]
    pool = set()
    for i, c in enumerate(word):
        if i == 0 or prev == c:
            continue
        if c in pool:
            return 0
        pool.add(prev)
        prev = c
    return 1

if __name__ == "__main__":
    N = int(sys.stdin.readline().rstrip())
    result = 0
    for _ in range(N):
        word = sys.stdin.readline().rstrip()
        result += check_group_word(word)
    
    sys.stdout.write(str(result))