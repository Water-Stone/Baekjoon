import sys


if __name__ == "__main__":
    strings = []
    while True:
        input = sys.stdin.readline().rstrip()
        if input == '*':
            break
        strings.append(input)
    
    result = ''
    for string in strings:
        result += string
        is_surprising = True
        for d in range(1, len(string) - 1):
            dset = set()
            for i in range(len(string) - d):
                part = string[i] + string[i + d]
                if part in dset:
                    is_surprising = False
                    break
                dset.add(part)
            if not is_surprising:
                break
        
        result += " is "
        if not is_surprising:
            result += "NOT "
        result += "surprising.\n"
    
    sys.stdout.write(result[:-1])