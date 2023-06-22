def solution(numbers):
    stack = []
    result = [-1] * len(numbers)

    for i, n in enumerate(numbers):
        while stack and numbers[stack[-1]] < n:
            result[stack.pop()] = n
        stack.append(i)

    return result

# def solution(numbers):
#     result = []
#     for i, n in enumerate(numbers):
#         try:
#             for other in numbers[i+1:]:
#                 if other > n:
#                     result.append(other)
#                     break
#             else:
#                 result.append(-1)
#         except:
#             result.append(-1)
#             break
#     return result