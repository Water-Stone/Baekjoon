import sys

def is_possible_channel(channel, broken_buttons):
    if channel == 0:
        return '0' not in broken_buttons

    while channel > 0:
        digit = channel % 10
        if str(digit) in broken_buttons:
            return False
        channel //= 10

    return True


def find_min_presses(target_channel, broken_buttons):
    current_channel = 100
    min_presses = abs(target_channel - current_channel)

    for channel in range(1000001):  # 0부터 100만까지의 범위에서 채널을 확인
        if is_possible_channel(channel, broken_buttons):
            presses = abs(target_channel - channel) + len(str(channel))
            min_presses = min(min_presses, presses)

    return min_presses


if __name__ == "__main__":
    target_channel = int(sys.stdin.readline().rstrip())
    num_broken_buttons = int(sys.stdin.readline().rstrip())
    broken_buttons = set(sys.stdin.readline().split()) if num_broken_buttons > 0 else []

    result = find_min_presses(target_channel, broken_buttons)
    print(result)
