def change_radix(num, sys):
    if num == 0:
        return '0'
    # if sys == 2:
    #     return bin(num)[2:]
    # if sys == 8:
    #     return oct(num)[2:]
    # if sys == 16:
    #     return hex(num)[2:].upper()

    rev_base = ''

    if sys <= 10:
        while num > 0:
            num, mod = divmod(num, sys)
            rev_base += str(mod)
    elif sys > 10 and sys <= 16:
        dt = {'10': 'A', '11': 'B', '12': 'C',
              '13': 'D', '14': 'E', '15': 'F'}
        while num > 0:
            num, mod = divmod(num, sys)
            if mod >= 10:
                rev_base += dt[str(mod)]
            else:
                rev_base += str(mod)

    return rev_base[::-1]


def solution(n, t, m, p):
    full_numbers = ''
    result = ''

    for i in range(t * m + p):
        full_numbers += change_radix(i, n)

    result = full_numbers[p - 1::m]

    return result[:t]