def S(row, i):
    return sum((v % i) for v in row)

def solution(data, col, row_begin, row_end):
    data.sort(key= lambda x: (x[col - 1], -x[0]))
    
    bits = [S(data[i - 1], i) for i in range(row_begin, row_end + 1)]
    
    result = 0
    for bit in bits:
        result ^= bit
    return result