import sys


if __name__ == "__main__":
    S = sys.stdin.readline().rstrip()
    result = ''
    
    tag_opened = False
    word_stack = []
    for c in S:
        if tag_opened:
            if c == '>':
                tag_opened = False
            result += c
        elif c == '<':
            tag_opened = True
            if word_stack:
                result += ''.join(word_stack[::-1])
                word_stack = []
            result += c
        elif c == ' ':
            result += ''.join(word_stack[::-1]) + ' '
            word_stack = []
        else:
            word_stack.append(c)
    
    if word_stack:
        result += ''.join(word_stack[::-1])
    
    sys.stdout.write(result)