def solution(sizes):
    for size in sizes:
        size.sort(reverse=True)
    
    return max(size[0] for size in sizes) * max(size[1] for size in sizes)