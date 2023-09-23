def set_a_to_z(char):
    return chr(((ord(char) - ord('a') + 1) % 26) + ord('a'))

def solution(s, skip, index):
    result = ''
    
    for char in s:
        current_char = char
        i = 0
        while i < index:
            current_char = set_a_to_z(current_char)
            if current_char in skip:
                continue
            i += 1
        result += current_char
    
    return result
