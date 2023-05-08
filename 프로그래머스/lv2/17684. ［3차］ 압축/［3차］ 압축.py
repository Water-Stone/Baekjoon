# [3차] 압축
def solution(msg):
    LZW_dic = [None]
    for _ in range(26):
        LZW_dic.append(chr(ord('A') + _))
    result = []

    jump_idx = 0
    for i in range(len(msg)):
        i += jump_idx
        if i > len(msg):
            break
        # curr_word = msg[i]

        if i < len(msg):
            for j in range(len(msg), i, -1):
                curr_word = msg[i:j]
                if curr_word in LZW_dic:
                    result.append(LZW_dic.index(curr_word))
                    if i == len(msg) - 1 or j == len(msg):
                        return result
                    LZW_dic.append(msg[i:j+1])
                    jump_idx += len(curr_word) - 1
                    break
        elif curr_word in LZW_dic:
            result.append(LZW_dic.index(curr_word))
            break

    return result