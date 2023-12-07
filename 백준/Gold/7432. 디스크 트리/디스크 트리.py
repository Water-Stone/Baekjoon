import sys

def get_sorted_directories(root, depth=0):
    result = ""
    for i, (dir_name, subdirectories) in enumerate(sorted(root.items())):
        result += " " * depth + dir_name + "\n"
        result += get_sorted_directories(subdirectories, depth + 1)
    return result

if __name__ == "__main__":
    N = int(sys.stdin.readline().rstrip())
    root = {}
    for _ in range(N):
        path = sys.stdin.readline().rstrip().split("\\")
        current = root
        for dir_name in path:
            current = current.setdefault(dir_name, {})

    result_string = get_sorted_directories(root)
    sys.stdout.write(result_string.rstrip())
