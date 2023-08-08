def solution(seq):
    seq = [v * (-1 if i % 2 else 1) for i, v in enumerate(seq)]
    
    for i in range(1, len(seq)):
        seq[i] += seq[i - 1]
    
    return max(abs(max(seq)), abs(min(seq)), max(seq) - min(seq))