import sys


if __name__ == "__main__":
    N = int(sys.stdin.readline().rstrip())
    result = 0
    word_dict = {}

    for _ in range(N):
        word = sys.stdin.readline().rstrip()

        char_cnt = {}
        for c in word:
            char_cnt[c] = char_cnt.get(c, 0) + 1

        key = tuple(sorted(char_cnt.items()))
        if key not in word_dict:
            word_dict[key] = 1
            result += 1

    sys.stdout.write(str(result))