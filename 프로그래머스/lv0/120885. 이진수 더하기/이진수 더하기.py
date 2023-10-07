def solution(bin1, bin2):
    result = []
    carry = 0

    max_len = max(len(bin1), len(bin2))
    bin1 = bin1.zfill(max_len)
    bin2 = bin2.zfill(max_len)

    for bit1, bit2 in zip(bin1[::-1], bin2[::-1]):
        total = int(bit1) + int(bit2) + carry
        result.append(str(total % 2))
        carry = total // 2

    if carry:
        result.append(str(carry))

    return ''.join(result[::-1])