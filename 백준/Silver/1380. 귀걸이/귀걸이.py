import sys

read = sys.stdin.readline
write = sys.stdout.write

if __name__ == "__main__":
    T = 1
    while True:
        n = int(read().rstrip())
        if n == 0:
            break
        
        name_dict = {i:'' for i in range(1, n + 1)}
        for i in range(n):
            name_dict[i + 1] = read().rstrip()
        
        num_set = set()
        for _ in range(2 * n - 1):
            num, ch = read().rstrip().split()
            if num in num_set:
                num_set.discard(num)
            else:
                num_set.add(num)
        
        if num_set:
            write(f'{T} {name_dict[int(num_set.pop())]}\n')
        T += 1