import sys

read = sys.stdin.readline
write = sys.stdout.write

if __name__ == "__main__":
    nA, nB = read().rstrip().split()
    A = list(read().rstrip().split())
    B = set(list(read().rstrip().split()))
    
    result = [a for a in A if a not in B]
    result.sort(key= lambda x: int(x))
    
    write(str(len(result)) + '\n')
    write(' '.join(result))