# MAX_NUM_BIN = '11100011010111111010100100110001101000000000000000' # (10^15)
# MAX_LEN = len(MAX_NUM_BIN)

# def bs(n):
#     return int(format(n, '0' + str(MAX_LEN) + 'b'), 2)

# def f(n):
#     bin_string = bs(n)
    
#     next = n + 1
#     while True:
#         cnt = bin(bin_string ^ bs(next)).count('1')        
#         if cnt <= 2:
#             return next
#         next += 1
#     return -1

# def solution(numbers):
#     return [f(n) for n in numbers]

def solution(numbers):
    return [((num ^ (num+1)) >> 2) + num + 1 for num in numbers]