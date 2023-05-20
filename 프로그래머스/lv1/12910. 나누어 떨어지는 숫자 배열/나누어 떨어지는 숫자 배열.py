def solution(arr, divisor):
    answer = [n for n in arr if n % divisor == 0]
    if answer:
        return sorted(answer)
    else:
        return [-1]