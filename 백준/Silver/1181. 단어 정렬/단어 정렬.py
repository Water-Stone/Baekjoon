import sys


if __name__ == "__main__":
    N = int(sys.stdin.readline().rstrip())
    
    words = []
    for _ in range(N):
        word = sys.stdin.readline().rstrip()
        words.append(word)
    words = list(set(words))
    
    words.sort(key=lambda x: (len(x), x))

    sys.stdout.write('\n'.join(words).rstrip())
